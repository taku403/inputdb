package com.example.input.controller.misc.buyer;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.controller.Init;
import com.example.input.dao.misc.admin.PartDao;
import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.buyer.Order;

@Controller
public class OrderController extends Init {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PartDao partDao;
	@Autowired
	private EmployeeDao employeeDao;
	private String path = "buyer/order/";

	@RequestMapping(value = "/buyer/order/list")
	String listGet(Model model) throws Exception {

		List<Order> orderList = orderDao.findAll();

		model.addAttribute("orders", orderList);

		return path + "list";

	}

	@RequestMapping(value = "/buyer/order/add")
	String addGet(Model model, HttpSession session) throws Exception {

		System.out.println("call orderAdd");
		List<Part> partList = partDao.findAll();
		Order order = new Order();
		String loginId = (String) session.getAttribute("loginId");
		Employee employee = employeeDao.findByloginId(loginId.toString());
		System.out.println(employee.getName());
		order.setEmployee(employee);
		System.out.println("called findall");
		model.addAttribute("parts", partList);
		model.addAttribute("order", new Order());
		model.addAttribute("loginId", loginId);

		System.out.println(employee.getName());

		return path + "add";
	}

	@RequestMapping(value = "/buyer/order/add", method = RequestMethod.POST)
	String addPost(@Valid Order order, Errors errors, Model model,HttpSession session) throws Exception {
		System.out.println("call emp");
		String loginId = (String) session.getAttribute("loginId");
		Employee employee = employeeDao.findByloginId(loginId.toString());
		order.setEmployee(employee);
		System.out.println("call date");
		order.setOrderDate(new Date());
		System.out.println(order.getOrderDate());
		System.out.println("call quant");
		System.out.println(order.getQuantity());
		System.out.println("call part");
		System.out.println(order.getPart().getName());
		if (!errors.hasErrors()) {

			System.out.println("call add post");
			orderDao.insert(order);

			return path + "list";

		}
		List<Part> partsList = partDao.findAll();
		List<Employee> employeeList = employeeDao.findAll();
		model.addAttribute("order", order);
		model.addAttribute("parts", partsList);
		model.addAttribute("employees", employeeList);
		System.out.println("erro order");
		return path + "add";

	}

	@RequestMapping(value = "/buyer/order/delete/{id}")
	String deleteGet(@PathVariable Integer id) throws Exception {

		Order order = orderDao.findById(id);

		orderDao.delete(order);

		return "forward:/" + path + "list";
	}

	@RequestMapping(value = "/buyre/order/delete/{id}")
	String updateGet(@PathVariable Integer id, Model model) throws Exception {

		Order order = orderDao.findById(id);

		model.addAttribute("order", order);

		return path + "edit";
	}

	@RequestMapping(value = "/buyre/order/delete/{id}", method = RequestMethod.POST)
	String updatePost(@Valid Order order, Errors errors, Model model) throws Exception {

		orderDao.update(order);

		return "forward:/" + path + "list";
	}
}

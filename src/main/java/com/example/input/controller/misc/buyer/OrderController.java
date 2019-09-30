package com.example.input.controller.misc.buyer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	String addGet(@ModelAttribute Order order, Model model, HttpSession session) throws Exception {

		List<Part> partList = partDao.findAll();
		Employee employee = getByEmployee((String) session.getAttribute("loginId"));
		order.setEmployee(employee);
		model.addAttribute("parts", partList);
		model.addAttribute("order", order);

		return path + "add";
	}

	@RequestMapping(value = "/buyer/order/add", method = RequestMethod.POST)
	String addPost(@Valid Order order, Errors errors, Model model, HttpSession session)
			throws Exception {

		Employee employee = employeeDao.findById(order.getEmployee().getId());
		order.setEmployee(employee);
		if (!errors.hasErrors()) {
			Part part = partDao.findById(order.getPart().getId());
			order.setPart(part);
			orderDao.insert(order);
			return "redirect:/" + path + "list";
		}

		List<Part> partsList = partDao.findAll();
		model.addAttribute("order", order);
		model.addAttribute("parts", partsList);
		return path + "add";
	}

	@RequestMapping(value = "/buyer/order/delete/{id}")
	String deleteGet(@PathVariable Integer id, Model model) throws Exception {

		Order order = orderDao.findById(id);

		orderDao.delete(order);
		return "forward:/" + path + "list";
	}

	@RequestMapping(value = "/buyer/order/edit/{id}")
	String updateGet(@PathVariable Integer id, Model model, HttpSession session) throws Exception {
		System.out.println("call edit");
		Order order = orderDao.findById(id);
		Part part = order.getPart();
		List<Part> partList = partDao.findAll();
		Employee employee = getByEmployee((String) session.getAttribute("loginId"));
		order.setEmployee(employee);
		model.addAttribute("part", part);
		model.addAttribute("parts", partList);
		model.addAttribute("order", order);
		model.addAttribute("submit", "適用");
		return path + "edit";
	}

	@RequestMapping(value = "/buyer/order/edit/{id}", method = RequestMethod.POST)
	String updatePost(@ModelAttribute @Validated Order order, BindingResult errors, Model model) throws Exception {
		System.out.println("call post edit");
		Part part = partDao.findById(order.getPart().getId());
		Employee employee = employeeDao.findById(order.getEmployee().getId());
		order.setEmployee(employee);
		order.setPart(part);
		if (!errors.hasErrors()) {

			orderDao.update(order);
			return "forward:/" + path + "list";

		}
			System.out.println(errors);

		List<Part> partList = partDao.findAll();
		model.addAttribute("parts", partList);
		model.addAttribute("order", order);
		return path + "edit";
	}

	@InitBinder
	public void Binder(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}

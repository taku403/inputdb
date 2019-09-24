package com.example.input.controller.misc.buyer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.dao.misc.admin.PartDao;
import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.buyer.Order;

@Controller
public class OrderController {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PartDao partDao;
	private String path = "buyer/order/";

	@RequestMapping(value = "/buyer/order/list")
	String listGet(Model model) throws Exception {

		List<Order> orderList = orderDao.findAll();

		model.addAttribute("orders", orderList);

		return path + "list";

	}

	@RequestMapping(value = "/buyer/order/add")
	String addGet(Model model) throws Exception {

		List<Part> partList = partDao.findAll();
		model.addAttribute("parts", partList);
		model.addAttribute("order", new Order());

		return path + "add";
	}

	@RequestMapping(value = "/buyer/order/add", method = RequestMethod.POST)
	String addPost(@Valid Order order, Errors errors, Model model) throws Exception {

		if (!errors.hasErrors()) {

			orderDao.insert(order);

			return "redirect:/" + path + "list";

		}
		List<Part> partsList = partDao.findAll();
		model.addAttribute("order", order);
		model.addAttribute("parts", partsList);

		return path + "list";

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

	@RequestMapping(value = "/buyre/order/delete/{id}", method=RequestMethod.POST)
	String updatePost(@Valid Order order, Errors errors, Model model) throws Exception {

		orderDao.update(order);

		return "forward:/" + path + "list";
	}
}

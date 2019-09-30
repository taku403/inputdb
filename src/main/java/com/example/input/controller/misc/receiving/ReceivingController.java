package com.example.input.controller.misc.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.input.dao.misc.admin.PartDao;
import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.dao.misc.receiving.QuantityTypeDao;
import com.example.input.domain.misc.receiving.Receiving;

@Controller
public class ReceivingController {

	@Autowired
	private PartDao partDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private QuantityTypeDao quantityTypeDao;

	@RequestMapping(value = "/receiving/form")
	String formGet(@ModelAttribute Receiving receiving, Model model) {

		return null;
	}

}

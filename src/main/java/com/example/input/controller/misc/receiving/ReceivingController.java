package com.example.input.controller.misc.receiving;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.input.controller.Init;
import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.buyer.Order;
import com.example.input.domain.misc.receiving.Receiving;

@Controller
public class ReceivingController extends Init{

	@Autowired
	private OrderDao orderDao;
	private String path = "/receiving/";

	@RequestMapping(value = "/receiving/form")
	String formGet(Model model,HttpSession session) throws Exception {

		Receiving receiving = new Receiving();
		List<Order> orders = orderDao.findAll();
		String loginId = (String)session.getAttribute("loginId");
		Employee employee = getByEmployee(loginId);
		receiving.setEmployee(employee);
		model.addAttribute("orders", orders);
		model.addAttribute("receiving", receiving);
		
		return path + "form";
	}

	@InitBinder
	public void Binder(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}

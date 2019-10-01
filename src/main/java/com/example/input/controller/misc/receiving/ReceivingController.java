package com.example.input.controller.misc.receiving;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.controller.Init;
import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.domain.AddGroup;
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
	@RequestMapping(value = "/receiving/form", method=RequestMethod.POST)
	String formPost(@Validated(AddGroup.class) Receiving receiving, Errors errors, Model model,HttpSession session) throws Exception {

		if(!errors.hasErrors()) {

			Order order = orderDao.findById(receiving.getOrder().getId());
			if(order.getQuantity() > receiving.getQuantity()) {

				//注文数量から受付数量を引く
				Integer quantity = (order.getQuantity() - receiving.getQuantity());
				order.setQuantity(quantity);
				//注文数量の更新
				orderDao.update(order);

				receiving.setComplete("off");
				receiving.setOrder(order);


			}

		}
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

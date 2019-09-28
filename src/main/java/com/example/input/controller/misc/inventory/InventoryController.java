package com.example.input.controller.misc.inventory;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryController {

	private String path = "inventory/index";


	@RequestMapping(value="/inventory/index")
	public String indexGet(Model model, HttpSession session) {

		model.addAttribute("loginId", (String)session.getAttribute("loginId"));
		return path;
	}

}

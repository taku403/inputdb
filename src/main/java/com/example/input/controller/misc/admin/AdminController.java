package com.example.input.controller.misc.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.input.controller.Init;

@Controller
public class AdminController extends Init{


	@RequestMapping(value="/admin/index")
	String indexGet(Model model,HttpSession session) {

		System.out.println("index -> " + session.getAttribute("loginId"));
		model.addAttribute("loginId", (String)session.getAttribute("loginId"));
		return "admin/index";
	}

}

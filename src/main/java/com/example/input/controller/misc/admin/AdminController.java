package com.example.input.controller.misc.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


	@RequestMapping(value="/admin/index")
	String indexGet() {

		return "admin/index";
	}

}

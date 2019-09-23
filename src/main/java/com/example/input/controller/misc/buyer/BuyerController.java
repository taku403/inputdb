package com.example.input.controller.misc.buyer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyerController {



	private String path = "buyer/";


	@RequestMapping(value="/buyer/index")
	public String index() {

		return path + "index";
	}

}

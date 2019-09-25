package com.example.input.controller.misc.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryController {

	private String path = "inventory/index";


	@RequestMapping(value="/inventory/index")
	public String indexGet() {

		return path;
	}

}

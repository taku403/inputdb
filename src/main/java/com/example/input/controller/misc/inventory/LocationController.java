package com.example.input.controller.misc.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.dao.misc.inventory.LocationDao;
import com.example.input.domain.AddGroup;
import com.example.input.domain.misc.inventory.Location;

@Controller
public class LocationController {

	@Autowired
	LocationDao locationDao;
	String path = "inventory/location/";

	@RequestMapping(value = "/inventory/location/add")
	String addGet(@ModelAttribute Location location) {
		return path + "add";
	}

	@RequestMapping(value = "/inventory/location/add", method=RequestMethod.POST)
	String addPost(@ModelAttribute @Validated(AddGroup.class) Location location,BindingResult result) throws Exception {

		if(!result.hasErrors()) {

			locationDao.insert(location);

			return "forward:/inventory/index";
		}
		System.out.println(result);
		return path + "add";
	}

}

package com.example.input.controller.misc.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.input.dao.misc.admin.PartDao;

@Controller
public class Detail {


	@Autowired
	private PartDao partDao;

}

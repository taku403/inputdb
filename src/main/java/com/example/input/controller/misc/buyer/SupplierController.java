package com.example.input.controller.misc.buyer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.dao.misc.buyer.SupplierDao;
import com.example.input.domain.misc.buyer.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDao supplierDao;
	private String path = "buyer/supplier/";

	@RequestMapping(value="/buyer/supplier/list")
	String listGet(Model model) throws Exception {
		List<Supplier> supplierList = supplierDao.findAll();
		model.addAttribute("suppliers", supplierList);

		return path + "list";

	}

	@RequestMapping(value="/buyer/supplier/add")
	String addGet(Model model) {

		model.addAttribute("supplier", new Supplier());

		return path + "add";

	}

	@RequestMapping(value="/buyer/supplier/add",method=RequestMethod.POST)
	String addPost(@Valid Supplier supplier, Errors errors, Model model) throws Exception {

		if(!errors.hasErrors()) {

			supplierDao.insert(supplier);
			return path + "list";
		}


		model.addAttribute("supplier", supplier);
		return path + "add";

	}

	@RequestMapping(value="/buyer/supplier/edit/{id}",method=RequestMethod.GET)
	String editGet(@PathVariable Integer id, Model model) throws Exception {

		Supplier supplier = supplierDao.findById(id);

		model.addAttribute("supplier", supplier);

		return path + "edit";
	}

	@RequestMapping(value="/buyer/supplier/edit/{id}", method=RequestMethod.POST)
	String editPost(@Valid Supplier supplier, Errors errors, Model model) throws Exception {

		if(!errors.hasErrors()) {

			supplierDao.insert(supplier);

			return path + "list";
		}

		model.addAttribute("supplier", supplier);
		return path + "edit";
	}

	@RequestMapping(value="/buyer/supplier/delete/{id}",method=RequestMethod.GET)
	String deleteGet(@PathVariable Integer id, Model model) throws Exception {


		Supplier supplier = supplierDao.findById(id);
		supplierDao.delete(supplier);


		return path + "list";
	}
}

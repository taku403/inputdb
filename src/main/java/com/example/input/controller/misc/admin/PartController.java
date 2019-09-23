package com.example.input.controller.misc.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.dao.misc.admin.PartDao;
import com.example.input.dao.misc.buyer.SupplierDao;
import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.buyer.Supplier;

@Controller
public class PartController {

	@Autowired
	PartDao partDao;
	@Autowired
	SupplierDao supplierDao;
	String path = "admin/parts/";

	@RequestMapping(value="/admin/parts/list")
	String listGet(Model model) throws Exception {

		List<Part> partsList = partDao.findAll();
		model.addAttribute("parts", partsList);

		return path + "list";
	}

	@RequestMapping(value="/admin/parts/edit/{id}")
	String editGet(@PathVariable Integer id, Model model) throws Exception {

		Part part = partDao.findById(id);
		List<Supplier> supplierList = supplierDao.findAll();
		model.addAttribute("part", part);
		model.addAttribute("suppliers", supplierList);


		return path + "edit";

	}

	@RequestMapping(value="/admin/parts/edit/{id}",method=RequestMethod.POST)
	String editGet(@Valid Part part, Errors errors, Model model) throws Exception {


		if(!errors.hasErrors()) {

			partDao.update(part);
			List<Part> partList = partDao.findAll();
			model.addAttribute("parts", partList);
			return path + "list";
		}

		model.addAttribute("part", part);
		return path + "edit";

	}@RequestMapping(value="/admin/parts/add")
	String addGet(Model model) throws Exception {

		List<Supplier> supplierList = supplierDao.findAll();
		model.addAttribute("part", new Part());
		model.addAttribute("suppliers", supplierList);

		return path + "add";
	}

	@RequestMapping(value="/admin/parts/add", method=RequestMethod.POST)
	String addPost(@Valid Part part, Errors errors, Model model) throws Exception {

		if(!errors.hasErrors()) {

			partDao.insert(part);
			List<Part> partlist = partDao.findAll();

			model.addAttribute("parts", partlist);
			return path + "list";
		}

		List<Supplier> supplierList = supplierDao.findAll();
		model.addAttribute("suppliers", supplierList);
		model.addAttribute("part", part);

		return path + "add";
	}

	@RequestMapping(value="/admin/parts/delete/{id}", method=RequestMethod.GET)
	String delete(@PathVariable Integer id) throws Exception {
		Part part = partDao.findById(id);
		partDao.delete(part);

		return path + "list";
	}


	@RequestMapping(value="/admin/parts/object/{part.id}", method=RequestMethod.GET)
	String objectGet(@PathVariable("part.id") Integer id, Errors errors, Model model) throws Exception {

			Part part = partDao.findById(id);

			model.addAttribute("part", part);


			return path + "object";
	}

	@RequestMapping(value="/admin/parts/object/{partId}")
	String detailGet(@PathVariable Integer partId, Model model) throws Exception {

		Part part = partDao.findById(partId);

		model.addAttribute("part", part);
		return "forward:/admin/parts/object";
	}


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(sdf, true));
	}
}

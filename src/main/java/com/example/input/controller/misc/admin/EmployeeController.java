package com.example.input.controller.misc.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.dao.misc.AddGroup;
import com.example.input.dao.misc.department.DepartmentDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.misc.admin.Department;
import com.example.input.domain.misc.admin.Employee;
//
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	private String path = "admin/employee/";

	@RequestMapping(value = "/admin/employee/list",method=RequestMethod.GET)
	String listGet(Model model) throws Exception {
		List<Employee> employeeList = employeeDao.findAll();
		model.addAttribute("employees", employeeList);

		return path + "list";
	}

	@RequestMapping(value = {"/admin/employee/add", "/add"})
	public String addEmployeeGet(Model model) throws Exception {
		List<Department> departmentList = departmentDao.findAll();
		model.addAttribute("employee", new Employee());
		model.addAttribute("departments", departmentList);
		return path + "add";
	}


	@RequestMapping(value = "/admin/employee/add", method = RequestMethod.POST)
	public String addEmployeePost(
			@Validated(AddGroup.class) Employee employee, Errors errors,
			Model model) throws Exception {
		List<Department> departmetList = departmentDao.findAll();
		if (!errors.hasErrors()) {
			System.out.println("call addEmpPost");
			employeeDao.insert(employee);
			model.addAttribute("employee", employee);
			return path + "done";
		}

		model.addAttribute("departments", departmetList);
		model.addAttribute("employee", employee);
		return path + "add";
	}

	@RequestMapping(value ="/admin/employee/edit/{id}", method=RequestMethod.GET)
	public String editGet(@PathVariable Integer id, Model model) throws Exception {
		Employee employee = employeeDao.findById(id);
		List<Department> departmentList = departmentDao.findAll();
		model.addAttribute("departments", departmentList);
		model.addAttribute("employee", employee);
		return path + "edit";
	}

	@RequestMapping(value="/admin/employee/edit/{id}", method=RequestMethod.POST)
	public String editPost(@Validated(AddGroup.class) Employee employee, Errors errors,Model model) throws Exception {

		if(!errors.hasErrors()) {

			employeeDao.update(employee);

			return "redirect:/" + path + "list";
		}

		model.addAttribute("employee", employee);
		return path + "edit";

	}
	@RequestMapping(value="/admin/employee/delete/{id}")
	public String deleteGet(@PathVariable Integer id) throws Exception {

		Employee employee = employeeDao.findById(id);
		employeeDao.delete(employee);

		return "redirect:/" + path + "list";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(sdf, true));
	}
}
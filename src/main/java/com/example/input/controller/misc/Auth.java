package com.example.input.controller.misc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.controller.Init;
import com.example.input.dao.misc.department.DepartmentDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.AddGroup;
import com.example.input.domain.LoginGroup;
import com.example.input.domain.misc.admin.Department;
import com.example.input.domain.misc.admin.Employee;

/**
 *
 * @author zd2F20
 *ログイン認証の管理
 *ログアウトの管理
 */
@Controller
public class Auth extends Init{

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping(value = { "/", "/login" })
	public String loginGet(Model model, HttpSession session) {

		String loginId = (String) session.getAttribute("loginId");
		System.out.println("ログインID：" + loginId);
		if (loginId != null) {

			model.addAttribute("employee", new Employee());
			model.addAttribute("loginId", loginId);

			return "login";
		} else {

			model.addAttribute("notLogin", "ログインしてください。");
			model.addAttribute("employee", new Employee());

			return "login";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@Validated(LoginGroup.class) Employee employee, Errors errors, Model model,
			HttpSession session) throws Exception {

		if (!errors.hasErrors()) {
			//			ログイン認証の処理を開始
			System.out.println("call login Id");
			Employee loginEmployee = employeeDao.findByloginId(employee.getLoginId());
			if (loginEmployee != null) {

				session.setAttribute("loginId", loginEmployee.getLoginId());
				model.addAttribute("loginName", loginEmployee.getName());
				return "redirect:/admin/index";
			} else {
				model.addAttribute("loginErr", "ログインIDかログインパスワードが正しくありません。");
			}
		}

		model.addAttribute("employee", employee);
		System.out.println("failed loginId");
		return "login";
	}

	@RequestMapping(value="/logout")
	public String registerGet(Model model,HttpServletRequest request) {

		request.getSession().invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/register")
	public String registerGet(Model model) throws Exception {

		List<Department> departmentList = departmentDao.findAll();
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentList);

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(@Validated(AddGroup.class) Employee employee, Errors errors, Model model,
			HttpServletRequest request)
			throws Exception {

		List<Department> departmentList = departmentDao.findAll();
		if (!errors.hasErrors()) {
			System.out.println("not err");
			employeeDao.insert(employee);
			model.addAttribute("permissions", employee.getPermssions());
			model.addAttribute("employee", employee);
			return "done";
		}
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentList);

		System.out.println("err");
		return "register";
	}
}
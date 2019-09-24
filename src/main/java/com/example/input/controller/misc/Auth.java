package com.example.input.controller.misc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.dao.misc.LoginGroup;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.misc.admin.Employee;

/**
 *
 * @author zd2F20
 *ログイン認証の管理
 *ログアウトの管理
 */
@Controller
public class Auth {

	@Autowired
	private EmployeeDao employeeDao;


	@RequestMapping(value = {"/",  "/login"} )
	public String loginGet(Model model) {

		model.addAttribute("employee", new Employee());

		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@Validated(LoginGroup.class) Employee employee, Errors errors, Model model,
			HttpSession session) throws Exception {

		if (!errors.hasErrors()) {
			//			ログイン認証の処理を開始
			//			String loginPass = employee.getLoginPass();
			System.out.println("call login Id");
			employee = employeeDao.findByLoginIdandLoginPass(employee.getLoginId());
			if (employee != null) {

				session.setAttribute("loginId", employee.getLoginId());			}
			return "redirect:/admin/index";
		}
		model.addAttribute("employee", employee);
		return "login";
	}
}
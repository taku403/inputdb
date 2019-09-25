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

import com.example.input.dao.misc.admin.PermissionDao;
import com.example.input.dao.misc.department.DepartmentDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.domain.AddGroup;
import com.example.input.domain.LoginGroup;
import com.example.input.domain.misc.admin.Department;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Permission;

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
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private PermissionDao permissionDao;

	@RequestMapping(value = { "/", "/login" })
	public String loginGet(Model model) {

		model.addAttribute("employee", new Employee());

		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@Validated(LoginGroup.class) Employee employee, Errors errors, Model model,
			HttpSession session) throws Exception {

		if (!errors.hasErrors()) {
			//			ログイン認証の処理を開始
			System.out.println("call login Id");
			Employee  loginEmployee  = employeeDao.findByLoginIdandLoginPass(employee.getLoginId());
			if (loginEmployee != null) {

				session.setAttribute("loginId", employee.getLoginId());
				return "redirect:/admin/index";
			}
			else {
				model.addAttribute("loginErr", "ログインIDかログインパスワードが間違っています。");
			}
		}

		model.addAttribute("employee", employee);
		System.out.println("failed loginId");
		return "login";
	}


	@RequestMapping(value="/new")
	public String newGet(Model model) throws Exception {

		List<Department> departmentList = departmentDao.findAll();
		List<Permission> permissionList = permissionDao.findAll();

		model.addAttribute("employee", new Employee());
		model.addAttribute("departments", departmentList);
		model.addAttribute("permissions", permissionList);
		Permission permission = permissionList.get(1);
		System.out.println(permission.getName());
		return "new";
	}


	@RequestMapping(value="/new", method= RequestMethod.POST)
	public String newPost(@Validated(AddGroup.class) Employee employee, Errors errors, HttpServletRequest request) {

		if(!errors.hasErrors()) {

			String[] permissions = request.getParameterValues("permissions");

			for(String permissionId : permissions) {

				if(permissionId.equals("1"))
			}
		}

		return null;
	}
}
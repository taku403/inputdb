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

import com.example.input.dao.misc.admin.AdminDao;
import com.example.input.dao.misc.admin.PermissionDao;
import com.example.input.dao.misc.buyer.BuyerDao;
import com.example.input.dao.misc.department.DepartmentDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.dao.misc.inventory.InventoryManagerDao;
import com.example.input.dao.misc.receiving.ReceptionDao;
import com.example.input.domain.AddGroup;
import com.example.input.domain.LoginGroup;
import com.example.input.domain.misc.admin.Department;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.PermissionCheckboxModel;

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
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ReceptionDao receptionDao;
	@Autowired
	private BuyerDao buyerDao;
	@Autowired
	private InventoryManagerDao inventoryManagerDao;

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
			Employee loginEmployee = employeeDao.findByLoginIdandLoginPass(employee.getLoginId());
			if (loginEmployee != null) {

				session.setAttribute("loginId", employee.getLoginId());
				return "redirect:/admin/index";
			} else {
				model.addAttribute("loginErr", "ログインIDかログインパスワードが間違っています。");
			}
		}

		model.addAttribute("employee", employee);
		System.out.println("failed loginId");
		return "login";
	}

	@RequestMapping(value = "/register")
	public String newGet(Model model) throws Exception {

		List<Department> departmentList = departmentDao.findAll();
		List<PermissionCheckboxModel> permissionList = permissionDao.findAll();

		model.addAttribute("employee", new Employee());
		model.addAttribute("departments", departmentList);
		model.addAttribute("permissions", permissionList);
		PermissionCheckboxModel permission = permissionList.get(1);
		System.out.println(permission.getName());
		return "new";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String newPost(@Validated(AddGroup.class) Employee employee, Errors errors, Model model,
			HttpServletRequest request)
			throws Exception {

		List<Department> departmentList = departmentDao.findAll();

		if (!errors.hasErrors()) {


		}
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentList);
		model.addAttribute("permissions", permissionList);

		return "new";
	}
}
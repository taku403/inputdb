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
import com.example.input.dao.misc.admin.AdminDao;
import com.example.input.dao.misc.buyer.BuyerDao;
import com.example.input.dao.misc.employee.EmployeeDao;
import com.example.input.dao.misc.inventoryManager.InventoryManagerDao;
import com.example.input.dao.misc.recipient.RecipientDao;
import com.example.input.domain.misc.InventoryManager;
import com.example.input.domain.misc.Recipient;
import com.example.input.domain.misc.admin.Admin;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.buyer.Buyer;

/**
 *
 * @author zd2F20
 *ログイン認証の管理
 *ログアウトの管理
 */
@Controller
public class Auth {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private BuyerDao buyerDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private RecipientDao recipientDao;
	@Autowired
	private InventoryManagerDao inventoryManagerDao;


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
			employee = employeeDao.findByLoginIdandLoginPass(employee.getLoginId());
			if (employee != null) {
				Admin admin = adminDao.findByEmployee(employee);
				if (admin != null)
					return "redirect:/addEmployee";
				Buyer buyer = buyerDao.findByEmployee(employee);
				if (buyer != null)
					return "redirect:/order/index";
				Recipient recipient = recipientDao.findByEmployee(employee);
				if (recipient != null)
					return "redirect:/receiving/index";
				InventoryManager inventoryManager = inventoryManagerDao.findByEmployee(employee);
				if (inventoryManager != null)
					return "redirect:/inventory/index";
				return "redirect:/home";

			}
		}
		return "login";
	}
}
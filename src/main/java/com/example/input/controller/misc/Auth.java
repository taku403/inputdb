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
import com.example.input.domain.misc.admin.Admin;
import com.example.input.domain.misc.admin.Department;
import com.example.input.domain.misc.admin.Employee;
import com.example.input.domain.misc.admin.Permission;
import com.example.input.domain.misc.buyer.Buyer;
import com.example.input.domain.misc.inventory.InventoryManager;
import com.example.input.domain.misc.receiving.Reception;

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

	@RequestMapping(value = "/new")
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

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newPost(@Validated(AddGroup.class) Employee employee, Errors errors, Model model,
			HttpServletRequest request)
			throws Exception {

		List<Department> departmentList = departmentDao.findAll();
		List<Permission> permissionList = permissionDao.findAll();

		if (!errors.hasErrors()) {

			//			権限付与のチェックボックスから選択された文字列を取得し各権限テーブルに従業員情報を格納する。
			String[] permissions = request.getParameterValues("permissions");
			//			バリデーション：チェックボックスに最低１つは選択されてること
			if (permissions != null) {
				for (String group : permissions) {

					System.out.println(group.toString());

					//				チェックボックスにチェックされてるなら従業員情報を各テーブルに格納する。
					if (group.toString().equalsIgnoreCase("admin")) {

						Admin admin = new Admin();
						admin.setEmployee(employee);
						adminDao.insert(admin);
					}
					if (group.toString().equalsIgnoreCase("reception")) {

						Reception reception = new Reception();
						reception.setEmployee(employee);
						receptionDao.insert(reception);
					}

					if (group.toString().equalsIgnoreCase("buyer")) {

						Buyer buyer = new Buyer();
						buyer.setEmployee(employee);
						buyerDao.inesrt(buyer);
					}
					if (group.toString().equalsIgnoreCase("inventoryManager")) {

						InventoryManager inventoryManager = new InventoryManager();
						inventoryManager.setEmployee(employee);
						inventoryManagerDao.insert(inventoryManager);
					}
				}

				return "done";
			} else {
				//				checkboxエラー：何も選択されてない
				model.addAttribute("checkBoxErr", "いずれか１つ以上選択してください。");
				model.addAttribute("employee", employee);
				model.addAttribute("departments", departmentList);
				model.addAttribute("permissions", permissionList);

				return "nuw";
			}

		}
		model.addAttribute("employee", employee);
		model.addAttribute("departments", departmentList);
		model.addAttribute("permissions", permissionList);

		return "new";
	}
}
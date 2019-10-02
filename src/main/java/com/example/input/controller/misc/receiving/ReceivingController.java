package com.example.input.controller.misc.receiving;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.controller.Init;
import com.example.input.dao.misc.buyer.OrderDao;
import com.example.input.dao.misc.inventory.InventoryDao;
import com.example.input.dao.misc.inventory.LocationDao;
import com.example.input.dao.misc.receiving.ReceivingDao;
import com.example.input.domain.AddGroup;
import com.example.input.domain.misc.buyer.Order;
import com.example.input.domain.misc.inventory.Inventory;
import com.example.input.domain.misc.receiving.Receiving;

@Controller
public class ReceivingController extends Init {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ReceivingDao receivingDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private LocationDao locationDao;
	private String path = "/receiving/";

	@RequestMapping(value = "/receiving/form")
	String formGet(Model model, HttpSession session) throws Exception {

		Receiving receiving = new Receiving();
		List<Order> orders = orderDao.findAll();
		String loginId = (String) session.getAttribute("loginId");
		receiving.setEmployee(loginId);
		model.addAttribute("orders", orders);
		model.addAttribute("receiving", receiving);

		return path + "form";
	}

	@RequestMapping(value = "/receiving/form", method = RequestMethod.POST)
	String formPost(@Validated(AddGroup.class) Receiving receiving, BindingResult errors, Model model, HttpSession session)
			throws Exception {
		//入力オブジェクトの生成と代入
		String loginId = (String) session.getAttribute("loginId");
		receiving.setEmployee(loginId);
		receiving.setOrder(receiving.getOrder().getId());

		System.out.println(receiving.getCreated());

		System.out.println(receiving.getEmployee().getName());
		System.out.println(receiving.getOrder().getEmployee().getName());

		if (!errors.hasErrors()) {
			//分割納品処理

			//受け入れ総数が注文数量に満たさなければ分納状態とみなし注文未完納処理をする
			if (!receiving.isComplete()) {

				//注文残数を注文票にセットし更新する
				orderDao.update(receiving.getOrder());

				//				List<Order> orders = orderDao.findAll();
				//				model.addAttribute("orders", orders);

			} else {

				//受け入れ数が注文数に達した場合は受け入れ完了とみなし注文情報を削除する
				//注文完了フラグ
				//orderDao.delete(order);

			}

			//在庫に受け入れた部品の点数を追加する。

			Inventory inventory = inventoryDao.findByPart(receiving.getOrder().getPart());
			//部品の在庫情報が未登録の場合は新規部品とみなし部品を未登録倉庫に登録し挿入する。
			if (inventory == null) {

				inventory = new Inventory();
				inventory.setAmount(receiving.getQuantity());
				//ロケーションID１番は未登録倉庫：
				inventory.setLocation(locationDao.findById(1));
				inventory.setPart(receiving.getOrder().getPart().getId());

				inventoryDao.insert(inventory);
			} else {
				//在庫数に受けれ数量を追加した数
				Integer amount = inventory.getAmount() + receiving.getQuantity();
				inventory.setAmount(amount);
				//すでに部品が存在する在庫情報を更新する
				inventoryDao.update(inventory);
			}

			//受付情報に必要な情報をセットし挿入する
			receiving.setOrder(receiving.getOrder().getId());
			receiving.setEmployee(loginId);
			receivingDao.insert(receiving);

			List<Order> orders = orderDao.findAll();
			model.addAttribute("orders", orders);
			return "redirect:/" + path + "form";

		}
		for(int i = 0; i < 1000; i++) {
			System.out.println(errors);
		}
		List<Order> orders = orderDao.findAll();
		receiving.setEmployee(loginId);
		model.addAttribute("orders", orders);
		model.addAttribute("receiving", receiving);

		return "redirect:/" + path + "form";
	}


	@InitBinder
	public void Binder(WebDataBinder binder) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}

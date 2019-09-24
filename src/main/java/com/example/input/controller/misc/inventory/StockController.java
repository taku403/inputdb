package com.example.input.controller.misc.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.input.controller.Init;
import com.example.input.dao.misc.inventory.LocationDao;
import com.example.input.dao.misc.inventory.StockDao;
import com.example.input.domain.misc.inventory.Location;
import com.example.input.domain.misc.inventory.Stock;

@Controller
public class StockController extends Init{


	@Autowired
	private StockDao stockDao;
	@Autowired
	private LocationDao locationDao;
	private String path = "inventory/stock/";

	@RequestMapping(value="/inventory/stock/list")
	String listGet(Model model) throws Exception {

		List<Location> locationList = locationDao.findAll();
		List<Stock> stockList = stockDao.findAll();

		model.addAttribute("locations", locationList);
		model.addAttribute("stocks", stockList);

		return path + "list";
	}

	@RequestMapping(value="/inventory/stock/add")
	String addGet(Model model) throws Exception {

		List<Location> locationList = locationDao.findAll();

		model.addAttribute("locations", locationList);
		model.addAttribute("stock",new Stock());

		return path + "add";
	}
}

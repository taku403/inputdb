package com.example.input.controller.misc.inventory;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.input.controller.Init;
import com.example.input.dao.misc.admin.PartDao;
import com.example.input.dao.misc.inventory.InventoryDao;
import com.example.input.dao.misc.inventory.LocationDao;
import com.example.input.domain.misc.admin.Part;
import com.example.input.domain.misc.inventory.Inventory;
import com.example.input.domain.misc.inventory.Location;

@Controller
public class InventoryController extends Init{

	private String path = "inventory/";

	@Autowired
	private LocationDao locationDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private PartDao partDao;

	@RequestMapping(value = "/inventory/index")
	public String indexGet(Model model) throws Exception {

		List<Location> locations = locationDao.findAll();
		model.addAttribute("locations", locations);

		return path + "index";
	}

	@RequestMapping(value = "/inventory/list/{id}")
	public String listGet(@PathVariable Integer id, Model model) throws Exception {

		Location location = locationDao.findById(id);
		List<Inventory> inventories = inventoryDao.findByLocation(location);
		List<Part> parts = partDao.findAll();

		model.addAttribute("location", location);
		model.addAttribute("inventories", inventories);
		model.addAttribute("parts", parts);
		return path + "list";
	}

	@RequestMapping(value = "/inventory/add")
	public String addGet(Model model) throws Exception {

		List<Part> parts = partDao.findAll();
		List<Location> locations = locationDao.findAll();

		model.addAttribute("parts", parts);
		model.addAttribute("locations", locations);

		return path + "add";
	}


	@RequestMapping(value = "/inventory/edit/{id}")
	String editGet(@PathVariable Integer id, Model model) throws Exception {

		Inventory inventory = inventoryDao.findById(id);
		Part part = inventory.getPart();
		List<Location> locations = locationDao.findAll();

		List<Inventory> inventories = inventoryDao.findByParts(part);
		List<Part> parts = partDao.findAll();
		List<Location> partsLocations = partsAlreadyLocation(inventories);
		model.addAttribute("partsLocations", partsLocations);
		model.addAttribute("inventory", inventory);
		model.addAttribute("locations", locations);
		model.addAttribute("parts", parts);
		model.addAttribute("submit", "適用");
		return path + "edit";

	}

	@RequestMapping(value = "/inventory/edit/{id}", method = RequestMethod.POST)
	String editPost(@Valid @ModelAttribute Inventory inventory, BindingResult result, Model model) throws Exception {
		if(inventory.getPart() == null) {

			System.out.println("parts null");
		}
		if(inventory.getLocation() == null) {
			System.out.println("locations erro");
		}
		if (!result.hasErrors()) {

			inventoryDao.insert(inventory);
			model.addAttribute("inventory", inventory);
			return path + "done";

		}
		List<Inventory> inventories = inventoryDao.findAll();
		List<Location> locations = locationDao.findAll();
		List<Location> partsLocations = partsAlreadyLocation(inventories);
		List<Part> parts = partDao.findAll();
		model.addAttribute("partsLocations", partsLocations);
		model.addAttribute("inventory", inventory);
		model.addAttribute("locations", locations);
		model.addAttribute("submit", "適用");
		model.addAttribute("parts", parts);
		System.out.println("error");
		return path + "edit";
	}

	//	部品倉庫移動を選択時に移動先に既に部品が存在するか確認
	List<Location> partsAlreadyLocation(List<Inventory> inventories) {

		List<Location> locations = new ArrayList<>();
		for (Inventory inventory : inventories) {

			locations.add(inventory.getLocation());
		}
		return locations;
	}
}
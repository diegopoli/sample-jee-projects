package com.dpoli.inventory.ws;

import java.util.List;

import javax.jws.WebService;

import com.dpoli.inventory.model.item.Item;
import com.dpoli.inventory.model.item.ItemDao;

@WebService
public class InventoryWS {

	private ItemDao itemDao = ItemDao.getInstance();

	public List<Item> getItems() {
		System.out.println("Calling method getItems()");
		return itemDao.allItemsWithNoFilter();
	}
}

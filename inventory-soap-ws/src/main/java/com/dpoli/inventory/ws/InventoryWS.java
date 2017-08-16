package com.dpoli.inventory.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.dpoli.inventory.model.item.ItemDao;
import com.dpoli.inventory.model.item.ItemsList;

@WebService
public class InventoryWS {

	private ItemDao itemDao = ItemDao.getInstance();

	@WebMethod(operationName = "searchAllItems")
	@WebResult(name = "items")
	public ItemsList getItems() {
		System.out.println("Calling method getItems()");
		return new ItemsList(itemDao.allItemsWithNoFilter());
	}

	@WebMethod(exclude = true)
	public void methodToExclude() {
		// Marks this method to NOT be exposed as a web method.
	}
}

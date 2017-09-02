package com.dpoli.inventory.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.dpoli.inventory.model.item.Filter;
import com.dpoli.inventory.model.item.Filters;
import com.dpoli.inventory.model.item.Item;
import com.dpoli.inventory.model.item.ItemDao;
import com.dpoli.inventory.model.user.AuthorizationException;
import com.dpoli.inventory.model.user.TokenDao;
import com.dpoli.inventory.model.user.TokenUser;

@WebService
public class InventoryWS {

	private ItemDao itemDao = ItemDao.getInstance();

	@WebMethod(operationName = "SearchAllItems")
	@WebResult(name = "items")
	@ResponseWrapper(localName = "allItems")
	@RequestWrapper(localName = "listAllItems")
	public List<Item> getItems() {
		System.out.println("Calling method getItems()");
		return itemDao.allItemsWithNoFilter();
	}

	@WebMethod(operationName = "SearchAllItemsWithFilter")
	@WebResult(name = "items")
	@ResponseWrapper(localName = "allItemsWithFilter")
	@RequestWrapper(localName = "listAllItemsWithFilter")
	public List<Item> getItemsByFilter(@WebParam(name = "paramFilter") Filters paramFilter) {
		System.out.println("Calling method getItemsByFilter()");
		List<Filter> filter = paramFilter.getList();
		return itemDao.allItemsWithFilter(filter);
	}

	@WebMethod(operationName = "SaveItem")
	@WebResult(name = "item")
	public Item saveItem(@WebParam(name = "item") Item item, @WebParam(name = "token", header = true) TokenUser token)
			throws AuthorizationException {

		System.out.println("Calling method saveItem()");
		System.out.println(item);
		System.out.println(token);

		// Validates token
		boolean isValid = new TokenDao().isValid(token);

		// Invalid token
		if (!isValid) {
			throw new AuthorizationException("Authorization failed!");
		}

		// Saves the item
		this.itemDao.save(item);

		return item;
	}

	@WebMethod(exclude = true)
	public void methodToExclude() {
		// Marks this method to NOT be exposed as a web method.
	}
}

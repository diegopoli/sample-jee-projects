package com.dpoli.inventory.model.item;

import java.util.List;

public class ItemsList {

	private List<Item> items;

	ItemsList() {
	}

	public ItemsList(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
}

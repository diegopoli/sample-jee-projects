package com.dpoli.inventory.model.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItemDao {

	private static Map<String, Item> ITEMS = new LinkedHashMap<>();
	private static ItemDao instance = new ItemDao();

	private ItemDao() {
		addItemsToMap();
	}

	public static ItemDao getInstance() {
		return instance;
	}

	public void save(Item item) {
		ITEMS.put(item.getCode(), item);
	}

	public List<Item> allItems(List<Filter> filters) {

		List<Item> result = new ArrayList<>();
		Collection<Item> allItems = ITEMS.values();

		if (filters == null || filters.isEmpty()) {
			result.addAll(allItems);
			return result;
		}

		for (Filter filter : filters) {
			for (Item item : allItems) {

				String type = filter.getType().getName();
				String name = filter.getName();

				if (itemHasType(item, type) && itemHasName(item, name)) {
					result.add(item);
				}
			}
		}

		return result;
	}

	// This method does not use filters.
	public ArrayList<Item> allItemsWithNoFilter() {
		return new ArrayList<>(ITEMS.values());
	}

	private boolean itemHasName(Item item, String name) {
		return item.getName().contains(name);
	}

	private boolean itemHasType(Item item, String type) {
		return item.getType().equals(type);
	}

	public Item quantityFrom(String code) {
		return ITEMS.get(code);
	}

	private void addItemsToMap() {
		ITEMS.put("MEA", new Item.Builder().withCode("MEA").withName("MEAN").withType("Book").withQuantity(5).build());
		ITEMS.put("SEO", new Item.Builder().withCode("SEO").withName("SEO for Dummies").withType("Book").withQuantity(4).build());
		ITEMS.put("RUB", new Item.Builder().withCode("RUB").withName("Beginning Rails 4").withType("Book").withQuantity(8).build());
		ITEMS.put("GAL", new Item.Builder().withCode("GAL").withName("Galaxy Tab").withType("Tablet").withQuantity(3).build());
		ITEMS.put("IP4", new Item.Builder().withCode("IP4").withName("IPhone 4 C").withType("Cellphone").withQuantity(7).build());
		ITEMS.put("IP5", new Item.Builder().withCode("IP5").withName("IPhone 5").withType("Cellphone").withQuantity(3).build());
		ITEMS.put("IP6", new Item.Builder().withCode("IP6").withName("IPhone 6 S").withType("Cellphone").withQuantity(10).build());
		ITEMS.put("MOX", new Item.Builder().withCode("MOX").withName("Moto X").withType("Cellphone").withQuantity(6).build());
		ITEMS.put("MOG", new Item.Builder().withCode("MOG").withName("Moto G").withType("Cellphone").withQuantity(8).build());
		ITEMS.put("MXX", new Item.Builder().withCode("MXX").withName("Moto MAXX").withType("Cellphone").withQuantity(2).build());
	}

}

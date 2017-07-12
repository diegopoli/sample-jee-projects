package com.dpoli.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dpoli.chainofresponsibility.Item;

public class Budget {

	private final double value;
	private final List<Item> items;

	public Budget(double value) {
		this.value = value;
		items = new ArrayList<>();
	}

	public double getValue() {
		return value;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		// Retrieves a "read-only" access to this list.
		return Collections.unmodifiableList(items);
	}
}

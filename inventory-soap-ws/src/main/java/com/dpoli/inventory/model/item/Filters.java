package com.dpoli.inventory.model.item;

import java.util.List;

public class Filters {

	private List<Filter> filters;

	Filters() {
	}

	public Filters(List<Filter> filters) {
		this.filters = filters;
	}

	public List<Filter> getList() {
		return filters;
	}
}

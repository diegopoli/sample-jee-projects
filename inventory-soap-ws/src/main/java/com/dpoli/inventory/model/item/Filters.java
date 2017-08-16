package com.dpoli.inventory.model.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Filters {

	@XmlElement(name = "filter")
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

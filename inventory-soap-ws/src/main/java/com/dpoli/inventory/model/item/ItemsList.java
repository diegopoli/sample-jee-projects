package com.dpoli.inventory.model.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemsList {

	@XmlElement(name = "item")
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

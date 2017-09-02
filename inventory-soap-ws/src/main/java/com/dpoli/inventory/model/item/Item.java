package com.dpoli.inventory.model.item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Item {

	@XmlElement(required = true)
	private String code;

	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private String type;

	@XmlElement(required = true)
	private int quantity;

	Item() {
		super();
	}

	public Item(String code, String name, String type, int quantity) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}

	Item(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Item item = (Item) obj;
		return this.code.equals(item.code);
	}

	@Override
	public String toString() {
		return String.format("Item[code='%s', name='%s', type='%s', quantity=%d]", code, name, type, quantity);
	}

	public static class Builder {

		private String code;
		private String name;
		private String type;
		private int quantity;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withType(String type) {
			this.type = type;
			return this;
		}

		public Builder withCode(String code) {
			this.code = code;
			return this;
		}

		public Builder withQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public Item build() {
			return new Item(this.code, this.name, this.type, this.quantity);
		}
	}
}

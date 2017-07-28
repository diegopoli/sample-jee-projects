package com.dpoli.store.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	// @XmlRootElement - Maps the class to an XML element.
	// @XmlAccessorType(XmlAccessType.FIELD) - Sets all fields as serialized by default.
	// JAXB requires a default constructor (with no arguments).

	private static final long serialVersionUID = 1L;

	private long id;
	private String description;
	private int quantity;
	private double price;

	public Product() {
	}

	public Product(long id, String description, int quantity, double price) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}

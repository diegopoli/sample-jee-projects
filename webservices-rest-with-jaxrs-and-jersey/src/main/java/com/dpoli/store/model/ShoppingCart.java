package com.dpoli.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoppingCart implements Serializable {

	// @XmlRootElement - Maps the class to an XML element.
	// @XmlAccessorType(XmlAccessType.FIELD) - Sets all fields as serialized by default.
	// JAXB requires a default constructor (with no arguments).

	private static final long serialVersionUID = 1L;

	private long id;
	private String address;
	private String city;
	private List<Product> products = new ArrayList<>();

	public ShoppingCart() {
	}

	public ShoppingCart add(Product product) {
		products.add(product);
		return this;
	}

	public ShoppingCart setData(String address, String city) {
		this.address = address;
		this.city = city;
		return this;
	}

	public long getId() {
		return id;
	}

	public ShoppingCart setId(long id) {
		this.id = id;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void delete(long id) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product produto = (Product) iterator.next();
			if (produto.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void replace(Product product) {
		delete(product.getId());
		add(product);
	}

	public void updateQuantity(Product product) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product p = (Product) iterator.next();
			if (p.getId() == product.getId()) {
				p.setQuantity(product.getQuantity());
				return;
			}
		}
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}

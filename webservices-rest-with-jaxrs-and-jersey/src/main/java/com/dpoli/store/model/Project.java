package com.dpoli.store.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements Serializable {

	// @XmlRootElement - Maps the class to an XML element.
	// @XmlAccessorType(XmlAccessType.FIELD) - Sets all fields as serialized by default.
	// JAXB requires a default constructor (with no arguments).

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private int startYear;

	public Project() {
	}

	public Project(long id, String name, int startYear) {
		this.id = id;
		this.name = name;
		this.startYear = startYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
}

package com.dpoli.inventory.model.user;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	private Date dateError;
	private String message;

	public InfoFault(String message, Date dateError) {
		this.message = message;
		this.dateError = dateError;
	}

	// JAX-B requires this default constructor.
	InfoFault() {
	}

}
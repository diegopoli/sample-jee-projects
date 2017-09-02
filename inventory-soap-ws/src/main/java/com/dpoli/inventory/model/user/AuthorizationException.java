package com.dpoli.inventory.model.user;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name = "AuthorizationFault")
public class AuthorizationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String message) {
		super(message);
	}

	public InfoFault getFaultInfo() {
		return new InfoFault("Token invalido", new Date());
	}
}

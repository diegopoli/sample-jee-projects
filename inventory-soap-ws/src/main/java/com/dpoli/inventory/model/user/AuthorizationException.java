package com.dpoli.inventory.model.user;

import javax.xml.ws.WebFault;

@WebFault(name = "AuthorizationFault")
public class AuthorizationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String message) {
		super(message);
	}

	public String getFaultInfo() {
		return "Invalid token!";
	}
}

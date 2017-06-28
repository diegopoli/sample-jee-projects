package com.dpoli.store.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dpoli.store.dao.ShoppingCartDAO;
import com.dpoli.store.model.ShoppingCart;

@Path("shoppingCart")
public class ShoppingCartResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String search() {
		ShoppingCart dao = new ShoppingCartDAO().search(1l);
		return dao.toXML();
	}
}

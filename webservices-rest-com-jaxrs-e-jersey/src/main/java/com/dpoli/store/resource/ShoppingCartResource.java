package com.dpoli.store.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dpoli.store.dao.ShoppingCartDAO;
import com.dpoli.store.model.ShoppingCart;
import com.thoughtworks.xstream.XStream;

@Path("shoppingCart")
public class ShoppingCartResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String search(@PathParam("id") long id) {
		ShoppingCart dao = new ShoppingCartDAO().search(id);
		return dao.toXML();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response add(String content) {
		ShoppingCart shoppingCart = (ShoppingCart) new XStream().fromXML(content);
		new ShoppingCartDAO().add(shoppingCart);
		URI location = URI.create("/shoppingCart/" + shoppingCart.getId());
		return Response.created(location).build();
	}
}

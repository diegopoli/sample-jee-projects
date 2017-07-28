package com.dpoli.store.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dpoli.store.dao.ShoppingCartDAO;
import com.dpoli.store.model.Product;
import com.dpoli.store.model.ShoppingCart;
import com.thoughtworks.xstream.XStream;

@Path("shoppingCart")
public class ShoppingCartResource {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public ShoppingCart search(@PathParam("id") long id) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		return shoppingCart;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response add(ShoppingCart shoppingCart) {
		//ShoppingCart shoppingCart = (ShoppingCart) new XStream().fromXML(content);
		new ShoppingCartDAO().add(shoppingCart);
		URI location = URI.create("/shoppingCart/" + shoppingCart.getId());
		return Response.created(location).build();
	}

	@DELETE
	@Path("{id}/products/{productId}")
	public Response deleteProduct(@PathParam("id") long id, @PathParam("productId") long productId) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		shoppingCart.delete(productId);
		return Response.ok().build();
	}

	@PUT
	@Path("{id}/products/{productId}")
	public Response updateProduct(String content, @PathParam("id") long id, @PathParam("productId") long productId) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		Product product = (Product) new XStream().fromXML(content);
		shoppingCart.replace(product);
		return Response.ok().build();
	}

	@PUT
	@Path("{id}/products/{productId}/quantity")
	public Response updateQuantity(String content, @PathParam("id") long id, @PathParam("productId") long productId) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		Product product = (Product) new XStream().fromXML(content);
		shoppingCart.updateQuantity(product);
		return Response.ok().build();
	}
}

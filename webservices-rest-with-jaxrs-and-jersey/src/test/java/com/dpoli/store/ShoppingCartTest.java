package com.dpoli.store;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dpoli.store.model.Product;
import com.dpoli.store.model.ShoppingCart;
import com.thoughtworks.xstream.XStream;

public class ShoppingCartTest {

	private HttpServer server;
	private Client client;

	@Before
	public void startServer() {
		server = Server.initServer();
	}

	@After
	public void stopServer() {
		server.stop();
	}

	@Test
	public void testUriConnection() {

		this.client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String content = target.path("/shoppingCart/1").request().get(String.class);
		Assert.assertTrue(content.contains("FIFA 2017"));
		ShoppingCart shoppingCart = (ShoppingCart) new XStream().fromXML(content);
		Assert.assertEquals("795 El Camino Real", shoppingCart.getAddress());
	}

	@Test
	public void testAddItem() {

		this.client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		ShoppingCart shoppingCart = new ShoppingCart().setId(3);
		shoppingCart.setData("1 Hacker Way", "Menlo Park, CA");
		shoppingCart.add(new Product(1, "Tablet", 10, 100.5));
		String xml = shoppingCart.toXML();
		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

		Response response = target.path("/shoppingCart").request().post(entity);
		Assert.assertEquals(201, response.getStatus());

		String location = response.getHeaderString("Location");
		String content = this.client.target(location).request().get(String.class);
		Assert.assertTrue(content.contains("Tablet"));
	}
}

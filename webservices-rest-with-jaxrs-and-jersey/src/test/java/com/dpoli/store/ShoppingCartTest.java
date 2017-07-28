package com.dpoli.store;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dpoli.store.model.Product;
import com.dpoli.store.model.ShoppingCart;

public class ShoppingCartTest {

	private HttpServer server;
	private Client client;
	private WebTarget target;

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

		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080");

		// With XStream
		//String content = target.path("/shoppingCart/1").request().get(String.class);
		//Assert.assertTrue(content.contains("FIFA 2017"));
		//ShoppingCart shoppingCart = (ShoppingCart) new XStream().fromXML(content);
		//Assert.assertEquals("795 El Camino Real", shoppingCart.getAddress());

		// With JAXB
		ShoppingCart shoppingCart = target.path("/shoppingCart/1").request().get(ShoppingCart.class);
		assertEquals("795 El Camino Real", shoppingCart.getAddress());
	}

	@Test
	public void testAddItem() {

		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080");

		ShoppingCart shoppingCart = new ShoppingCart().setId(3);
		shoppingCart.setData("1 Hacker Way", "Menlo Park, CA");
		shoppingCart.add(new Product(1, "Tablet", 10, 100.5));

		// With XStream
		//String xml = shoppingCart.toXML();
		//Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

		// With JAXB
		Entity<ShoppingCart> entity = Entity.entity(shoppingCart, MediaType.APPLICATION_XML);

		Response response = target.path("/shoppingCart").request().post(entity);
		assertEquals(201, response.getStatus());

		String location = response.getHeaderString("Location");

		// With XStream
		//String content = client.target(location).request().get(String.class);
		//Assert.assertTrue(content.contains("Tablet"));

		// With JAXB
		ShoppingCart shoppingCartLoaded = client.target(location).request().get(ShoppingCart.class);
		assertEquals("Tablet", shoppingCartLoaded.getProducts().get(0).getDescription());
	}
}

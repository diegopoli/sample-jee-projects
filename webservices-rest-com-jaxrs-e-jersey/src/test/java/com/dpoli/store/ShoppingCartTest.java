package com.dpoli.store;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dpoli.store.model.ShoppingCart;
import com.thoughtworks.xstream.XStream;

public class ShoppingCartTest {

	private HttpServer server;

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

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String content = target.path("/shoppingCart/1").request().get(String.class);
		Assert.assertTrue(content.contains("FIFA 2017"));
		ShoppingCart shoppingCart = (ShoppingCart) new XStream().fromXML(content);
		Assert.assertEquals("795 El Camino Real", shoppingCart.getAddress());
	}
}

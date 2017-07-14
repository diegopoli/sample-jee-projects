package com.dpoli.store;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private HttpServer server;
	private Client client;
	private WebTarget target;

	@Before
	public void startServer() {
		this.server = Server.initServer();
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		this.client = ClientBuilder.newClient(config);
		this.target = client.target("http://www.mocky.io");
	}

	@After
	public void stopServer() {
		this.server.stop();
	}

	@Test
	public void testUriConnection() {
		String content = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		Assert.assertTrue(content.contains("Videogame 4"));
	}
}

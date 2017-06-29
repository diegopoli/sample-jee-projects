package com.dpoli.store;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

public class ProjectTest {

	@Test
	public void testUriConnection() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String content = target.path("/project").request().get(String.class);
		Assert.assertTrue(content.contains("Project 01"));
	}
}

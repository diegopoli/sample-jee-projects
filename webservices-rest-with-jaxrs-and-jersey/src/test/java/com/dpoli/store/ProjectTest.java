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

import com.dpoli.store.model.Project;
import com.thoughtworks.xstream.XStream;

public class ProjectTest {

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
		String content = target.path("/project/1").request().get(String.class);
		Assert.assertTrue(content.contains("Project 01"));
		Project project = (Project) new XStream().fromXML(content);
		Assert.assertEquals("Project 01", project.getName());
	}

	@Test
	public void testAddProject() {

		this.client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Project project = new Project(3, "Project 03", 2017);
		String xml = project.toXML();
		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

		Response response = target.path("/project").request().post(entity);
		Assert.assertEquals(201, response.getStatus());

		String location = response.getHeaderString("Location");
		String content = this.client.target(location).request().get(String.class);
		Assert.assertTrue(content.contains("Project 03"));
	}
}

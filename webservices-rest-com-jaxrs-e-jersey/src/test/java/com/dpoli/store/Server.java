package com.dpoli.store;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

	public static void main(String[] args) throws IOException {
		// Jersey Web Application
		// Creates an HTTP server compatible with JAX-WS
		// Access the URL: http://localhost:8080/shoppingCart
		ResourceConfig config = new ResourceConfig().packages("com.dpoli.store");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("The server is running...");
		System.in.read();
		server.stop();
	}
}

package com.dpoli.store;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

	public static void main(String[] args) throws IOException {
		// http://localhost:8080/shoppingCart
		ResourceConfig config = new ResourceConfig().packages("com.dpoli.store");
		URI uri = URI.create("http://localhost:8080/");
		// Creates an HTTP server compatible with JAX-WS
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("The server is running...");
		System.in.read();
		server.stop();
	}
}

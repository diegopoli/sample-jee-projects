package com.dpoli.inventory.ws;

import javax.xml.ws.Endpoint;

public class PublishWebService {

	public static void main(String[] args) {

		InventoryWS service = new InventoryWS();
		String url = "http://localhost:8080/inventory-soap-ws";

		// Endpoints are a concrete address of a given service.
		// Here we bind the endpoint (URL) with the service implementation.
		Endpoint.publish(url, service);
	}
}

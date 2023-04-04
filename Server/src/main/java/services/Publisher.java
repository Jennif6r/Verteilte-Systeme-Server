package main.java.services;

import jakarta.xml.ws.Endpoint;
import main.java.services.impl.RegistratorImpl;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9000/register", new RegistratorImpl());
		
	}
}

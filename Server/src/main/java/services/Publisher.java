package main.java.services;

import data.AllOrders;
import jakarta.xml.ws.Endpoint;
import main.java.services.impl.RegistratorImpl;
import main.java.services.impl.RequestAktivOrderImpl;
import models.OrderList;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9000/register", new RegistratorImpl());
		Endpoint.publish("http://localhost:9000/checkForOrder", new RequestAktivOrderImpl());
//		AllOrders.addOrder(new OrderList());
	}
}

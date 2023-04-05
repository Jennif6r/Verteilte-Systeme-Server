package main.java.services;

import data.AllOrders;
import jakarta.xml.ws.Endpoint;
import main.java.services.impl.RegistratorImpl;
import main.java.services.impl.RequestAktivOrderImpl;
import main.java.services.impl.StartOrderImpl;
import models.OrderList;

public class Publisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9000/register", new RegistratorImpl());
		Endpoint.publish("http://localhost:9000/checkForOrder", new RequestAktivOrderImpl());
		Endpoint.publish("http://localhost:9000/startOrder", new StartOrderImpl());
//		AllOrders.addOrder(new OrderList());
	}
}

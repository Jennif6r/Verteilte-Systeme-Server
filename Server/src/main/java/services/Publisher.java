package main.java.services;

import jakarta.xml.ws.Endpoint;
import main.java.services.impl.AddOrderItemImpl;
import main.java.services.impl.RegistratorImpl;
import main.java.services.impl.RequestAktivOrderImpl;
import main.java.services.impl.StartOrderImpl;

public class Publisher {
	public static void main(String[] args) {
		String path = "http://localhost:9000/";
		Endpoint.publish(path + "register", new RegistratorImpl());
		Endpoint.publish(path + "checkForOrder", new RequestAktivOrderImpl());
		Endpoint.publish(path + "startOrder", new StartOrderImpl());
		Endpoint.publish(path + "addOrderItem", new AddOrderItemImpl());
//		AllOrders.addOrder(new OrderList());
	}
}

package main.java.services;

import java.io.File;
import java.io.IOException;

import jakarta.xml.ws.Endpoint;
import main.java.services.impl.AddOrderItemImpl;
import main.java.services.impl.GetNumberOfOrdersImpl;
import main.java.services.impl.LogoutImpl;
import main.java.services.impl.MergeOrderImpl;
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
		Endpoint.publish(path + "getMergedOrder", new MergeOrderImpl());
		Endpoint.publish(path + "getNumberOfOrders", new GetNumberOfOrdersImpl());
		Endpoint.publish(path + "logout", new LogoutImpl());
		try {
			new File("orders.txt").createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

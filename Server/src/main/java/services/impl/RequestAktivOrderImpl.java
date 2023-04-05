package main.java.services.impl;

import java.util.ArrayList;
import java.util.List;

import data.AllOrders;
import jakarta.jws.WebService;
import main.java.services.RequestAktivOrder;
import models.OrderList;

@WebService(endpointInterface = "main.java.services.RequestAktivOrder")
public class RequestAktivOrderImpl implements RequestAktivOrder {

	@Override
	public List<OrderList> isThereAnAktivOrder() {
		AllOrders all = new AllOrders();
		System.out.println("after new all orders" );
		List<OrderList> allOrders = all.getOrders();
		List<OrderList> activOrders = new ArrayList<OrderList>();
		System.out.println(allOrders);
		for (OrderList order: allOrders) {
			if(order.getAktiv()) {
				activOrders.add(order);
			}
		}
		return activOrders;
	}

}

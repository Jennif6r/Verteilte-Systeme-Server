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
	public String[] isThereAnAktivOrder() {
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
		return parseListToArray(activOrders);
	}

	private String[] parseListToArray(List<OrderList> orders) {
		String[] activOrderIds = new String[orders.size()];
		for (int i = 0; i < activOrderIds.length; i++) {
			activOrderIds[i] = orders.get(i).getOrderId();
		}
		return activOrderIds;
	}

}

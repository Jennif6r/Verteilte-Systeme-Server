package main.java.services.impl;

import java.util.List;

import data.AllOrders;
import jakarta.jws.WebService;
import main.java.services.RequestAktivOrder;
import models.OrderList;

@WebService(endpointInterface = "main.java.services.RequestAktivOrder")
public class RequestAktivOrderImpl implements RequestAktivOrder {

	@Override
	public boolean isThereAnAktivOrder() {
		List<OrderList> allOrders = AllOrders.getOrders();
		for (OrderList order: allOrders) {
			if(order.getStatus()) {
				return true;
			}
		}
		return false;
	}

}

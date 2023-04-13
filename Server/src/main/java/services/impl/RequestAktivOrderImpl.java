package main.java.services.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.models.OrderList;
import main.java.services.RequestAktivOrder;

@WebService(endpointInterface = "main.java.services.RequestAktivOrder")
public class RequestAktivOrderImpl implements RequestAktivOrder {

	@Override
	public String[][] isThereAnAktivOrder() {
		List<OrderList> activOrders = new ArrayList<OrderList>();
		for (OrderList order: new AllOrders().getOrders()) {
			if(order.getAktiv()) {
				activOrders.add(order);
			}
		}
		return parseListToArray(activOrders);
	}

	private String[][] parseListToArray(List<OrderList> orders) {
		String[][] activOrderIds = new String[orders.size()][2];
		for (int i = 0; i < activOrderIds.length; i++) {
			activOrderIds[i][0] = orders.get(i).getUser();
			activOrderIds[i][1] = orders.get(i).getOrderId();
		}
		return activOrderIds;
	}

}

package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.services.StartOrder;
import models.OrderList;

@WebService(endpointInterface = "main.java.services.StartOrder")
public class StartOrderImpl implements StartOrder {

	@Override
	public String startOrder() {
		OrderList orderList = new OrderList();
		orderList.addOrderListToAllOrders();
		return orderList.getOrderId();
	}

}

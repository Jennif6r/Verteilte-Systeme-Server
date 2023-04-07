package main.java.services.impl;

import java.util.List;

import data.AllOrders;
import jakarta.jws.WebService;
import main.java.services.GetNumberOfOrders;
import models.Order;
import models.OrderList;

@WebService(endpointInterface = "main.java.services.GetNumberOfOrders")
public class GetNumberOfOrdersImpl implements GetNumberOfOrders{

	@Override
	public int getNumberOfOrdersFromOrderList(String orderId) {
		OrderList orderList = new AllOrders().getOrderList(orderId);
		List<Order> orders = orderList.getOrders();
		return orders.size();
	}

}

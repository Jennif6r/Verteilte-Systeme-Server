package main.java.services.impl;

import java.util.List;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.models.Order;
import main.java.models.OrderList;
import main.java.services.GetNumberOfOrders;

@WebService(endpointInterface = "main.java.services.GetNumberOfOrders")
public class GetNumberOfOrdersImpl implements GetNumberOfOrders{

	@Override
	public int getNumberOfOrdersFromOrderList(String orderId) {
		OrderList orderList = new AllOrders().getOrderList(orderId);
		List<Order> orders = orderList.getOrders();
		return orders.size();
	}

}

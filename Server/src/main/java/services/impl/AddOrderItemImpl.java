package main.java.services.impl;

import data.AllOrders;
import jakarta.jws.WebService;
import main.java.services.AddOrderItem;
import models.Order;
import models.OrderList;

@WebService(endpointInterface = "main.java.services.AddOrderItem")
public class AddOrderItemImpl implements AddOrderItem{

	@Override
	public void addOrderItem(String id, String json) {
		OrderList orderList = new AllOrders().getOrderList(id);
		Order order = JsonParser.parseToOrder(json);
		orderList.addOrder(order);
	}

}

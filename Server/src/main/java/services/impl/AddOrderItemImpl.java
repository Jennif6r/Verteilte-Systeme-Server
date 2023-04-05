package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.services.AddOrderItem;
import models.Order;
import models.OrderList;

@WebService(endpointInterface = "main.java.services.AddOrderItem")
public class AddOrderItemImpl implements AddOrderItem{

	@Override
	public void addOrderItem(OrderList orderList, Order order) {
		// TODO Auto-generated method stub
		orderList.addOrder(order);
	}

}

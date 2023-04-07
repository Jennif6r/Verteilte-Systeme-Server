package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.models.Order;
import main.java.models.OrderList;
import main.java.services.AddOrderItem;

@WebService(endpointInterface = "main.java.services.AddOrderItem")
public class AddOrderItemImpl implements AddOrderItem{

	@Override
	public void addOrderItem(String id, String json) {
		OrderList orderList = new AllOrders().getOrderList(id);
		Order order = JsonParser.parseToOrder(json);
		orderList.addOrder(order);
	}

}

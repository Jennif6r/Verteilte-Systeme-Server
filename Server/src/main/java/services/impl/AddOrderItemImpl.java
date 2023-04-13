package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.services.AddOrderItem;

@WebService(endpointInterface = "main.java.services.AddOrderItem")
public class AddOrderItemImpl implements AddOrderItem{

	@Override
	public void addOrderItem(String id, String json) {
		new AllOrders().getOrderList(id).addOrder(JsonParser.parseToOrder(json));
	}

}

package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.services.GetNumberOfOrders;

@WebService(endpointInterface = "main.java.services.GetNumberOfOrders")
public class GetNumberOfOrdersImpl implements GetNumberOfOrders{

	@Override
	public int getNumberOfOrdersFromOrderList(String orderId) {
		return new AllOrders().getOrderList(orderId).getOrders().size();
	}

}

package data;

import java.util.ArrayList;
import java.util.List;

import models.OrderList;

public class AllOrders {
	static List<OrderList> allOrders = new ArrayList<OrderList>();
	
	public static void addOrder(OrderList order) {
		allOrders.add(order);
	}
	
	public static List<OrderList> getOrders(){
		return allOrders;
	}
	
}

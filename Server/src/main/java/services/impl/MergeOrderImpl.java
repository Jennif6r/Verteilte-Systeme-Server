package main.java.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

import data.AllOrders;
import jakarta.jws.WebService;
import main.java.services.MergeOrder;
import models.Order;
import models.OrderList;
import models.Product;

@WebService(endpointInterface = "main.java.services.MergeOrder")
public class MergeOrderImpl implements MergeOrder{
	Map<String, Integer> order = new HashMap<String, Integer>();
	
	@Override
	public String getMergedOrder(String orderId) {
		OrderList orderToMerge = getOrderToMerge(orderId);
		return parseOrderToMerge(orderToMerge);
		
	}

	private String parseOrderToMerge(OrderList orderToMerge) {
		List<Order> orders =  orderToMerge.getOrders();
		List<Product> products = getProducts(orders);
		return mergeOrder(products);
		
		
	}

	private String mergeOrder(List<Product> products) {
		for(Product product : products) {
			String name = product.getName();
			int number = product.getNumber();
			if(this.order.containsKey(name)) {
//				this.order.remove(name);
				this.order.put(name, this.order.get(name) + number);
				
			}else {
				this.order.put(name, number);
			}
		}
		return orderToString();
	}

	private String orderToString() {
		Set<Entry<String, Integer>> entrysOder = this.order.entrySet();
		StringBuilder build = new StringBuilder();
		for (Entry<String, Integer> entry : entrysOder) {
			build.append(entry.getKey() +" : " + entry.getValue() + "\n");
		}
		return build.toString();
	}

	private List<Product> getProducts(List<Order> orders) {
		List<Product> products = new ArrayList<Product>();
		for(Order order : orders) {
			for(Product product : order.getOrder()) {
				products.add(product);
			}
		}
		return products;
	}

	private OrderList getOrderToMerge(String orderId) {
		List<OrderList> orderList = new AllOrders().getOrders();
		for (OrderList order : orderList) {
			if(order.getOrderId().equals(orderId)) {
				return order;
			}
		}		
		return null;
	}
	

}

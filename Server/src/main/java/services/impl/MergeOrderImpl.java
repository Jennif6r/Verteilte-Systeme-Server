package main.java.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.models.Order;
import main.java.models.OrderList;
import main.java.models.Product;
import main.java.services.MergeOrder;

@WebService(endpointInterface = "main.java.services.MergeOrder")
public class MergeOrderImpl implements MergeOrder{
	Map<String, Integer> order;
	
	@Override
	public String getMergedOrder(String orderId) {
		order = new HashMap<String, Integer>();
		OrderList orderToMerge = getOrderToMerge(orderId);
		orderToMerge.finishOrder();
		return parseOrderToMerge(orderToMerge);
		
	}

	private String parseOrderToMerge(OrderList orderToMerge) {
		return mergeOrder(getProducts(orderToMerge.getOrders()));
		
		
	}

	private String mergeOrder(List<Product> products) {
		for(Product product : products) {
			String name = product.getName();
			int number = product.getNumber();
			if(this.order.containsKey(name)) {
				this.order.put(name, this.order.get(name) + number);
				
			}else {
				this.order.put(name, number);
			}
		}
		return orderToString();
	}

	private String orderToString() {
		Set<Entry<String, Integer>> entrysOrder = this.order.entrySet();
		StringBuilder build = new StringBuilder();
		for (Entry<String, Integer> entry : entrysOrder) {
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
		for (OrderList order : new AllOrders().getOrders()) {
			if(order.getOrderId().equals(orderId)) {
				return order;
			}
		}		
		return null;
	}
	

}

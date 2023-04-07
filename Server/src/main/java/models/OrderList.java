package main.java.models;

import java.util.ArrayList;
import java.util.List;

import main.java.data.AllOrders;

public class OrderList {
	private List<Order> orders; 
	private boolean aktiv;
	private String orderId;
	
	public OrderList() {
		this.aktiv = true;
		this.orderId = Long.toString(System.currentTimeMillis());
		this.orders = new ArrayList<Order>();
	}
	
	public void addOrderListToAllOrders() {
		new AllOrders().addOrder(this);
	}
	
	public void addOrder(Order order) {
		System.out.println(order.getOrder());
//		System.out.println(this.orders);
		this.orders.add(order);
		new AllOrders().updateOrder(this);
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public void finishOrder() {
		this.aktiv = false;
		new AllOrders().updateOrder(this);
	}
	
	public boolean getAktiv() {
		return this.aktiv;
	}
	

	public String getOrderId() {
		return orderId;
	}
}

package models;

import java.util.ArrayList;
import java.util.List;

import data.AllOrders;

public class OrderList {
	private List<Order> orders = new ArrayList<Order>();
	private boolean aktiv;
	private String orderId;
	
	public OrderList() {
		this.aktiv = true;
		this.orderId = Long.toString(System.currentTimeMillis());
	}
	
	public void addOrderListToAllOrders() {
		new AllOrders().addOrder(this);
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
		new AllOrders().updateOrder(this);
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public void finishOrder() {
		this.aktiv = false;
	}
	
	public boolean getAktiv() {
		return this.aktiv;
	}
	

	public String getOrderId() {
		return orderId;
	}
}

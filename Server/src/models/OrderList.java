package models;

import java.util.List;

public class OrderList {
	private List<Order> orders;
	private boolean aktiv;
	
	public OrderList() {
		this.aktiv = true;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public List<Order> getOrders(){
		return this.orders;
	}
	
	public void finishOrder() {
		this.aktiv = false;
	}
	
	public boolean getStatus() {
		return this.aktiv;
	}
}

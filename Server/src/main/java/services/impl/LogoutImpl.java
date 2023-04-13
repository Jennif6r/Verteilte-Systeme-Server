package main.java.services.impl;

import java.util.List;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.data.RegisteredIds;
import main.java.models.OrderList;
import main.java.services.Logout;

@WebService(endpointInterface = "main.java.services.Logout")
public class LogoutImpl implements Logout {

	@Override
	public void logoutOfClient(String clientId, String username) {
		// TODO Auto-generated method stub
		System.out.println("logout " + clientId + " " + username);
		finishOrdersForClient(username);
		RegisteredIds.removeId(clientId);
	}

	private void finishOrdersForClient(String user) {
		List<OrderList> allOrders = new AllOrders().getOrders();
		for(OrderList orders: allOrders) {
			if(orders.getUser().equals(user)) {
				orders.finishOrder();
			}
		}
	}

}

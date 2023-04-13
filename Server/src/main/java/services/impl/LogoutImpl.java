package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.data.AllOrders;
import main.java.data.RegisteredIds;
import main.java.models.OrderList;
import main.java.services.Logout;

@WebService(endpointInterface = "main.java.services.Logout")
public class LogoutImpl implements Logout {

	@Override
	public void logoutOfClient(String clientId, String username) {
		finishOrdersForClient(username);
		RegisteredIds.removeId(clientId);
	}

	private void finishOrdersForClient(String user) {
		for(OrderList orders: new AllOrders().getOrders()) {
			if(orders.getUser().equals(user)) {
				orders.finishOrder();
			}
		}
	}

}

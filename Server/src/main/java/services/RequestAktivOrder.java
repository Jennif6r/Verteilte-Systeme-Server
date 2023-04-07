package main.java.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import main.java.models.OrderList;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RequestAktivOrder {
	
	@WebMethod
	String[] isThereAnAktivOrder();
}

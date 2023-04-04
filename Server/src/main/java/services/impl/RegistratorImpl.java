package main.java.services.impl;

import jakarta.jws.WebService;
import main.java.services.Registrator;

@WebService(endpointInterface = "main.java.services.Registrator")
public class RegistratorImpl implements Registrator {

	@Override
	public String registerClient() {
		// TODO Auto-generated method stub
		return "register client"; 
	}

}

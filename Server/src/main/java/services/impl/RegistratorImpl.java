package main.java.services.impl;

import java.util.ArrayList;

import jakarta.jws.WebService;
import main.java.data.RegisteredIds;
import main.java.services.Registrator;

@WebService(endpointInterface = "main.java.services.Registrator")
public class RegistratorImpl implements Registrator {

	@Override
	public String registerClient() {
		ArrayList<String> ids;
		String id;
		do {
			id = "" + (int) (Math.random() * Math.pow(10, 14));
			ids = RegisteredIds.getIds();
			
		}while (ids.contains(id));
		RegisteredIds.addId(id);
		return id;
	}

}

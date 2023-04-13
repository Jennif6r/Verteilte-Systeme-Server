package main.java.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.jws.WebService;
import main.java.data.Pizzen;
import main.java.services.GetPizzen;

@WebService(endpointInterface = "main.java.services.GetPizzen")
public class GetPizzenImpl implements GetPizzen {

	@Override
	public String getPizzen() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "";
		try {
			json = mapper.writeValueAsString(new Pizzen().getPizzen());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}

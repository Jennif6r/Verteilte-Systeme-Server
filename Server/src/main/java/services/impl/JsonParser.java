package main.java.services.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import main.java.models.Order;

public class JsonParser {
	public static Order parseToOrder(String json) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Order order = null;
		try {
			List<Order> orders =  Arrays.asList(mapper.readValue(json, Order.class));
			if(orders.size() == 1) {
				order = orders.get(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return order;
	}
}

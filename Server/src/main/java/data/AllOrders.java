package main.java.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import main.java.models.OrderList;

public class AllOrders {
	List<OrderList> allOrders;
	File file = new File("orders.txt");

	public void addOrder(OrderList order) {
		allOrders = getOrders();
//		System.out.println(allOrders);
		allOrders.add(order);
		saveOrders();
	}

	public List<OrderList> getOrders() {
//		System.out.println("all orders");
		String content = readFile();
		if (file.length() != 0 && content != null) {
			parseOrdertoJson(content);
		}else {
			allOrders = new ArrayList<OrderList>();
		}
		return allOrders;
	}

	private void parseOrdertoJson(String content) {
		// Create ObjectMapper for demarshalling
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Loaded JSON-String is converted to an ArrayList of OrderList objects
			System.out.println(content.toString());
			System.out.println(mapper.readValue(content, OrderList[].class));
			allOrders = new ArrayList<OrderList>(Arrays.asList(mapper.readValue(content, OrderList[].class)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveOrders() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = "";
		try {
			json = mapper.writeValueAsString(allOrders);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readFile() {
		try {
			return Files.readString(Path.of(file.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateOrder(OrderList orderList) {
//		System.out.println(orderList);
		allOrders = getOrders();
//		System.out.println(allOrders);
		for(OrderList order : allOrders) {
//			System.out.println(order);
			if(order.getOrderId().equals(orderList.getOrderId())) {
				allOrders.remove(order);
				allOrders.add(orderList);
				break;
			}
		}
		saveOrders();
	}
	
	public OrderList getOrderList(String id) {
		allOrders = getOrders();
		for(OrderList order : allOrders) {
			if(order.getOrderId().equals(id)) {
				return order;
			}
		}
		return null;
	}

}

package main.java.data;

import java.util.ArrayList;

public class RegisteredIds {
	private static ArrayList<String> ids = new ArrayList<String>();
	
	public RegisteredIds() {
	}

	public static ArrayList<String> getIds() {
		return ids;
	}

	public static void addId(String id) {
		ids.add(id);
	}

	public static void removeId(String id) {
		ids.remove(id);
	}
}

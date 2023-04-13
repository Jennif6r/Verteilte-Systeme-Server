package main.java.data;

import java.util.ArrayList;
import java.util.List;

import main.java.models.Product;

public class Pizzen {
	private List<Product> pizzen = new ArrayList<Product>();

	public Pizzen() {
		pizzen.add(new Product("Margherita",9.2,0));
		pizzen.add(new Product("Salami",10.7,0));
		pizzen.add(new Product("Schinken",10.7,0));
		pizzen.add(new Product("Pilze", 10.7,0));
		pizzen.add(new Product("Tunfisch", 12.2,0));
		pizzen.add(new Product("Hawaii", 12.2,0));
	} 
	
	public List<Product>getPizzen() {
		return this.pizzen;
	}
}

package cn.w28l30.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> map = new HashMap<>();
	private double price;

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public double getPrice() {
		double totalPrice = 0;
		for (CartItem c : map.values()) {
			totalPrice += c.getPrice();
		}
		this.price = totalPrice;
		return price;
	}

	public void add(Book book) {
		CartItem c = map.get(book.getId());
		if (c == null) {
			c = new CartItem();
			c.setBook(book);
			c.setQuantity(1);
			map.put(book.getId(), c);
		} else c.setQuantity(c.getQuantity() + 1);
	}

}

package cn.w28l30.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private String id;
	private Date orderTime;
	private boolean state;
	private User user;
	private Set orderItems = new HashSet<OrderItem>();
	private double price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}

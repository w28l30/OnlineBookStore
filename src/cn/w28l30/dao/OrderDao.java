package cn.w28l30.dao;

import java.util.List;

import cn.w28l30.domain.Order;

public interface OrderDao {

	void add(Order o);

	Order find(String id);

	List<Order> getAll(boolean state);
	
	void update(String id, boolean state);

}
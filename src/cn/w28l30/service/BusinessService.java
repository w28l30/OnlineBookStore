package cn.w28l30.service;

import java.util.List;

import cn.w28l30.domain.Book;
import cn.w28l30.domain.Cart;
import cn.w28l30.domain.Category;
import cn.w28l30.domain.Order;
import cn.w28l30.domain.PageBean;
import cn.w28l30.domain.QueryInfo;
import cn.w28l30.domain.User;

public interface BusinessService {

	/*
	 * Category
	 */
	void addCategory(Category c);

	Category findCategory(String id);

	List getAll();

	/*
	 * User
	 */
	void addUser(User user);

	User findUser(String id);

	User findUser(String username, String password);

	/*
	 * Book
	 */
	void addBook(Book b);

	Book findBook(String id);

	List getAllBooks();

	PageBean bookPageQuery(QueryInfo info);

	/*
	 * Order
	 */
	Order findOrder(String id);

	List getOrderByState(boolean state);

	void updateOrder(String id, boolean state);

	void saveOrder(Cart cart, User user);

}
package cn.w28l30.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import cn.w28l30.dao.BookDao;
import cn.w28l30.dao.CategoryDao;
import cn.w28l30.dao.OrderDao;
import cn.w28l30.dao.Userdao;
import cn.w28l30.dao.impl.QueryResult;
import cn.w28l30.domain.Book;
import cn.w28l30.domain.Cart;
import cn.w28l30.domain.CartItem;
import cn.w28l30.domain.Category;
import cn.w28l30.domain.Order;
import cn.w28l30.domain.OrderItem;
import cn.w28l30.domain.PageBean;
import cn.w28l30.domain.QueryInfo;
import cn.w28l30.domain.User;
import cn.w28l30.factory.DaoFactory;
import cn.w28l30.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private CategoryDao cDao = DaoFactory.getInstance().createDao(CategoryDao.class); 
	private BookDao bDao = DaoFactory.getInstance().createDao(BookDao.class); 
	private OrderDao oDao = DaoFactory.getInstance().createDao(OrderDao.class); 
	private Userdao uDao = DaoFactory.getInstance().createDao(Userdao.class);
	
	/*
	 * Category
	 */
	public void addCategory(Category c) {
		cDao.add(c);
	}
	
	public Category findCategory(String id) {
		return cDao.find(id);
	}
	
	public List getAll() {
		return cDao.getAll();
	}
	
	/*
	 * User
	 */
	public void addUser(User user) {
		uDao.add(user);
	}
	
	public User findUser(String id) {
		return uDao.find(id);
	}
	
	public User findUser(String username, String password) {
		return uDao.find(username, password);
	}
	/*
	 * Book
	 */
	public void addBook(Book b) {
		bDao.add(b);
	}
	
	public Book findBook(String id) {
		return bDao.find(id);
	}
	
	public List getAllBooks() {
		return bDao.getAll();
	}
	
	public PageBean bookPageQuery(QueryInfo info) {
		QueryResult result = bDao.pageQuery(info.getStartIndex(), info.getPageSize(), info.getWhere(), info.getQueryValue());
		PageBean bean = new PageBean();
		bean.setTotalRecord(result.getTotalRecord());
		bean.setPageSize(info.getPageSize());
		bean.setList(result.getBookList());
		bean.setCurrentPage(info.getCurrentPage());
		return bean;
	}
	/*
	 * Order
	 */
	public Order findOrder(String id) {
		return oDao.find(id);
	}
	
	public List getOrderByState(boolean state) {
		return oDao.getAll(state);
	}
	
	public void updateOrder(String id, boolean state) {
		oDao.update(id, state);
	}
	
	public void saveOrder(Cart cart, User user) {
		Order o = new Order();
		o.setId(UUID.randomUUID().toString());
		o.setUser(user);
		o.setOrderTime(new Date());
		o.setState(false);
		o.setPrice(cart.getPrice());
		
		Set<OrderItem> Items = new HashSet<>();
		for (CartItem c : cart.getMap().values()) {
			OrderItem item = new OrderItem();
			item.setBook(c.getBook());
			item.setId(UUID.randomUUID().toString());
			item.setPrice(c.getPrice());
			item.setQuantity(c.getQuantity());
			Items.add(item);
		}
		o.setOrderItems(Items);
		oDao.add(o);
	}
	
}

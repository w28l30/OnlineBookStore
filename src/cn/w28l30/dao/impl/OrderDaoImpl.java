package cn.w28l30.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.w28l30.dao.OrderDao;
import cn.w28l30.domain.Book;
import cn.w28l30.domain.Order;
import cn.w28l30.domain.OrderItem;
import cn.w28l30.domain.User;
import cn.w28l30.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.OrderDao#add(cn.w28l30.domain.Order)
	 */
	public void add(Order o) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into orders(id, ordertime, state, price, user_id) values(?,?,?,?,?)";
			Object[] params = {o.getId(), o.getOrderTime(), o.isState(), o.getPrice(), o.getUser().getId()};
			runner.update(conn, sql, params);
			
			Set<OrderItem> set = o.getOrderItems();
			for (OrderItem i : set) {
				sql = "insert into orderitem(id, quantity, price, book_id, order_id) values(?,?,?,?,?)";
				params = new Object[]{i.getId(), i.getQuantity(), i.getPrice(), i.getBook().getId(), o.getId()};
				runner.update(conn, sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.OrderDao#find(java.lang.String)
	 */
	public Order find(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where id=?";
			Order order = runner.query(conn, sql, id, new BeanHandler<>(Order.class));
			
			sql = "select * from orderitem where order_id=?";
			List<OrderItem> list = runner.query(conn, sql, id, new BeanListHandler<>(OrderItem.class));
			
			for (OrderItem item : list) {
				sql = "select b.* from orderitem oi, book b where oi.id=? and b.id=oi.book_id";
				Book book = runner.query(conn, sql, item.getId(), new BeanHandler<>(Book.class));
				item.setBook(book);
			}
			order.getOrderItems().addAll(list);
			
			sql = "select u.* from orders o, user u where o.id=? and o.user_id=u.id";
			User user = runner.query(conn, sql, id, new BeanHandler<>(User.class));
			
			order.setUser(user);
			
			return order;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.OrderDao#getAll(boolean)
	 */
	public List<Order> getAll(boolean state) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where state=?";
			List<Order> list = runner.query(conn, sql, state, new BeanListHandler<>(Order.class));
			
			for (Order o : list) {
				sql = "select u.* from user u, orders o where o.id=? and o.user_id=u.id";
				User user = runner.query(conn, sql, o.getId(), new BeanHandler<>(User.class));
				o.setUser(user);
			}
			
			return list;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String id,boolean state){
		try{
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "update orders set state=? where id=?";
			Object params[] = {state,id};
			runner.update(conn,sql,params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}

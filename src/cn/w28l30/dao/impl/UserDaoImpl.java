package cn.w28l30.dao.impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.w28l30.dao.Userdao;
import cn.w28l30.domain.User;
import cn.w28l30.utils.JdbcUtils;

public class UserDaoImpl implements Userdao {
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.Userdao#add(cn.w28l30.domain.User)
	 */
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.UserDao#add(cn.w28l30.domain.User)
	 */
	public void add(User user) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into user(id, username, password, phone, cellphone, email, address) values(?,?,?,?,?,?,?)";
			Object[] params = {user.getId(), user.getUsername(), user.getPassword(), user.getPhone(), user.getCellphone(), user.getEmail(), user.getAddress()};
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.Userdao#find(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.UserDao#find(java.lang.String)
	 */
	public User find(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where id=?";
			return runner.query(conn, sql, id, new BeanHandler<>(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.Userdao#find(java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	public User find(String username, String password) {
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username, password};
			return runner.query(conn, sql, params , new BeanHandler<>(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

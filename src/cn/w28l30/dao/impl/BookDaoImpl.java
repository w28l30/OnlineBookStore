package cn.w28l30.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.w28l30.dao.BookDao;
import cn.w28l30.domain.Book;
import cn.w28l30.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {
	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.BookDao#add(cn.w28l30.domain.Book)
	 */
	public void add(Book b) {
		try {
			QueryRunner runner = new QueryRunner();
			Connection conn = JdbcUtils.getConnection();
			String sql = "insert into book(id, name, price, author, image, description, category_id) values(?,?,?,?,?,?,?)";
			Object[] params = { b.getId(), b.getName(), b.getPrice(), b.getAuthor(), b.getImage(), b.getDescription(),
					b.getCategory().getId() };
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.BookDao#find(java.lang.String)
	 */
	public Book find(String id) {
		try {
			QueryRunner runner = new QueryRunner();
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from book where id=?";
			return (Book) runner.query(conn, sql, id, new BeanHandler(Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see cn.w28l30.dao.impl.BookDao#pageQuery(int, int, java.lang.String, java.lang.Object)
	 */
	public QueryResult pageQuery(int startIndex, int pageSize, String where, Object param) {
		try {
			QueryRunner runner = new QueryRunner();
			Connection conn = JdbcUtils.getConnection();
			if (where == null || where.trim().equals("")) {
				String sql = "select * from book limit ?,?";
				Object params[] = {startIndex, pageSize};
				List<Book> bookList = runner.query(conn, sql, params, new BeanListHandler<>(Book.class));
				sql = "select count(*) from book";
				int totalRecord = ((Long)runner.query(conn, sql, new ScalarHandler<>())).intValue();
				return new QueryResult(totalRecord, bookList);
			} else {
				String sql = "select * from book " + where + " limit ?,?";
				Object params[] = { param, startIndex, pageSize };
				List<Book> bookList = runner.query(conn, sql, params, new BeanListHandler<>(Book.class));
				sql = "select count(*) from book " + where;
				int totalRecord = ((Long)runner.query(conn, sql, param, new ScalarHandler<>())).intValue();
				return new QueryResult(totalRecord, bookList);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List getAll() {
		try {
			QueryRunner runner = new QueryRunner();
			Connection conn = JdbcUtils.getConnection();
			String sql = "select * from book";
			return runner.query(conn, sql, new BeanListHandler<>(Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

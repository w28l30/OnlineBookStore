package cn.w28l30.dao;

import java.util.List;

import cn.w28l30.dao.impl.QueryResult;
import cn.w28l30.domain.Book;

public interface BookDao {

	void add(Book b);

	Book find(String id);

	QueryResult pageQuery(int startIndex, int pageSize, String where, Object param);
	
	List getAll();

}
package cn.w28l30.dao.impl;

import java.util.List;

import cn.w28l30.domain.Book;

public class QueryResult {
	private int totalRecord;
	private List<Book> bookList;
	
	
	public QueryResult(int totalRecord, List<Book> bookList) {
		super();
		this.totalRecord = totalRecord;
		this.bookList = bookList;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}

package cn.w28l30.domain;

import java.util.List;

public class PageBean {
	private List list;
	private int totalRecord;
	private int pageSize;
	private int totalPage;
	private int currentPage;

	private int previousPage;
	private int nextPage;
	private int[] pageBar;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int gettotalPage() {
		return (this.totalRecord - 1) / this.pageSize + 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return currentPage > 1 ? currentPage - 1 : currentPage;
	}

	public int getNextPage() {
		return currentPage < totalPage ? currentPage + 1 : currentPage;
	}

	public int[] getPageBar() {
		int startPage = 0;
		int endPage = 0;

		if (this.totalPage < 10) {
			startPage = 1;
			endPage = this.totalPage;
		} else {
			startPage = this.currentPage - 4; // 17
												// 13,14,15,16,17,18,19,20,21,22
			endPage = this.currentPage + 5;

			if (startPage < 1) {
				startPage = 1;
				endPage = 10;
			}

			if (endPage > totalPage) {
				endPage = totalPage;
				startPage = totalPage - 9;
			}
		}

		int[] pageBar = new int[endPage - startPage + 1];
		for (int i = startPage; i <= endPage; i++) {
			pageBar[i - startPage] = i;
		}

		return pageBar;
	}
}

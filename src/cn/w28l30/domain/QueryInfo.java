package cn.w28l30.domain;

public class QueryInfo {
	private int startIndex;
	private int pageSize = 2;
	private String Where;
	private String queryName;
	private String queryValue;
	private int currentPage = 1;
	
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartIndex() {
		this.startIndex = (this.currentPage - 1) * this.pageSize;
		return startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getWhere() {
		if (this.queryName == null || this.queryName.trim() == "")
			return "";
		this.Where = "where " + queryName + "=?";

		return Where;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

}

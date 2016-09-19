package cn.w28l30.dao;

import java.util.List;

import cn.w28l30.domain.Category;

public interface CategoryDao {

	void add(Category c);

	Category find(String id);

	List<Category> getAll();

}
package junit.test;


import org.junit.Test;

import cn.w28l30.dao.impl.CategoryDaoImpl;
import cn.w28l30.domain.Category;
import cn.w28l30.utils.JdbcUtils;

public class CategoryDaoTest {
	
	@Test
	public void testAdd() {
		CategoryDaoImpl dao = new CategoryDaoImpl();
		Category c = new Category();
		c.setId("1");
		c.setName("Funny");
		c.setDescription("Pretty funny");
		dao.add(c);
		JdbcUtils.commitTranscation();
	}
	@Test
	public void testFind() {
		CategoryDaoImpl dao = new CategoryDaoImpl();
		Category c = dao.find("1");
		JdbcUtils.commitTranscation();
	}
}

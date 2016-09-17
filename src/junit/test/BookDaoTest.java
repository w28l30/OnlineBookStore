package junit.test;

import org.junit.Test;

import cn.w28l30.dao.impl.BookDaoImpl;
import cn.w28l30.domain.Book;
import cn.w28l30.domain.Category;
import cn.w28l30.utils.JdbcUtils;

public class BookDaoTest {
	@Test
	public void testAdd() {
		Category c = new Category();
		c.setId("1");
		c.setName("Funny");
		c.setDescription("Pretty funny");
		Book b = new Book();
		b.setAuthor("ZZ67");
		b.setCategory(c);
		b.setDescription("HAHAHAHA");
		b.setId("2");
		b.setImage("/wSDF23/23");
		b.setName("JavaScript");
		b.setPrice(12.5);
		BookDaoImpl dao = new BookDaoImpl();
		dao.add(b);
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testQuery() {
		BookDaoImpl dao = new BookDaoImpl();
		System.out.println(dao.pageQuery(0, 2, "where category_id=?", 1).getBookList().size());
		JdbcUtils.commitTranscation();
	}
}

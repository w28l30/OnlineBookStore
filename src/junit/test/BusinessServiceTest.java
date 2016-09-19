package junit.test;

import org.junit.Test;

import cn.w28l30.domain.Book;
import cn.w28l30.domain.Cart;
import cn.w28l30.domain.Category;
import cn.w28l30.domain.Order;
import cn.w28l30.domain.PageBean;
import cn.w28l30.domain.QueryInfo;
import cn.w28l30.domain.User;
import cn.w28l30.service.impl.BusinessServiceImpl;
import cn.w28l30.utils.JdbcUtils;

public class BusinessServiceTest {
	private BusinessServiceImpl service = new BusinessServiceImpl();
	
	@Test
	public void testAddUser() {
		User user = new User();;
		user.setId("3");
		user.setAddress("100 BARRON");
		user.setCellphone("123124");
		user.setEmail("sdfsdf@sdf.com");
		user.setUsername("AA");
		user.setPassword("sdfasdf");
		user.setPhone("12312312");
		service.addUser(user);
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testFindUser() {
		System.out.println(service.findUser("YY", "sdfd").getUsername());
	}
	
	@Test
	public void testGetAll() {
		System.out.println(service.getAll().size());
	}
	
	@Test
	public void testAddCategory() {
		Category c = new Category();
		c.setDescription("Not funny");
		c.setId("2");
		c.setName("Not Very funny");
		service.addCategory(c);
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testFindCategory() {
		System.out.println(service.findCategory("2").getName());
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testGetBooks() {
		System.out.println(service.getAllBooks().size());
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testAddBook() {
		Book b = new Book();
		b.setCategory(service.findCategory("2"));
		b.setId("3");
		b.setDescription("lalalala");
		b.setImage("sdfsd");
		b.setName("Spring");
		b.setPrice(19.5);
		b.setAuthor("PP");
		service.addBook(b);
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testPageQuery(){
		
		QueryInfo info = new QueryInfo();
		info.setCurrentPage(1);
		info.setPageSize(2);
		/*info.setQueryname("category_id");
		info.setQueryvalue("1");*/
		
		PageBean bean = service.bookPageQuery(info);
		System.out.println(bean.gettotalPage());
	}
	
	@Test
	public void testSaveOrder(){
		
		
		Cart cart = new Cart();
		cart.add(service.findBook("2"));
		cart.add(service.findBook("1"));
		
		service.saveOrder(cart, service.findUser("1"));
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testFindOrder(){
		System.out.println(service.findOrder("8df53646-d6d9-41ae-9cea-d1d2d107aa10"));
	}
	
}

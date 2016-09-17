package junit.test;

import org.junit.Test;

import cn.w28l30.dao.impl.UserDaoImpl;
import cn.w28l30.domain.User;
import cn.w28l30.utils.JdbcUtils;

public class UserDaoTest {
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setAddress("Barron cir");
		user.setCellphone("13823221");
		user.setEmail("yysggkt@sfd.com");
		user.setId("2");
		user.setPassword("sdfd");
		user.setUsername("ZZ");
		user.setPhone("213124");
		UserDaoImpl dao = new UserDaoImpl();
		dao.add(user);
		JdbcUtils.commitTranscation();
	}
	
	@Test
	public void testFind() {
		UserDaoImpl dao = new UserDaoImpl();
		User user = dao.find("1");
		System.out.println(user.getAddress());
	}
	@Test
	public void testFind2() {
		UserDaoImpl dao = new UserDaoImpl();
		User user = dao.find("YY", "sdfd");
	}
}

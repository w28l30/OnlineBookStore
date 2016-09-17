package junit.test;

import org.junit.Test;

import cn.w28l30.dao.impl.OrderDaoImpl;
import cn.w28l30.utils.JdbcUtils;

public class OrderDaoTest {
	@Test
	public void testFind() {
		OrderDaoImpl dao = new OrderDaoImpl();
		dao.find("1").getOrderItems();
		JdbcUtils.commitTranscation();
	}
}

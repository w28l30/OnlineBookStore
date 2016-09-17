package cn.w28l30.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static final DaoFactory instance = new DaoFactory();
	private static Properties prop = new Properties();
	
	private DaoFactory() {
		try {
			InputStream in = DaoFactory.class.getResourceAsStream("/day22/src/cn/w28l30/Factory/dao.properties");
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static DaoFactory getInstance() {
		return instance;
	}
	
	public <T> T createDao(Class<T> interfaceClass) {
		try {
			String key = interfaceClass.getSimpleName();
			String className = prop.getProperty(key);
			Class.forName(className).newInstance();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

package cn.w28l30.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		try {
			T bean = beanClass.newInstance();
			Map map = request.getParameterMap();
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}

package cn.w28l30.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.w28l30.domain.Book;
import cn.w28l30.domain.Category;
import cn.w28l30.service.BusinessService;
import cn.w28l30.service.impl.BusinessServiceImpl;

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

	public static Book upload(HttpServletRequest request, String uploadPath) {
		// TODO Auto-generated method stub
		try {
			Book book = new Book();
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String inputName = item.getFieldName();
					String value = item.getString("UTF-8");
					if ("category_id".equals(inputName)) {
						BusinessService service = new BusinessServiceImpl();
						Category c = service.findCategory(value);
						book.setCategory(c);
					} else {
						BeanUtils.setProperty(book, inputName, value);
					}
				} else {
					String fileName = item.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
					String savePath = uploadPath;
					String saveFileName = UUID.randomUUID().toString() + fileName;
					
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(savePath + File.separator + saveFileName);
					int len = 0;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					System.out.println(saveFileName);
					book.setImage(saveFileName);
				}
			}
			book.setId(UUID.randomUUID().toString());
			return book;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

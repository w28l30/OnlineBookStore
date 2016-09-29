package cn.w28l30.web.manager;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.w28l30.domain.Category;
import cn.w28l30.service.BusinessService;
import cn.w28l30.service.impl.BusinessServiceImpl;
import cn.w28l30.utils.WebUtils;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService service = new BusinessServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if ("add".equals(method)) {
			add(request, response);
		}
		if ("getAll".equals(method)) {
			getAll(request, response);
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List list = service.getAll();
		request.setAttribute("categories", list);
		request.getRequestDispatcher("/manager/listcategory.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Category c = WebUtils.request2Bean(request, Category.class);
			c.setId(UUID.randomUUID().toString());
			service.addCategory(c);
			request.setAttribute("message", "Category added sucessful!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Category added failed!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

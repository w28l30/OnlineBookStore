package cn.w28l30.web.client;

import java.io.IOException;
import java.util.List;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.w28l30.domain.PageBean;
import cn.w28l30.domain.QueryInfo;
import cn.w28l30.service.BusinessService;
import cn.w28l30.service.impl.BusinessServiceImpl;
import cn.w28l30.utils.WebUtils;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService service = new BusinessServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
		String category_id = request.getParameter("category_id");
		if (category_id != null && ! category_id.trim().equals("")) {
			info.setQueryName("category_id");
			info.setQueryValue(category_id);
		}
		
		List categories = service.getAll();
		PageBean pageBean = service.bookPageQuery(info);
		request.setAttribute("categories", categories);
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/client/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

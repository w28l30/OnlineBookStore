package cn.w28l30.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.w28l30.domain.Book;
import cn.w28l30.service.BusinessService;
import cn.w28l30.service.impl.BusinessServiceImpl;
import cn.w28l30.utils.WebUtils;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService service = new BusinessServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
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
		if ("forAddUI".equals(method)) {
			forAddUI(request, response);
		}
		if ("add".equals(method)) {
			add(request, response);
		}
		if("list".equals(method)){
			list(request,response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		List list = service.getAllBooks();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/manager/listBook.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Book book = WebUtils.upload(request, this.getServletContext().getRealPath("/images"));
			service.addBook(book);
			request.setAttribute("message", "Book added sucessful!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Book added failed!");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	private void forAddUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List categories = service.getAll();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/manager/addBook.jsp").forward(request, response);
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

package cn.itcast.book.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.book.web.dao.BookDao;
import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookDao bookDao = new BookDao();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bookList", bookDao.findAll());
		return "/show.jsp";
	}
	public String findByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("category");
		int category = Integer.parseInt(value);
		request.setAttribute("bookList", bookDao.findByCategory(category));
		return "/show.jsp";
	}
}

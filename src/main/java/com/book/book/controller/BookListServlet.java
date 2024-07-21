package com.book.book.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.dao.sql.BookDao;
import com.book.book.vo.Book;



@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "";

		Book option = new Book();
		option.setBook_title(title);
		
		String nowPage = request.getParameter("nowPage");
		if(nowPage != null) {
			option.setNowPage(Integer.parseInt(nowPage));
		}
//		전체 목록 개수 -> 페이징 바 구성
		option.setTotalData(new BookDao().selectBookCount(option));
		
		List<Map<String,String>> list =  new BookDao().SelectBookList(option);
		request.setAttribute("paging", option);
		request.setAttribute("resultList", list);
		RequestDispatcher view = null;
		if(!list.isEmpty()) {

			view = request.getRequestDispatcher("/views/book/book_list.jsp");
			view.forward(request, response);
		} else {
			System.out.println(list);
			view = request.getRequestDispatcher("/views/book/book_list.jsp");
			view.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}

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

import com.book.book.dao.sql.BookApplyDao;
import com.book.book.dao.sql.BookDao;
import com.book.book.vo.Book;
import com.book.book.vo.BookApply;


@WebServlet("/book/requestEnd")
public class RequestBookListEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestBookListEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookApply option = new BookApply();
		
		String nowPage = request.getParameter("nowPage");
		if(nowPage != null) {
			option.setNowPage(Integer.parseInt(nowPage));
		}
		
		option.setTotalData(new BookApplyDao().selectBookApplyCount(option));
		
		List<Map<String,String>> list =  new BookApplyDao().SelectBookApplyList(option);
		request.setAttribute("paging", option);
		request.setAttribute("resultList", list);
		RequestDispatcher view = null;
		if(!list.isEmpty()) {

	        view = request.getRequestDispatcher("/views/book/book_request_list.jsp");
	        view.forward(request, response);
			
	} else {
        view = request.getRequestDispatcher("/views/book/book_request_list.jsp");
        view.forward(request, response);

	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}

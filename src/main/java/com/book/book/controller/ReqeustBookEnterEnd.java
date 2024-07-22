package com.book.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.dao.sql.BookApplyDao;
import com.book.book.vo.BookApply;


@WebServlet("/book/enterEnd")
public class ReqeustBookEnterEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReqeustBookEnterEnd() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int applyno = Integer.parseInt(request.getParameter("apply_no"));
		System.out.println(applyno);
		BookApply ba = new BookApply();
		ba.setApply_no(applyno);
		int result = new BookApplyDao().selectEnterBook(ba);
		RequestDispatcher view = null;
		if(result > 0) {
			System.out.println("확인1");			
				request.setAttribute("Bookenter", ba);
				view = request.getRequestDispatcher("/views/book/book_enter.jsp");
				view.forward(request, response);
	} else {
		System.out.println("확인2");
	}
	}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}

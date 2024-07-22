package com.book.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.dao.sql.BookDao;
import com.book.book.vo.Book;


@WebServlet("/book/editEnd")
public class EditBookEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditBookEndServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookno = Integer.parseInt(request.getParameter("book_no"));
		System.out.println(bookno);
		Book bk = new Book();
		bk.setBook_no(bookno);
		int result = new BookDao().selecteditBook(bk);
		RequestDispatcher view = null;
		System.out.println(bk.getBook_no());
		if(result > 0) {
			System.out.println("확인1");			
				request.setAttribute("Bookedit", bk);
				view = request.getRequestDispatcher("/views/book/book_edit.jsp");
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

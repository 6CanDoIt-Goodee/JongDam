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


@WebServlet("/deleteend/book")
public class DeleteBookEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteBookEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookimg = request.getParameter("books_img");
		System.out.println(bookimg);
		if (bookimg != null && !bookimg.isEmpty()) {
			
			
			Book bk = new Book();
			bk.setBook_img(bookimg);
			
			int result = new BookDao().deleteBook(bk);
			
			response.sendRedirect("/book/list");
			}
		}
	}

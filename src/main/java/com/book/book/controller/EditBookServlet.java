package com.book.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.dao.sql.BookDao;
import com.book.book.vo.Book;


@WebServlet("/book/edit")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditBookServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("확인");
		String bookimg = request.getParameter("book_img");
		String booktitle = request.getParameter("book_title");
		String bookauthor = request.getParameter("book_author");
		String bookpublisher = request.getParameter("book_publihser");
		int bookcategory = Integer.parseInt(request.getParameter("book_category"));
		System.out.println(bookcategory);
		Book bk = new Book();
		bk.setBook_img(bookimg);
		bk.setBook_title(booktitle);
		bk.setBook_author(bookauthor);
		bk.setBook_publisher_name(bookpublisher);
		bk.setBook_category_no(bookcategory);
		int result = new BookDao().editBook(bk);
		System.out.println(result);
		response.sendRedirect("/book/create");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}

package com.gn.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.book.dao.sql.BookDao;
import com.gn.book.vo.Book;


@WebServlet("/book/createEnd")
public class CreateBookEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CreateBookEndServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String bookimg = request.getParameter("img_up");
		String booktitle = request.getParameter("book_title");
		String bookauthor = request.getParameter("book_author");
		String bookpublisher = request.getParameter("book_publihser");
		int bookcategory = Integer.parseInt(request.getParameter("book_category"));
		Book bk = new Book();
		bk.setBook_title(booktitle);
		bk.setBook_author(bookauthor);
		bk.setBook_publisher_name(bookpublisher);
		bk.setBook_category_no(bookcategory);
		int result = new BookDao().createBook(bk);
		System.out.println(booktitle);
		System.out.println(bookauthor);
		System.out.println(bookpublisher);
		System.out.println(bookcategory);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}

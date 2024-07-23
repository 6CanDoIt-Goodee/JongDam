package com.book.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.dao.sql.BookApplyDao;
import com.book.book.dao.sql.BookDao;
import com.book.book.vo.Book;
import com.book.book.vo.BookApply;


@WebServlet("/book/registerEnd")
public class RequestBookRegisterEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestBookRegisterEndServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookimg = request.getParameter("book_img");
		String booktitle = request.getParameter("book_title");
		String bookauthor = request.getParameter("book_author");
		String bookpublisher = request.getParameter("book_publisher");
		int bookcategory = Integer.parseInt(request.getParameter("book_category"));
		Book bk = new Book();
		bk.setBook_img(bookimg);
		bk.setBook_title(booktitle);
		bk.setBook_author(bookauthor);
		bk.setBook_publisher_name(bookpublisher);
		bk.setBook_category_no(bookcategory);
		int result = new BookDao().createBook(bk);
		System.out.println(result);
		int applyno = Integer.parseInt(request.getParameter("apply_no"));
		BookApply ba = new BookApply();
		ba.setApply_no(applyno);
		new BookApplyDao().statusup(ba);
		response.sendRedirect("/book/create");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}

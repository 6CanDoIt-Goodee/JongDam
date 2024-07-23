package com.book.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.book.dao.sql.BookApplyDao;
import com.book.book.vo.BookApply;


@WebServlet("/book/rejectEnd")
public class RequestBookRejectEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestBookRejectEndServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int applyno = Integer.parseInt(request.getParameter("apply_no"));
		BookApply ba = new BookApply();
		ba.setApply_no(applyno);
		new BookApplyDao().statusdown(ba);
		response.sendRedirect("/book/requestEnd");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

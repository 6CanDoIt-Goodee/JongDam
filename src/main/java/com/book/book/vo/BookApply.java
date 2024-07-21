package com.book.book.vo;

import com.book.book.dao.sql.Paging;

public class BookApply extends Paging{
	private int apply_no;
	private String apply_bk_title;
	private String appy_bk_author;
	private String apply_bk_publisher;
	
	public BookApply() {
		super();
	}

	public BookApply(int apply_no, String apply_bk_title, String appy_bk_author, String apply_bk_publisher) {
		super();
		this.apply_no = apply_no;
		this.apply_bk_title = apply_bk_title;
		this.appy_bk_author = appy_bk_author;
		this.apply_bk_publisher = apply_bk_publisher;
	}

	public int getApply_no() {
		return apply_no;
	}

	public void setApply_no(int apply_no) {
		this.apply_no = apply_no;
	}

	public String getApply_bk_title() {
		return apply_bk_title;
	}

	public void setApply_bk_title(String apply_bk_title) {
		this.apply_bk_title = apply_bk_title;
	}

	public String getAppy_bk_author() {
		return appy_bk_author;
	}

	public void setAppy_bk_author(String appy_bk_author) {
		this.appy_bk_author = appy_bk_author;
	}

	public String getApply_bk_publisher() {
		return apply_bk_publisher;
	}

	public void setApply_bk_publisher(String apply_bk_publisher) {
		this.apply_bk_publisher = apply_bk_publisher;
	}
	
	
	
	@Override
	public String toString() {
		return "BookApply [apply_no=" + apply_no + ", apply_bk_title=" + apply_bk_title + ", appy_bk_author="
				+ appy_bk_author + ", apply_bk_publisher=" + apply_bk_publisher + "]";
	}
	
}

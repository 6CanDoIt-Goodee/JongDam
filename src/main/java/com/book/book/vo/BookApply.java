package com.book.book.vo;

import com.book.book.dao.sql.Paging;

public class BookApply extends Paging{
	private int apply_no;
	private String apply_bk_title;
	private String apply_bk_author;
	private String apply_bk_publisher;
	private int apply_bk_status;
	
	public BookApply() {
		super();
	}

	public BookApply(int apply_no, String apply_bk_title, String appy_bk_author, String apply_bk_publisher,
			int apply_bk_status) {
		super();
		this.apply_no = apply_no;
		this.apply_bk_title = apply_bk_title;
		this.apply_bk_author = appy_bk_author;
		this.apply_bk_publisher = apply_bk_publisher;
		this.apply_bk_status = apply_bk_status;
	}

	@Override
	public String toString() {
		return "BookApply [apply_no=" + apply_no + ", apply_bk_title=" + apply_bk_title + ", appy_bk_author="
				+ apply_bk_author + ", apply_bk_publisher=" + apply_bk_publisher + ", apply_bk_status=" + apply_bk_status
				+ "]";
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

	public String getApply_bk_author() {
		return apply_bk_author;
	}

	public void setApply_bk_author(String appy_bk_author) {
		this.apply_bk_author = appy_bk_author;
	}

	public String getApply_bk_publisher() {
		return apply_bk_publisher;
	}

	public void setApply_bk_publisher(String apply_bk_publisher) {
		this.apply_bk_publisher = apply_bk_publisher;
	}

	public int getApply_bk_status() {
		return apply_bk_status;
	}

	public void setApply_bk_status(int apply_bk_status) {
		this.apply_bk_status = apply_bk_status;
	}

	
	
}
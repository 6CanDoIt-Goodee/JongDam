package com.book.book_category.vo;

public class Category {

	private int book_category_no;
	private String book_category_name;
	
	public Category() {
		super();
	}

	public Category(int book_category_no, String book_category_name) {
		super();
		this.book_category_no = book_category_no;
		this.book_category_name = book_category_name;
	}


	public int getBook_category_no() {
		return book_category_no;
	}

	public void setBook_category_no(int book_category_no) {
		this.book_category_no = book_category_no;
	}

	public String getBook_category_name() {
		return book_category_name;
	}

	public void setBook_category_name(String book_category_name) {
		this.book_category_name = book_category_name;
	}

	@Override
	public String toString() {
		return "Category [book_category_no=" + book_category_no + ", book_category_name=" + book_category_name + "]";
	}


}

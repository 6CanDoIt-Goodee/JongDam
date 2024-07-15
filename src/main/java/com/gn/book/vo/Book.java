package com.gn.book.vo;

public class Book {

	private int book_no;
	private String book_title;
	private String book_author;
	private int book_category_no;
	private String book_publisher_name;
	
	public Book() {
		super();
	}

	public Book(int book_no, String book_title, String book_author, int book_category_no, String book_publisher_name) {
		super();
		this.book_no = book_no;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_category_no = book_category_no;
		this.book_publisher_name = book_publisher_name;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public int getBook_category_no() {
		return book_category_no;
	}

	public void setBook_category_no(int book_category_no) {
		this.book_category_no = book_category_no;
	}

	public String getBook_publisher_name() {
		return book_publisher_name;
	}

	public void setBook_publisher_name(String book_publisher_name) {
		this.book_publisher_name = book_publisher_name;
	}

	
	@Override
	public String toString() {
		return "Book [book_no=" + book_no + ", book_title=" + book_title + ", book_author=" + book_author
				+ ", book_category_no=" + book_category_no + ", book_publisher_name=" + book_publisher_name
				+ ", getBook_no()=" + getBook_no() + ", getBook_title()=" + getBook_title() + ", getBook_author()="
				+ getBook_author() + ", getBook_category_no()=" + getBook_category_no() + ", getBook_publisher_name()="
				+ getBook_publisher_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}

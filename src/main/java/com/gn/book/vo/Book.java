package com.gn.book.vo;

public class Book {

	private int books_no;
	private String books_title;
	private String books_author;
	private int books_category_no;
	private String books_publisher_name;
	
	public Book() {
		super();
	}

	public Book(int book_no, String book_title, String book_author, int book_category_no, String book_publisher_name) {
		super();
		this.books_no = book_no;
		this.books_title = book_title;
		this.books_author = book_author;
		this.books_category_no = book_category_no;
		this.books_publisher_name = book_publisher_name;
	}

	public int getBook_no() {
		return books_no;
	}

	public void setBook_no(int book_no) {
		this.books_no = book_no;
	}

	public String getBook_title() {
		return books_title;
	}

	public void setBook_title(String book_title) {
		this.books_title = book_title;
	}

	public String getBook_author() {
		return books_author;
	}

	public void setBook_author(String book_author) {
		this.books_author = book_author;
	}

	public int getBook_category_no() {
		return books_category_no;
	}

	public void setBook_category_no(int book_category_no) {
		this.books_category_no = book_category_no;
	}

	public String getBook_publisher_name() {
		return books_publisher_name;
	}

	public void setBook_publisher_name(String book_publisher_name) {
		this.books_publisher_name = book_publisher_name;
	}

	
	@Override
	public String toString() {
		return "Book [book_no=" + books_no + ", book_title=" + books_title + ", book_author=" + books_author
				+ ", book_category_no=" + books_category_no + ", book_publisher_name=" + books_publisher_name
				+ ", getBook_no()=" + getBook_no() + ", getBook_title()=" + getBook_title() + ", getBook_author()="
				+ getBook_author() + ", getBook_category_no()=" + getBook_category_no() + ", getBook_publisher_name()="
				+ getBook_publisher_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}

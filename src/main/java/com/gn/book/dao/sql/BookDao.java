package com.gn.book.dao.sql;

import static com.gn.book.dao.sql.JDBCTemplate.getConnection;
import static com.gn.book.dao.sql.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.gn.book.vo.Book;

public class BookDao {

	public int createBook(Book bk) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "INSERT INTO `books`(`books_title`, `books_author` , `books_category_no`, `books_publisher_name`) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bk.getBook_title());
			pstmt.setString(2, bk.getBook_author());
			pstmt.setInt(3, bk.getBook_category_no());
			pstmt.setString(4, bk.getBook_publisher_name());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
}

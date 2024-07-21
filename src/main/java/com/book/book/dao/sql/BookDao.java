package com.book.book.dao.sql;

import static com.book.book.dao.sql.JDBCTemplate.getConnection;
import static com.book.book.dao.sql.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.book.vo.Book;

public class BookDao {

   public int createBook(Book bk) {
      Connection conn = getConnection();
      PreparedStatement pstmt = null;
      int result = 0;
      try {
         String sql = "INSERT INTO `book`(`books_title`, `books_author` , `books_category_no`, `books_publisher_name`, `books_img`) VALUES(?,?,?,?,?)";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, bk.getBook_title());
         pstmt.setString(2, bk.getBook_author());
         pstmt.setInt(3, bk.getBook_category_no());
         pstmt.setString(4, bk.getBook_publisher_name());
         pstmt.setString(5, bk.getBook_img());
         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(conn);
      }
      return result;
   }
   
   public int selectBookCount(Book option) {
      Connection conn = getConnection();
      int result = 0;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         String sql = "SELECT COUNT(*) AS cnt FROM book";
         if(option.getBook_title() != null) {
            sql += " WHERE books_title LIKE CONCAT('%','"+option.getBook_title()+"','%')";
         }
         
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt("cnt");
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(pstmt);
         close(conn);
      }
      return result;
   }
   
   public List<Map<String,String>> SelectBookList(Book option){
      Connection conn = getConnection();
      List<Map<String,String>> list = new ArrayList<>();
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         String sql = "SELECT a.books_img AS 이미지, a.books_title AS 도서이름, a.books_author AS 저자, b.books_category_name AS 카테고리 , a.books_publisher_name AS 출판사 FROM book a\r\n"
               + "JOIN books_category b ON a.books_category_no = b.books_category_no";
            
         if(option.getBook_title() != null) {
            sql += " WHERE books_title Like CONCAT('%','" + option.getBook_title() + "', '%')"; 
         }
         sql += " LIMIT "+option.getLimitPageNo()+", "+option.getNumPerPage();
         
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
           while(rs.next()){
                   Map<String, String> row = new HashMap<>();
           
                   row.put("books_img",rs.getString("이미지"));
                   row.put("books_title", rs.getString("도서이름"));
                   row.put("books_author", rs.getString("저자"));
                   row.put("books_category_name", rs.getString("카테고리"));
                   row.put("books_publisher_name", rs.getString("출판사"));
                   list.add(row);
                   System.out.println(list);
               }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rs);
         close(pstmt);
      }
      return list;
   }
   
   public int deleteBook(Book bk) {
      Connection conn = getConnection();
      PreparedStatement pstmt = null;
      int result = 0;
      try {
         String sql = "DELETE FROM book WHERE books_img = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, bk.getBook_img());
         result = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(conn);
      }
      return result;
   }
   
   public int editBook(Book bk) {
      Connection conn = getConnection();
      PreparedStatement pstmt = null;
      int result = 0;
      try {
         String sql = "UPDATE `book` SET books_img = ?, books_title = ?, books_author =? , books_category_no = ?, books_publisher_name = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, bk.getBook_img());
         pstmt.setString(2, bk.getBook_title());
         pstmt.setString(3, bk.getBook_author());
         pstmt.setInt(4, bk.getBook_category_no());
         pstmt.setString(5, bk.getBook_publisher_name());
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(conn);
      }
      return result;
   }
   
   
   
   
}

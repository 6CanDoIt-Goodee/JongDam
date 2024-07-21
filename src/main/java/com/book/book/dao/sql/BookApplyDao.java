package com.book.book.dao.sql;

import static com.book.book.dao.sql.JDBCTemplate.close;
import static com.book.book.dao.sql.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.book.vo.BookApply;

public class BookApplyDao {
	
	public int selectBookApplyCount(BookApply option) {
	      Connection conn = getConnection();
	      int result = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         String sql = "SELECT COUNT(*) AS cnt FROM book";
	         if(option.getApply_no() != 0) {
	            sql += " WHERE books_title LIKE CONCAT('%','"+option.getApply_no()+"','%')";
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
	
	
	
	
	
	public List<Map<String, String>> SelectBookApplyList(BookApply option){
	      Connection conn = getConnection();
	      List<Map<String,String>> list = new ArrayList<>();
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         String sql = "SELECT apply_no AS 신청번호, apply_bk_title AS 신청도서, apply_bk_author AS 신청작가, apply_bk_publisher AS 신청출판사 FROM book_apply ";
	            
	         if(option.getApply_no() != 0) {
	            sql += " WHERE apply_no Like CONCAT('%','" + option.getApply_no() + "', '%')"; 
	         }
	         sql += " LIMIT "+option.getLimitPageNo()+", "+option.getNumPerPage();
	         
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	           while(rs.next()){
	                   Map<String, String> row = new HashMap<>();
	                   row.put("apply_no",rs.getString("신청번호"));
	                   row.put("apply_bk_title", rs.getString("신청도서"));
	                   row.put("appy_bk_author", rs.getString("신청작가"));
	                   row.put("apply_bk_publisher", rs.getString("신청출판사"));
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
}

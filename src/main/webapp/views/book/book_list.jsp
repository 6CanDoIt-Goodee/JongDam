<%@page import="com.book.book.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<link rel="stylesheet" href="../../resources/css/book_list.css">
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h2>홈페이지 이름</h2>
            <ul>
                <li>회원 관리</li>
                <li>이벤트 관리
                    <ul>
                        <li>예약 이벤트 조회</li>
                        <li>진행 중인 이벤트 조회</li>
                    </ul>
                </li>
                <li>도서 관련 페이지
                    <ul>
            			<li><a href="/book/create">도서 등록</a></li>
						<li><a href="/book/list">도서 목록조회</a></li>
						<li><a href="/book/rqeuestEnd">도서 신청목록</a>
                    </ul>
                </li>
                <li>문의 사항 관련 페이지
                    <ul>
                        <li>문의 사항 조회</li>
                        <li>기타 문의 관리</li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="main-content">
            <div class="header">
                <h1>도서 정보 조회</h1>
                <div class="user-info">
                    <span>회원관리 관리자 페이지</span>
                    <span>admin님</span>
                    <button>로그아웃</button>
                </div>
            </div>
            <div class="book_list">
                <table>
                    <colgroup>
                        <col width="30%">
                        <col width="25%">
                        <col width="20%">
                        <col width="25%">
                    </colgroup>
                    <thead>
                        <tr>
                        	<th>이미지</th>
                            <th>도서명</th>
                            <th>저자</th>
                            <th>카테고리</th>
                            <th>출판사</th>
                            <th>수정</th>
                            <th>삭제</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%@ page import="com.book.book.controller.BookListServlet, java.util.*" %>
                        <%
                        List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("resultList");
                            for(int i = 0 ; i < list.size(); i++){ 
                            %>
                                <tr>
                                    <td><%=list.get(i).get("books_img") %></td> 
                                    <td><%=list.get(i).get("books_title")%></td>
                                    <td><%=list.get(i).get("books_author")%></td>
                                    <td><%=list.get(i).get("books_category_name")%></td>
                                    <td><%=list.get(i).get("books_publisher_name")%></td>
									<td>
										<form action="/book/editEnd" method="post">
										<input type="hidden" name="book_no" value="<%= list.get(i).get("books_no") %>">
	                                    	<input type="submit" value="수정">
	                                	</form>
                                	</td>
                                	<td>
		                                <form action="/deleteend/book" method="post">
		                                	<input type="hidden" id="books_img" name="books_img" value="<%=list.get(i).get("books_img") %>">
		                                    <input type="submit" value="삭제" onclick= "delect_list()">
		                                </form>
	                                </td>
                                </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<%Book paging = (Book)request.getAttribute("paging");%>
<% if (paging != null) { %>
    <div class="center">
        <div class="pagination">
            <% if (paging.isPrev()) { %>
                <a href="/book/list?nowPage=<%= (paging.getPageBarStart() - 1) %>">&laquo;</a>
            <% } %>
            <% for (int i = paging.getPageBarStart(); i <= paging.getPageBarEnd(); i++) { %>
                <a href="/book/list?nowPage=<%= i %>" 
                <%= paging.getNowPage() == i ? "class='active'" : "" %>>
                    <%= i %>
                </a>
            <% } %>
            <% if (paging.isNext()) { %>
                <a href="/book/list?nowPage=<%= (paging.getPageBarEnd() + 1) %>">&raquo;</a>
            <% } %>
        </div>
    </div>
<% 
}
%>
</body>
</html>

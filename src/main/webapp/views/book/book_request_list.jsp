<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.book.book.vo.BookApply"%>
<%@page import="com.book.book.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 신청 목록 페이지</title>
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
						<li><a href="/book/requestEnd">도서 신청목록</a></li>
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
                            <th>도서명</th>
                            <th>저자</th>
                            <th>출판사</th>
                            <th>진행상태</th>
                            <th>등록</th>
                            <th>반려</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                        List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("resultList");
                        for(int i = 0 ; i < list.size(); i++){ 
                        	int status = Integer.parseInt(list.get(i).get("apply_bk_status"));
                        %>
                            <tr>
                                <td><%=list.get(i).get("apply_bk_title")%></td>
                                <td><%=list.get(i).get("apply_bk_author")%></td>
                                <td><%=list.get(i).get("apply_bk_publisher")%></td>
                                <td><%=status == 1 ? "등록됨" : (status == -1 ? "반려됨" : "대기중")%></td>
                                <td> 
                                    <form action="/book/enterEnd?apply_no=<%=list.get(i).get("apply_no") %>" method="post">
                                        <input type="submit" value="등록">
                                    </form>
                                </td>
                                <td>
                                    <form action="/book/rejectEnd" method="post">
                                        <input type="hidden" id="apply_no" name="apply_no" value="<%=list.get(i).get("apply_no") %>">
                                        <input type="submit" value="반려">
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <% BookApply paging = (BookApply)request.getAttribute("paging"); %>
    <% if (paging != null) { %>
        <div class="center">
            <div class="pagination">
                <% if (paging.isPrev()) { %>
                    <a href="/book/requestEnd?nowPage=<%= (paging.getPageBarStart() - 1) %>">&laquo;</a>
                <% } %>
                <% for (int i = paging.getPageBarStart(); i <= paging.getPageBarEnd(); i++) { %>
                    <a href="/book/requestEnd?nowPage=<%= i %>" 
                    <%= paging.getNowPage() == i ? "class='active'" : "" %>>
                        <%= i %>
                    </a>
                <% } %>
                <% if (paging.isNext()) { %>
                    <a href="/book/requestEnd?nowPage=<%= (paging.getPageBarEnd() + 1) %>">&raquo;</a>
                <% } %>
            </div>
        </div>
    <% } %>
    
<script>
function checkRegistrationStatus(status) {
    if (status == 1) {
        alert("이미 등록되어 있습니다");
        return false;
    }
    return true;
}

function checkRejectionStatus(status) {
    if (status == -1) {
        alert("이미 반려되었습니다");
        return false;
    }
    return true;
}
</script>
</body>
</html>

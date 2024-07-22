<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.book.book.vo.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 도서 등록</title>
<link rel="stylesheet" href="../../resources/css/create_book.css">
</head>
<body>
<header>
    <nav id="header_nav">
        <a href="#" id="main_logo">Knock Book</a>
        <ul>
            <li><a href="#" class="header_list">회원 관리</a></li>
            <li><a href="#" class="header_list">관리자 페이지</a></li>
            <li><a href="#" class="header_list" id="header_join">admin</a></li>
            <li><a href="#" class="header_list" id="header_join">회원가입</a></li>
        </ul>
    </nav>
</header>
<main>
    <section id="left">
        <ul id="my">
            <li>회원관리</li>
            <li>이벤트 관리</li>
            <li>도서 / 관리 페이지</li>
            	<ul>
            		<li><a href="/book/create">도서 등록</a></li>
					<li><a href="/book/list">도서 목록 조회</a></li>
					<li><a href="/book/requestEnd">도서 신청 조회</a></li>
            	</ul>
            <li>문의 사항 관리 페이지</li>
        </ul>
    </section>
     <%@ page import="com.book.book.vo.Book, java.util.*" %>
    <section id="right">
        <div class="book_icon">
            <div class="book">
            <%  Book bk = (Book) request.getAttribute("Bookedit"); 
                    %>
                <form action="/book/edit" name="book_edit_form" method="post">
                	<input type="hidden" name = "book_no" id = "book_no" value="<%= bk.getBook_no()%>">
                    <label for="book_img">이미지 등록:</label>
                    <input type="text" name="book_img" id="book_img" value="<%= bk.getBook_img() %>">
                    <hr>
                    <label for="book_title">도서명: </label>
                    <input type="text" name="book_title" id="book_title" value="<%= bk.getBook_title()%>">
                    <hr>
                    <label for="book_author">저자: </label>
                    <input type="text" name="book_author" id="book_author" value="<%= bk.getBook_author()%>">
                    <hr>
                    <label for="book_publisher">출판사: </label>
                    <input type="text" name="book_publisher" id="book_publisher" value="<%= bk.getBook_publisher_name() %>">
                    <hr>
                    <label for="book_category">카테고리: </label>
                     <select name="book_category" id="book_category">
                        <option value="1" <%= bk.getBook_category_no() == 1 ? "selected" : "" %>>문학</option>
                        <option value="2" <%= bk.getBook_category_no() == 2 ? "selected" : "" %>>단편소설</option>
                        <option value="3" <%= bk.getBook_category_no() == 3 ? "selected" : "" %>>장편소설</option>
                    </select>
                    <hr>
                    <input type="button" value="수정" onclick="book_update();">
                    <input type="button" value="초기화" onclick="book_reset();">
                </form>
            </div>
        </div>
    </section>
</main>
<script>
function book_update() {
    const form = document.book_edit_form;
    if (!form.book_img.value) {
        alert("이미지주소를 입력하세요");
    } else if (!form.book_title.value) {
        alert("도서명을 입력하세요");
    } else if (!form.book_author.value) {
        alert("저자명을 입력하세요");
    } else if (!form.book_publisher.value) {
        alert("출판사를 입력하세요");
    } else {
        alert("수정되었습니다!");
        form.submit();
    }
}

function book_reset() {
    const form = document.book_edit_form;
    form.book_img.value = '';
    form.book_title.value = '';
    form.book_author.value = '';
    form.book_publisher.value = '';
    form.book_category.selectedIndex = 0;  
}
</script>
</body>
</html>

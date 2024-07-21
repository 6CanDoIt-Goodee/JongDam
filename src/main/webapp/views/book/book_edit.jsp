<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<li><a href="/book/apply">도서 신청 조회</a></li>
            	</ul>
            <li>문의 사항 관리 페이지</li>
        </ul>
    </section>
    <section id="right">
        <div class="book_icon">
            <div class="book">
                <form action="/book/edit" name="book_request_form" method="post">
                     <label for="book_img">이미지 등록:</label>
                    <input type="text" name="book_img" id="booktitle">
                    <hr>
                    <label for="book_title">도서명: </label>
                    <input type="text" name="book_title" id="book_title">
                    <hr>
                    <label for="book_author">저자: </label>
                    <input type="text" name="book_author" id="book_author" >
                    <hr>
                    <label for="book_publihser">출판사: </label>
                    <input type="text" name="book_publihser" id="book_publihser">
                    <hr>
                    <label for="book_category">카테고리: </label>
                    <select name="book_category" id="book_category">
                        <option value="1">문학</option>
                        <option value="2">단편소설</option>
                        <option value="3">장편소설</option>
						<option value="4">d</option>
						<option value="5">d</option>
						<option value="6">d</option>
						<option value="7">d</option>
						<option value="8">d</option>
						<option value="9">d</option>
						<option value="10">d</option>
                    </select>
                    <hr>
                    <input type="button" value="수정" onclick="book_plus();">
                    <input type="button" value="초기화" onclick="book_reset;">
                </form>
            </div>
        </div>
    </section>
</main>
<script>
function book_plus(){
    const form = document.book_request_form;
    if(!form.book_img.value){
		alert("이미지주소를 입력하세요");
    } else if(!form.book_title.value){
        alert("도서명을 입력하세요");
    } else if(!form.book_author.value){
        ale`rt("저자명을 입력하세요");
    } else if(!form.book_publihser.value){
        alert("출판사를 입력하세요");
    } else {
    	alert("수정되었습니다!")
        form.submit();
    }
}
</script>
</body>
</html>
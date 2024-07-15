<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 도서 등록</title>
  <link rel="stylesheet" href="../../resouerces">
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
                <li>문의 사항 관리 페이지</li>
            </ul>
        </section>
        <section id="right">
            <div class="book_icon">
                <div class="book">
                	<form action="#" name="book_request_form" mehtod="post">
                    <!--  <i class="bi bi-book" style="font-size: 8rem;"></i>-->
                    <lable for="img_up">이미지 등록:</lable>
                    <input type="text" id="img_up" placeholder="url을 입력하세요">
                    <hr>
                    <label for="book_title">도서명: </label>
                    <input type="text" name="book_title" id="book_title" placeholder= "도서명을 입력하세요"><hr>
                    <laebel for="book_author">저자: </laebel>
                    <input type="text" name="book_author" id="book_author" placeholder="저자를 입력하세요"><hr>
                    <label for="book_publihser">출판사</label>
                    <input type="text" name="book_publihser" id="book_publihser" placeholder="출판사를 입력하세요"><hr>
                    <label>카테고리: </label>
                    <select>
                        <option>선택안함</option>
                        <option>선택안함</option>
                        <!-- option 값은 데이터 베이스에 도서테이블의 book_category_no 값을 가지고 
                        book_category_name 값을 가지고 올것-->
                    </select><hr>
                	<input type="button" value="등록" onclick="book_plus();'">
                	<input type="button" value="취소">
                </form>
                </div>
            </div>
        </section>
    </main>
    <script>
    function book_plus(){
    	const form = document.book_request_form;
    	if(!form.book_titile.value){
    		alert("도서명을 입력하세요")
    	} else if(!form.book_author.value){
    		alert("저자명을 입력하세요")
    	} else if(!form.book_publisher.value){
    		alert("출판사를 입력하세요")
    	}
    }
    </script>
</body>
</html>
</body>
</html>
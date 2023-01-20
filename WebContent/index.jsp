<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나이쓰 멤버 웹</title>
		<link rel="stylesheet" href="/resources/css/main.css">
	</head>
	<body>
	<c:if test = "${sessionScope.memberId eq null }">
        <div id="container">
	    <h1>나이스 멤버 웹</h1>
	    <h2>로그인 페이지</h2>
	    <fieldset>
	        <legend>로그인</legend>
	        <form action="/member/login.kh" method="post">
	            ID: <input type="text" name="member-id" placeholder="ID"><br>
	            PW : <input type="password" name="member-pw" placeholder="PW"><br>
				<div id="login-area">
	            <input type="submit" value="로그인">
	            <input type="reset" value="취소">
				</div>
	        </form>
	    </fieldset>
	    <span><a href="/member/enrollView.kh">회원가입</a></span>
        </div>
      </c:if>
      <c:if test="${sessionScope.memberId ne null }"  >
        <span id="member-id-span">${sessionScope.memberId }</span>님 환영합니다.
	<input type="hidden" id="member-id" value="${sessionScope.memberId}">
	<a href = "/member/myInfo.kh?member-id=${sessionScope.memberId }">마이페이지</a>
	<a href="/member/logout.kh">로그아웃</a> <!-- 서블릿으로 해야함. 전달값 없음 -->
	<!-- <a href = "/member/remove.kh?member-id=${memberId }">회원탈퇴</a>바로탈퇴시켜버림 -->
	<a href="javascript:void(0);" onclick="removeCheck()">회원탈퇴</a>
	<!-- ↑a 태그 링크 기능 무효화 -->
	</c:if>
	<script>
		function removeCheck(){
			if(confirm("진짜 탈퇴할거야?")){
				//방법1.
				//var memberId = document.querySelector("#member-id").value;
				//var memberId = document.querySelector("#member-id-span").innerHTML;
				//방법2.
				var memberId = "${memberId}";
				location.href = "/member/remove.kh?member-id="+memberId;
			}		
		}
	</script>
	</body>
</html>
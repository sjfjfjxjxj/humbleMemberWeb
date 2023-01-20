<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>학생...학새애앵애</title>
<link rel="stylesheet" href="/resources/css/student.css">
</head>
<body>
	<c:if test="${sessionScope.studentId eq null }">
    <div>
		<h1>학생 고르인페이지</h1>
        <form action="/student/login.do" method="post">
            <fieldset>
                <legend>로그인정보</legend>
                <ul>
                    <li>
                        <label for="id">아이디</label>
                        <input type="text" id="id" placeholder="ID입력하쇼" name="student-id">
                    </li>
                    <li>
                        <label for="pw">비밀번호</label>
                        <input type="password" id="pw" placeholder="PW입력하쇼" name="student-pw">
                    </li>           
                </ul>
            </fieldset>
            <div>
                <input type="submit" value="로그인">
                <input type="reset" value="실행취소">
            </div>
        </form>
    </div>
    </c:if>
    <c:if test="${sessionScope.studentId ne null }">
     <span id="student-id-span">${sessionScope.studentId }</span>님 환영합니다.
     <input type="hidden" id="student-id" value="${sessionScope.studentId}">
	<a href = "/student/myInfo.do?student-id=${sessionScope.studentId }">마이페이지</a>
	<a href="/student/logout.do">로그아웃</a> <!-- 서블릿으로 해야함. 전달값 없음 -->
	<a href="javascript:void(0);" onclick="removeCheck()">회원탈퇴</a>
	<!-- ↑a 태그 링크 기능 무효화 -->
    </c:if>
    <script>
    	function removeCheck(){
    		if(confirm("탈퇴 ㄱ?")){
    			var studentId = document.querySelector("#student-id").value;
    			location.href="/student/delete.do?student-id="+studentId;
    		}
    	}
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/resources/css/member.css">
</head>
<body>
<!-- http://127.0.0.1:8888/member/myInfo.kh?member-id=khuser01 이걸로 접속하면 됨!! -->
	<h1>마이페이지</h1>
    <div>
        <form action="/member/update.kh" method="post">
            <fieldset>
                <legend>회원 상세 정보</legend>
                <ul id="member-register">
                    <li>                                                 <!-- ${ssessionScope.memberId}로 쓸순 있는데-->
                    <label for="member-id">아이디</label>				<!-- session은 탈취가 쉬워서 최소한만 저장해서 사용하기 -->
                    <input type="text" id="member-id" name="member-id" value="${member.memberId}" readonly>
                </li>
                <li>
                    <label for="member-pw">비밀번호</label>
                    <input type="password" id="member-pw" name="member-pw" value="${member.memberPw}">
                </li>
                <li>
                    <label for="member-name">이름</label>
                    <input type="text" id="member-name" name="member-name" value="${member.memberName}">
                </li>
                <li>
                    <label for="member-age">나이</label>
                    <input type="text" id="member-age" name="member-age" value="${member.memberAge}" readonly>
                </li>
                <li>
                    <label for="member-email">이메일</label>
                    <input type="text" id="member-email" name="member-email" value="${member.memberEmail}">
                </li>
                <li>
                    <label for="member-phone">전화번호</label>
                    <input type="text" id="member-phone" name="member-phone" value="${member.memberPhone}">
                </li>
                <li>
                    <label for="member-address">주소</label>
                    <input type="text" id="member-address" name="member-address" value="${member.memberAddress}">
                </li>
                <li>
                    <label for="member-gender">성별</label>   <!-- if문으로 인풋태그 전체 감싸면 선택된버튼 하나만 나와서 변경 못하게 됨 -->
                    <label for="member-male">남<input type="radio" id="member-male" name="member-gender" value="M"  <c:if test="${member.memberGender eq 'M' }"> checked</c:if>></label>
                    <label for="member-female">여<input type="radio" id="member-female" name="member-gender" value="F"  <c:if test="${member.memberGender eq 'F' }">checked</c:if>></label>
                </li><br>
                <li>
                    <label for="member-hobby">취미</label>
                    <input type="text" id="member-hobby" name="member-hobby" value="${member.memberHobby}">
                </li>
                 <li>
                    <label for="member-date">가입날짜</label> <!-- 바꾸는항목 아니라 name값 설정 안해도됨 -->
                    <input type="text" id="member-date"  value="${member.memberDate}">
                </li>
            </ul>
        </fieldset>
        <div>
            <input type="submit" value="수정하기">
			<input type="reset" value="초기화">

        </div>

        </form>

    </div>
</body>
</html>
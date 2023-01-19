<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/resources/css/member.css">
</head>
<body>
	<h1>마이페이지</h1>
    <div>
        <form action="">
            <fieldset>
                <legend>회원 상세 정보</legend>
                <ul id="member-register">
                    <li>
                    <label for="member-id">아이디</label>
                    <input type="text" id="member-id" name="member-id" value="${member.memberId}">
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
                    <input type="text" id="member-age" name="member-age" value="${member.memberAge}">
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
                    <label for="member-gender">성별</label>
                    <label for="member-male">남<input type="radio" id="member-male" name="member-gender" value="M"></label>
                    <label for="member-female">여<input type="radio" id="member-female" name="member-gender" value="F"></label>
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
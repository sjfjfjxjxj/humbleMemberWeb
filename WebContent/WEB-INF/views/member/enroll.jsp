<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/member.css">
</head>
<body>
	<h1>회원가입</h1>
	<h3>회원정보를 입력하세묘</h3>
	<div>
		<form action="/member/enrollView.kh" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<ul id="member-register">
					<li>
						<label for="member-id">아이디</label>
						<input type="text" id="member-id" name="member-id">
					</li>
					<li>
						<label for="member-pw">비밀번호</label>
						<input type="password" id="member-pw" name="member-pw">
					</li>
					<li>
						<label for="member-name">이름</label>
						<input type="text" id="member-name" name="member-name">
					</li>
					<li>
						<label for="member-age">나이</label>
						<input type="text" id="member-age" name="member-age">
					</li>
					<li>
						<label for="member-email">이메일</label>
						<input type="text" id="member-email" name="member-email">
					</li>
					<li>
						<label for="member-phone">전화번호</label>
						<input type="text" id="member-phone" name="member-phone">
					</li>
					<li>
						<label for="member-address">주소</label>
						<input type="text" id="member-address" name="member-address">
					</li>
					<li>
						<label for="member-gender">성별</label>
						<label for="member-male">남<input type="radio" id="member-male" name="member-gender" value="M"></label> <!-- ↓체크드해놓으면 기본값으로 체크돼있음 -->
						<label for="member-female">여<input type="radio" id="member-female" name="member-gender" value="F" checked="checked"></label>
					</li><br>
					<li>
						<label for="member-hobby">취미</label>
						<input type="text" id="member-hobby" name="member-hobby">
					</li>
				</ul>			
		</fieldset>
		<div>
			<input type="submit" value="가입하기">
			<input type="reset" value="초기화">
		</div>
	</form>
</div>
</body>
</html>
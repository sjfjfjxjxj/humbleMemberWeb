<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공!</title>
</head>
<body>
	<h1>로그인 성공 mira me~.~!!!</h1>
	<span id="member-id-span">${memberId }</span>님 환영합니다.
	<input type="hidden" id="member-id" value="${memberId}">
	<a href = "/member/myInfo.kh?member-id=${memberId }">마이페이지</a>
	<!-- <a href = "/member/remove.kh?member-id=${memberId }">회원탈퇴</a>바로탈퇴시켜버림 -->
	<a href="javascript:void(0);" onclick="removeCheck()">회원탈퇴</a>
	<!-- ↑a 태그 링크 기능 무효화 -->
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
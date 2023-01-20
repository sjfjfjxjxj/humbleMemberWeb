<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 마이페이지</title>
<link rel="stylesheet" href="/resources/css/student.css">
</head>
<body>
 <h1>학생 상세 정보 페이지</h1>
    <div>
        <form action="/student/update.do" method="post">
            <fieldset>
                <legend>학생정보</legend>
                <ul id="student-register">
                    <li>
                        <label for="">아이디</label>
                        <input type="text" name="student-id" value="${student.studentId}" readonly>
                    </li>
                    <li>
                        <label for="">비밀번호</label>
                        <input type="password" name="student-pw" value="${student.studentPw}">
                    </li>
                    <li>
                        <label for="">이름</label>
                        <input type="text" name="student-name" value="${student.studentName}">
                    </li>           
                    <li>
                        <label for="">이메일</label>
                        <input type="text" name="student-email" value="${student.studentEmail}">
                    </li>          
                    <li>
                        <label for="">전화번호</label>
                        <input type="text" name="student-phone" value="${student.studentPhone}">
                    </li>           
                    <li>
                        <label for="">주소</label>
                        <input type="text" name="student-address" value="${student.studentAddress}">
                    </li>            
                    <li>
                        <label for="">성별</label>
                        <input type="text" name="student-gender" value="${student.studentGender}">
                    </li>
                </ul>   
            </fieldset>
            <div>
                <input type="submit" value="수정하기">
                <input type="reset" value="실행취소">
            </div>
        </form>
    </div>
   
</html>
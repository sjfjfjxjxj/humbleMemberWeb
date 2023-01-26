<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet" href="/resources/css/notice.css">
</head>
<body>
	<h1>공지사항목록</h1>
    <table>
        <colgroup>
            <!--번호 제목 작성자 작성일 조회수-->
            <!--<col style="width:'10%'; text-align:center">-->
            <col width="10%">
            <col width="50%">
            <col width="10%">
            <col width="20%">
            <col width="10%">
        </colgroup>
        <thead>
            <tr>
                <th>글번호</th>
                <th>글제목</th>
                <th>글쓴이</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody >
        <!-- 주석 함부로 달면 오류난다.... -->
            <c:forEach items="${nList}" var="notice">
                <tr>
                    <td>${notice.noticeNo}</td>
                    <td><a href="/notice/detail?notice-no=${notice.noticeNo }">${notice.noticeSubject}</a></td>
                    <td>${notice.noticeWriter}</td>
                    <td>${notice.noticeDate}</td>
                    <td>${notice.viewCount}</td>
                </tr>
            </c:forEach>    
        </tbody>
    </table>
</body>
</html>
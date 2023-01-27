<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세조회</title>
<link rel="stylesheet" href="/resources/css/notice.css">
</head>
<body>
    <h1>공지사항 상세</h1>
    
        <ul>
            <li>
                <label>글번호</label>
                <span>${notice.noticeNo}</span>
<%--                 <input type="text" value="${notice.noticeNo}" class="border-remove" readonly> --%>
            </li>
            <li>
                <label>작성일</label>
                <input type="text" value="${notice.noticeDate}" class="border-remove" readonly>
            </li>
            <li>
                <label>글쓴이 </label>
                <input type="text" value="${notice.noticeWriter}" class="border-remove" readonly>
            </li>
            <li>
                <label>제목</label>
                <input type="text" value="${notice.noticeSubject}"  readonly>
            </li>
            <li>
                <label>내용</label>
                <textarea rows="30" cols="40">${notice.noticeContent}</textarea>
            </li>
        </ul>
        <a href="/notice/list">목록으로 이동</a>
        <a href="/notice/modify?notice-no=${notice.noticeNo }">수정하기</a>
        <a href="javascript:void(0)" onclick="deleteCheck();">삭제하기</a>
        <!--#은 동작하고있어서 페이지 맨위로 가고 보이드영 하면 동작 안해서 가만히 머무름-->
        
        <script>
            const deleteCheck = () => {
                var noticeNo = "${notice.noticeNo}"
                if(confirm("정말 삭제하시겠어요?")){
                    location.href="/notice/remove?notice-no="+noticeNo;
                }

               
                
            }
        </script>

</body>
</html>
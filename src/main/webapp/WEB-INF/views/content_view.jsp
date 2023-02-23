<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	글번호 : ${boardDto.bid } <br><br>
	글쓴사람 : ${boardDto.bmname } <br><br>
	글쓴아이디 : ${boardDto.bmid } <br><br>
	글제목 : ${boardDto.btitle } <br><br>
	글내용 : ${boardDto.bcontent } <br><br>
	글쓴일자 : ${boardDto.bdate } <br><br>
	<input type="button" value="글수정" onclick="javascript:window.location=''">
	<input type="button" value="글삭제" onclick="javascript:window.location=''">
	<input type="button" value="글목록" onclick="javascript:window.location='list'">
</body>
</html>
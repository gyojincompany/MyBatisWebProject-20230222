<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>게시판 글작성</h2>
	<hr>
	<form action="write">
		아이디 : [${mid }]<br><br> 
		이 름 : [${mname }]<br><br>
		제 목 : <input type="text" name="btitle" size="60"><br><br>
		내 용 : <textarea rows="10" cols="45" name="bcontent"></textarea><br><br>
		<input type="submit" value="글입력">
		<input type="button" value="글목록" onclick="javascript:window.location='list'">	
	</form>
</body>
</html>
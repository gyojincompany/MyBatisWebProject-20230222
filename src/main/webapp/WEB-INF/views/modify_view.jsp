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
	<form action="modifyOk">
	<input type="hidden" name="bid" value="${boardDto.bid }">
	글번호 : ${boardDto.bid } <br><br>
	글쓴사람 : ${boardDto.bmname } <br><br>
	글쓴아이디 : ${boardDto.bmid } <br><br>
	글제목 : <input type="text" value="${boardDto.btitle }" name="btitle" size="60"> <br><br>
	글내용 : <textarea rows="10" cols="45" name="bcontent">${boardDto.bcontent }</textarea> <br><br>
	글쓴일자 : ${boardDto.bdate } <br><br>
	<input type="submit" value="수정완료">
	<input type="button" value="글삭제" onclick="javascript:window.location='delete?bid=${boardDto.bid }'">
	<input type="button" value="글목록" onclick="javascript:window.location='list'">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록</title>
</head>
<body>
	
	<c:forEach items="${boardDtos }" var="bdto">
		글번호 : ${bdto.bid} / 글제목: ${bdto.btitle } / 글쓴이 : ${bdto.bmname } / 등록일 : ${bdto.bdate }
		<br> 
	
	</c:forEach>
	
</body>
</html>
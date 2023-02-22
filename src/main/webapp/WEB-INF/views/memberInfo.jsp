<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
</head>
<body>
	<h2>회원 정보 보기</h2>
	<hr>
	아이디 : ${memberDto.mid }<br><br>
	비밀번호 : ${memberDto.mpw }<br><br>
	이름 : ${memberDto.mname }<br><br>
	이메일 : ${memberDto.memail }<br><br>
	가입일 : ${memberDto.mdate }<br><br>
	<a href="index">index 으로 가기</a>
</body>
</html>
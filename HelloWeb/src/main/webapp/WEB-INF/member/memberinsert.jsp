<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 등록</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="memberInsert.do" method="post">
		ID: <input type = "text" name="id"><br>
		PW:<input type = "password" name="pass"><br>
		Name:<input type = "text" name="name"><br>
		Mail:<input type = "email" name="mail"><br>
		<input type="submit">
	</form>
</body>
</html>
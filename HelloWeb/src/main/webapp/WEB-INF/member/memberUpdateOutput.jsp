<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 결과 페이지</title>
</head>
<body>
	<%
	 String message = (String) request.getAttribute("message");
	%>
	<%
	if(message != null){
	%>
	<p><%=message %></p>
	<%
	}
	%>
	<p>회원목록으로 이동</p>
	<a href="memberList.do">목록이동</a>
</body>
</html>
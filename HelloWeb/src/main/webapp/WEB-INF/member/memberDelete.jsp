<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제.</title>
</head>
<body>

<h3>회원삭제조회(memberUpdateForm.jsp)</h3>
	
	<%
	  MemberVO member = (MemberVO) request.getAttribute("vo");
	  String message = (String) request.getAttribute("message");
	  if(message != null){
	%>
	  <p><%=message %></p>
	  <%
	  }
	  %>
	
	<form action="memberSearch.do">
		<input type="hidden" name="job" value="delete">
		찾을 ID: <input type="text" name ="id">
		<input type="submit" value="찾기">
	</form>
	<p></p>
	<%
	if(member != null){ // 조회된 정보가 있으면 화면 결과 표시.
	%>
	<h3>회원정보 삭제</h3>
	<form action="memberDelete.do">
		삭제할 ID: <input type="text" name="id" value="<%=member.getId() %>" readonly><br>
		<input type="submit" value="삭제">
	</form>
	<%
	}
	%>

</body>
</html>
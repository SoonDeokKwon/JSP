<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 자바 영역.
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("members"); // list 주소값.
		System.out.print(list);
	%>
	<table border="1">
		<thead>
			<th>회원 ID</th>
			<th>회원 이름</th>
		</thead>
		<tbody>
	<%
	    for (MemberVO member : list) {
	%>
	    <tr>
	    	<td>id: <%=member.getId() %></td>
	    	<td>name: <%=member.getName() %></td>
	    	<td>email: <%=member.getMail() %></td>
	    	
	    </tr> 
	<%
	    }
	%>
		</tbody>
	</table>
	
	<p>회원등록 페이지 이동</p>
	<a href="memberInsertForm.do">회원등록페이지</a>
	
</body>
</html>
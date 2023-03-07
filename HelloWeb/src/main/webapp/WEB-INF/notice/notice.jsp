<%@page import="co.dev.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/sidebar.jsp" %>
    <%@ include file="../includes/top.jsp" %>
    
    <%
    	NoticeVO vo = (NoticeVO) request.getAttribute("noitce");
    %>
    
    	<table class="table">
    		<tr>
    			<td>글번호</td>
    			<td><input type="text" name="nid" value="<%=vo.getNoticeId() %>"></td>
    			<td>조회수 [<b><%=vo.getHitCount() %></b>]</td>
    		</tr>
    		<tr>
    			<td>제목</td>
    			<td colspan=2><input type="text" name="title" value="<%=vo.getNoticeTitle() %>"></td>
    		</tr>
    		<tr>
    			<td>작성자</td>
    			<td colspan=2><input type="text" name="writer" value="<%=vo.getNoticeWriter() %>"></td>
    		</tr>
    		<tr>
    			<td>내용</td>
    			<td colspan=2><textarea cols="30" rows="5" name="subject" value="<%=vo.getNoticeSubject() %>"></textarea></td>
    		</tr>
    		<tr>
    			<td>파일</td>
    			<td colspan=2>
    				<%if (vo.getAttach() != null) { %>
    				<input type="file" name="attch"><%=vo.getAttach()%>
    				<%}else { %>
    				<input type="file" name="attch">
    				<%} %>
    			</td>
    		</tr>
    		<tr>
				<td colspan="2" align="center">
					<input type="submit" value="저장"> 
				</td>
    		</tr>
    	</table>
   
    
    
    <%@ include file="../includes/footer.jsp" %>
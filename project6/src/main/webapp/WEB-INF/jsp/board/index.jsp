<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.board.model.BoardDTO" %>
<%@ page import="com.web.board.model.BoardDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table>
	 	<thead>
	 	
	 	</thead>
	 	<tbody>
	 		<%
	 			List<BoardDTO datas = (List<BoardDto>) request.getAttribute("datas");
	 			for(BoardDTO data: datas) { 
	 		%>
	 			<tr>
	 				<td><%=data.getId() %></td>
	 				<td onclick="Location.href='<%=root + "/board+datail?id=" + data.getId() %>'"><%= data.getTitle() %></td>
	 				<td><%=data.getWriter() %></td>
	 				<td><%=data.getCreateDate() %></td>
	 				<td><%=data.getViewCount() %></td>
	 				<td><%=data.getGoodCount() %></td>
	 			</tr>
	 	</tbody>
	 
	</table>
</body>
</html>
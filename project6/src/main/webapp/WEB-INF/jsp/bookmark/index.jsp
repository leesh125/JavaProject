<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.web.bookmark.model.*"%>
<%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>북마크</title>
</head>
<body>
	<section>
		<form action="./bookmark" method="post">
			<div>
				<input type="text" name="nickname" placeholder="별칭">
				<input type="url" name="url" placeholder="주소를 입력하세요.">
				<button type="submit">전송</button>
			</div>
		</form>
	</section>
	<section>
		<ul>
		<% 
			List<BookMarkDTO> datas = (List<BookMarkDTO>) request.getAttribute("datas");
			for(BookMarkDTO data: datas) {
		%>
			<li><a href="<%=data.getUrl() %>" target="_blank"><%=data.getNickname() %></a></li>
		<% 
			}
		%>
		</ul>
	</section>
	
</body>
</html>
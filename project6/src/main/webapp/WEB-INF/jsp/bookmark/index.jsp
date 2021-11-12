<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.web.bookmark.model.*"%>
<%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>북마크</title>
    <link type="text/css" rel="stylesheet" href="/static/css/base.css">
    <link type="text/css" rel="stylesheet" href="/static/css/layout.css">
    <link type="text/css" rel="stylesheet" href="/static/css/form.css">
    <link type="text/css" rel="stylesheet" href="/static/css/button.css">
</head>
<body>
	<section class="main-center">
		<section>
			<form action="./bookmark" method="post">
				<div class="inline-form">
					<input type="text" class="col-1" name="nickname" placeholder="별칭">
					<input type="url" class="col-auto" name="url" placeholder="주소를 입력하세요.">
				</div>
				<div class="right-form">
                    <button type="submit">등록</button>
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
	</section>
	
</body>
</html>
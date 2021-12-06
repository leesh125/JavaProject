<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 테스트</title>
</head>
<body>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<div>
			<input type="text" name="title">
		</div>
		<div>
			<input type="file" name="uploadFile">
			<%
				if(request.getAttribute("error") != null) {
			%>
					<label><%= (String)request.getAttribute("error") %></label>
			<%
				}
			%>
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html> 
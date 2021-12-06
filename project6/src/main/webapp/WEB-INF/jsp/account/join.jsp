<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.account.model.*" %>
<%
	boolean isError = false;
	String errMsg = "";
	AccountDTO dto = new AccountDTO();
	if(request.getAttribute("error") != null) {
		isError = true;
		errMsg = (String) request.getAttribute("error");
		dto = (AccountDTO) request.getAttribute("account_data");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입 폼</title>
	<script type="text/javascript" src="/static/js/join.js"></script>
</head>
<body>
	<form action="./join" method="post">
		<div>
			<input type="text" name="username" value="<%=dto.getUsername() %>" placeholder="아이디" required>
		</div>
		<div>
			<input type="password" id="id_pass1" name="password" placeholder="패스워드" required>
		</div>
		<div>
			<input type="password" id="id_pass2" name="password_check" placeholder="패스워드 확인" required>
			<div><label></label></div>
		</div>
		<div>
			<input type="email" name="email" value="<%=dto.getEmail() %>" placeholder="이메일" required>
		</div>
		<div>
			<button type="submit">가입</button>
		</div>
	</form>
</body>
</html>
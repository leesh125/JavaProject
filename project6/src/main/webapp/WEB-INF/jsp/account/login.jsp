<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.AccountDTO" %>
<%
	AccountDTO dto = new AccountDTO("", "", "");
	boolean logined = false;
	
	if(session.getAttribute("logined") != null) {
		logined = (boolean) session.getAttribute("logined");
		dto = (AccountDTO) session.getAttribute("account_data");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="<%=logined %>" />
		</jsp:include>
	</header>
	<form action="./login" method="post">
		<%
			boolean isError = false;
			if(request.getAttribute("error") != null) {
				isError = true;
			}
		%>
		<div>
			<input type="text" name="username" value="<%=isError ? request.getParameter("username") : "" %>" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="password" placeholder="패스워드">
		</div>
		<%
			if(isError) {
		%>
			<div>
				<label><%=(String) request.getAttribute("error") %></label>
			</div>
		<%
			}
		%>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>
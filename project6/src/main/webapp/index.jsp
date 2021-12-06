<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.AccountDTO" %>
<%@ page import="javax.servlet.http.Cookie" %>

<%
	AccountDTO dto = null;	
	boolean logined = false;
	if(session.getAttribute("logined") != null) {
		logined = (boolean) session.getAttribute("logined");
		dto = (AccountDTO) session.getAttribute("account_data");
	}
%>
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <title>메인 화면</title>
</head>
<body>
    <%@ include file="./module/header.jsp" %>
    <ul>
    	<li><a href="/guest">방명록</a></li>
    	<li><a href="/upload">파일 업로드</a></li>
    	<%
    		if(logined) {
    	%>
	    	<!-- 로그인 상태인 경우 -->
	    	<li><a href="/info">회원정보</a></li>
	    	<li><a href="/logout">로그아웃</a></li>
    	<% } else { %>
	    	<!-- 로그인 상태가 아닌경우 -->
	    	<li><a href="/join">회원가입</a></li>
	    	<li><a href="/login">로그인</a></li>
	    <% } %>
    </ul>
    
    <% 
    String username = dto.getUsername();
   	%>
    
  	<h1><%=username %> 님 환영합니다.</h1>
</body>
</html> 
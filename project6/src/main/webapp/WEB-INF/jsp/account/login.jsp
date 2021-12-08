<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.AccountDTO" %>
<%-- core 라이브러리 : 변수 설정, 제어문, 반복문 처리와 관연된 기능 지능 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--fmt 라이브러리 : 숫자ㅡ 날짜 등의 형식과 관련된 기능 제공 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- function 라이브러리 : 문자열 처리와 관련된 함수 기능 제공 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true }" />
		</jsp:include>
	</header>
	<form action="${login_url}" method="post">
		<div>
			<input type="text" name="username" value="${param.usernmae}" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="password" placeholder="패스워드">
		</div>
		<c:if test="${isError}">
			<div>
				<label>${error}</label>
			</div>		
		</c:if>

		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>
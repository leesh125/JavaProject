<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true }" />
		</jsp:include>
	</header>
	<c:url var="login_url" value="/account/login" />
	<form action="${login_url}" method="post">
		<div>
			<input type="text" name="username" value="${param.username}" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="password" placeholder="패스워드">
		</div>
		<c:if test="${not empty error}">
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
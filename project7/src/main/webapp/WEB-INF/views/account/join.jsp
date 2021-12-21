<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession, com.web.project7.account.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
	boolean isError = false;
	boolean logined = false;
	String errMsg = "";
	
	AccountDTO dto = new AccountDTO("", "", "");
	
	if(request.getAttribute("error") != null) {
		isError = true;
		errMsg = (String) request.getAttribute("error");
		dto = (AccountDTO) request.getAttribute("account_data");
	} else if (session.getAttribute("logined") != null) {
		logined = (boolean) session.getAttribute("logined");
		dto = (AccountDTO) session.getAttribute("account_data");
	}
--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입 폼</title>
	<c:url var="head_url" value="/WEB-INF/views/module/default_js_css.jsp" />
    <jsp:include page="${head_url}" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true }" />
		</jsp:include>
	</header>
	<section class="container">
		<h2>회원가입</h2>
		<div class="card border-dark">
			<div class="card-body text-dark">
				<form action="./join" method="post">
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_username">아이디</label>
						<div class="col-sm-10">
							<input class="form-control" type="text"
								name="username" value="${accountVO.username }" required>
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_password">패스워드</label>
						<div class="col-sm-10">
							<input class="form-control" type="password" id="id_password"
								name="password" required>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_passcheck">확인</label>
						<div class="col-sm-10">
							<input class="form-control" type="password" id="id_passcheck"
								name="password" required>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label" for="id_email">E-Mail</label>
						<div class="col-sm-10">
							<input class="form-control" type="email" id="id_email"
								name="email" value="${param.email }" required>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-11 col-form-label"></label>
						<div class="col-sm-1 text-end">
							<button class="btn btn-outline-primary" type="submit">가입</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html> 
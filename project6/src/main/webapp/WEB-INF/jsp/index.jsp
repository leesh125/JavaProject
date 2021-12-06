<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"
		import="com.web.account.model.AccountDTO" %>
<%@ page import="javax.servlet.http.Cookie" %>

<%
	AccountDTO dto = new AccountDTO("", "", "");	
	boolean logined = false;
	if(session.getAttribute("logined") != null) {
		logined = (boolean) session.getAttribute("logined");
		dto = (AccountDTO) session.getAttribute("account_data");
	}
	
	// 현재 JSP 페이지에서만 유효하게 사용할 경우
	pageContext.setAttribute("username", "page : " + dto.getUsername());
	pageContext.setAttribute("logined", logined);
	
	// 사용자 요청을 모두 처리할 떄까지 유효하게 사용할 경우
	request.setAttribute("username", "request : " + dto.getUsername());
	request.setAttribute("logined", logined);
	
	// 사용자의 세션이 만료될 깨까지 유효하게 사용할 경우
	session.setAttribute("username", "session : " + dto.getUsername());
	session.setAttribute("logined", logined);
	
	// 웹 어플리케이션이 종료될 때까지 유효하게 사용할 경우
	application.setAttribute("username", "application : " +  dto.getUsername()); 
%>
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <title>메인 화면</title>
    <jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
    <header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${logined }" />
		</jsp:include>
	</header>
    
  	<h1>${username } 님 환영합니다.</h1>
  	<h1>${username } 님 환영합니다.</h1>
  	<h1>${sessionScope.username } 님 환영합니다.</h1>
  	<h1>${applicationScope.username } 님 환영합니다.</h1>
  	
	${10 ge 5 }
	<br>
	${10 <= 5 }
	<br>
	${10 le 5 }
	<br>
	${true && true }
	<br>
	${true || true }
	<br>
	${true or true }
	<br>
	${!true}
	<br>
	${not true}
	<br>
	${empty ""}
	<br>
	${empty null }
	<br>
	${empty "1" }
	<br>
	${empty "" ? "비어있음" : "값있음" }
	<br>
	
</body>
</html> 
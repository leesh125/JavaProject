<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%-- 선언문 --%>
<%!
	private int num = 10;
	private int n = 1;
	private Random rand = new Random();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./module/header.jsp" %>

	<p>
		<%-- 스크립트 태그 표현식 입니다.
			<%=num %>
		--%>
		<%= rand.nextInt(10) %>
	</p>
	<p>
		<%
			// 스크립틀릿 안의 주석은 기본 자바 주석
			if(rand.nextInt(10) % 2 == 0){
				out.print("짝수 입니다.");
			} else {
				out.print("홀수 입니다.");
			}
		%>
	</p>
	
	<!-- JSP 로 1 ~ 9 까지의 목록 만들기 -->
	<ul>
		<% while(n < 10){ %>
			<li><%=n %></li>			
			<% n++;
		}
		%>		
	</ul>
	
</body>
</html>
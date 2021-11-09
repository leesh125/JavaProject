<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%!
    private int num = 10;
    private Random rand = new Random();
%>
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <title>First JSP</title>
</head>
<body>
    <%@ include file="./module/header.jsp" %>
    <p>
    	<%-- 스크립트 태그 표현식 입니다.
        	<%=num %>
        --%>
        <%=rand.nextInt(10) %>
    </p>
    <p>
        <%
            // 스크립틀릿 안의 주석은 기본 자바 주석
            if(rand.nextInt(10) % 2 == 0) {
                out.print("짝수 입니다.");
            } else {
                out.print("홀수 입니다.");
            }
        %>
    </p>
    <!-- JSP 로 1 ~ 9 까지의 목록 만들기 -->
    <ul>
        <% for(int i = 1; i <= 9; i++) { %>
            <li><%=i %></li>
        <% } %>
    </ul>
    <a href="#">회원가입</a>
</body>
</html> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
		import="com.web.board.model.*" %>
<%-- core 라이브러리 : 변수 설정, 제어문, 반복문 처리와 관연된 기능 지능 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--fmt 라이브러리 : 숫자ㅡ 날짜 등의 형식과 관련된 기능 제공 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- function 라이브러리 : 문자열 처리와 관련된 함수 기능 제공 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<jsp:include page="/WEB-INF/jsp/include/head1.jsp" flush="false" />
</head>
<body>
	<%-- 반복문 forEach
		 begin : 초기값
		 end: 종료값
		 step: 증감값
		 var: 반복할 떄마다 begin 에서 end 까지의 step 씩 증감하는 값을 저장하기위한 변수명
	 --%>
	 
	 <%-- 반복문 forEach
		 varStatus: 반복 상태를 알아내기위해 사용할 객체명을 지정한다.
		 		.index: items에 정의한 항목을 가리키는 index 번호(0부터 시작)
		 		.count: 몇번째 반복인지 나타냄(1부터 시작)
		 		.first: 첫번째 반복인지 확인(boolean)
		 		.last: 마지막 반복인사의 방문
	 --%>
	<header>
		<jsp:include page="/WEB-INF/jsp/module/top-navigation.jsp" flush="false" >
			<jsp:param name="logined" value="${empty sessionScope.logined ? false : true}" />
		</jsp:include>
	</header>
	<div>
		<ul class="nav nav-tabs nav-pills">
			<c:forEach var="cat" items="${category}">
				<li class="nav-item">
					<a class="nav-link ${type eq cat.getId() ? 'active' : '' }"
						href="/board?type=${cat.getId()}">${cat.getName()}게시판</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	
	<ul>
		<c:forEach var="i" begin="0" end="9" step="1" varStatus="l">
			<c:if test="${l.first}"><li>반복 시작!</li></c:if>
			<li>${i} 번째 반복</li>
			<c:if test="${l.last}"><li>반복 끝!</li></c:if>		
		</c:forEach>
	</ul>
	
	<ul>
		<c:forEach var="data" items="${datas}" varStatus="l">
			<li>${data.getTitle()}</li>
		</c:forEach>
	</ul>

	<c:if test="${type eq 'f'}">
		<h1>자유게시판</h1>
	</c:if>
	<c:if test="${type eq 'h'}">
		<h1>유머게시판</h1>
	</c:if>
	<c:if test="${type eq 's'}">
		<h1>시사게시판</h1>
	</c:if>
	<c:if test="${type eq 'y'}">
		<h1>연예게시판</h1>
	</c:if>
	<%-- 변수 설정
		 scope는 page, request, session, application 중 하나
	 --%>
	<c:set var="x" value="10" scope="page" />
	${x}
	
	<%
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("hi");
		list.add("JSTL");
		request.setAttribute("data",null);
	%>
	
	<%-- 표현언어로 객체를 사용할 수 있다. --%>
	${data}
	<%-- scope를 생략하면 기본 pageScope 이다.
		 c:set 에 객체를 담을 수 있다. --%>
	<c:set var="d" value="${data}" />
	<br>
	${d.get(0)} | ${d.get(1)} | ${d.get(2)}
	<br>
	${datas.get(0)} | ${datas.get(1)} | ${datas.get(2).getTitle()}
	
	<%-- 제어문 if --%>
	<c:if test="${d.get(0) eq 'hi'}">
	</c:if>
	
	<%-- 재어문 choose --%>
	<c:choose>
		<c:when test="조건식1">조건식 1이 참일 때 실행</c:when>
		<c:when test="조건식2">조건식 2가 참일 때 실행</c:when>
		<c:otherwise>모든 조건이 거짓일 때 실행</c:otherwise>
	</c:choose>
	
	<div>
		<button type="button" onclick="location.href='/board/add'">글쓰기</button>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="data" items="${datas}">
					<tr onclick="location.href='/board/detail?id=${data.getId()}'">
						<td>${data.getId()}</td>
						<td>${data.getTitle()}</td>
						<td>${data.getWriter()}</td>
						<td>${data.getCreateDate()}</td>
						<td>${data.getViewCount()}</td>
					</tr>
				</c:forEach>
				<%-- <% List<BoardDTO> datas = (List<BoardDTO>) request.getAttribute("datas"); %>
				<% for(BoardDTO data: datas) { %>
					<tr onclick="location.href='/board/detail?id=<%=data.getId() %>'">
						<th><%=data.getId() %></th>
						<th><%=data.getTitle() %></th>
						<th><%=data.getWriter() %></th>
						<th><%=data.getCreateDate() %></th>
						<th><%=data.getViewCount() %></th>
					</tr>
				<% } %> --%>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
		import="java.sql.Date"
		import="com.web.board.model.*" %>
<%-- core 라이브러리 : 변수 설정, 제어문, 반복문 처리와 관연된 기능 지능 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--fmt 라이브러리 : 숫자ㅡ 날짜 등의 형식과 관련된 기능 제공 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- function 라이브러리 : 문자열 처리와 관련된 함수 기능 제공 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
					<a class="nav-link ${param.type eq cat.getId() ? 'active' : '' }"
						href="/board?type=${cat.getId()}">${cat.getName()}게시판</a>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<div>
		<table class="table table-hover table-striped">
			<colgroup>
				<col class="col-1">
				<col class="col-4">
				<col class="col-2">
				<col class="col-2">
				<col class="col-1">
			</colgroup>
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
					<c:url var="detail_url" value="/board/detail">
						<c:param name="id" value="${data.getId()}" />
					</c:url>	
					<tr onclick="location.href='${detail_url}'" style="cursor:pointer;">
						<td class="text-end">${data.getId()}</td>
						<td>${data.getTitle()}</td>
						<td>${data.getWriter()}</td>
						<td><fmt:formatDate value="${data.getCreateDate()}" pattern="YYYY/MM/DD" /></td>
						<td><fmt:formatNumber value="${data.getViewCount()}" type="number" /></td>
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
		<div>
			<c:url var="search_url" value="/board" />
			<form action="${search_url}">
				<div class="input-group w-25">
					<input class="form-control" type="text" name="search" placeholder="제목">
					<button class="btn btn-outline-dark" type="submit">검색</button>
				</div>
			</form>
		</div>
	</div>
	
	<ul>
		<c:forEach var="i" begin="0" end="3" step="1" varStatus="l">
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
	${list}
	<%-- scope를 생략하면 기본 pageScope 이다.
		 c:set 에 객체를 담을 수 있다. --%>
	<c:set var="d" value="${datas}" />
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
	
	<div class="text-end">
		<c:url var="add_url" value="/board/add" />
		<button type="button" class="btn btn-outline-dark btn-sm" onclick="location.href='${add_url}'">글쓰기</button>
	</div>
	
	<ul>
		<c:set var="str" value="a, b, c, d, e, f" />
		<c:forTokens var="s" items="${str}" delims=",">
			<li>${s}</li>
		</c:forTokens>
	</ul>
	<%--
		value: 변환할 값
		var: 변환된 값이 저장될 변수
		type: 추력될 타입(percent:%, number, currency:통화형식)
		currencySymbol: 통화 타입일 때 출력할 통화 문자(＄, ￦, ￡)
		groupingUsed: 콤마들의 기호로 단위 구분을 나타내도록 함, true(기본값)면 콤마 구분을 함.
	 --%>
	 <fmt:formatNumber value="10" type="number" var="x"  />
	 ${x}%
	 
	 <%--
	 	value: 포맷 변환할 날짜 데이터
	 	type: 날짜(date), 시간(time), 날짜/시간(both) 변환인지를 구분
	 	dateStyle: 날짜 출력 형식을 지정(full, long, medium, short)
	 	timeStyle: 시간 출력 형식을 지정(자바 클래스 DateFormat에 정의된 형식을 사용)
	 	pattern: 직접 출력 형식을 지정(자바 클래스 SimpleDateFormat에 지정된 패턴을 사용)
	 	timeZone: 특정 나라의 시간대로 설정 
	 	
	 	<fmt:formatDate value="" type="" dateStyle="" timeStyle="" pattern="" timeZone=""/>
	  --%>
	  
	  <c:set var="now" value="<%=java.sql.Date.valueOf(\"2021-12-08\") %>" />
	  ${now}<br>
	  ----------------------Style: full-----------------<br>
	  <fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
	  <fmt:formatDate value="${now}" type="time" dateStyle="full"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	  ----------------------Style: long-----------------<br>
	  <fmt:formatDate value="${now}" type="date" dateStyle="long"/><br>
	  <fmt:formatDate value="${now}" type="time" dateStyle="long"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/><br>
	  ----------------------Style: medium-----------------<br>
	  <fmt:formatDate value="${now}" type="date" dateStyle="medium"/><br>
	  <fmt:formatDate value="${now}" type="time" dateStyle="medium"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/><br>
	  ----------------------Style: short-----------------<br>
	  <fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	  <fmt:formatDate value="${now}" type="time" dateStyle="short"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
	  ----------------------pattern-----------------<br>
	  <fmt:formatDate value="${now}" pattern="YYYY/MM/DD EEEE"/><br>
	  <fmt:formatDate value="${now}" pattern="hh:mm:ss E"/><br>
	  <fmt:formatDate value="${now}" pattern="HH:mm:ss.SSS"/><br>
	  <fmt:formatDate value="${now}" pattern="a hh:mm:ss"/><br>
	  ----------------------timeZone-----------------<br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" timeZone="America/New York"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" timeZone="Asia/Tokyo"/><br>
	  <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" timeZone="Europe/London"/><br>
	  
	 <hr>
	<c:set var="txt1" value="Hello JSTL" />
	<c:set var="txt2" value="JSTL 태그 라이브러리" />
	문자열 길이 fn:length() -> ${fn:length(txt1)}<br>
	문자열 길이 fn:length() -> ${fn:length(txt2)}<br>
	대소문자 변환 fn:toUpperCase() => ${fn:toUpperCase(txt1)}<br>
	대소문자 변환 fn:toLowerCase() => ${fn:toLowerCase(txt1)}<br>
	문자열 자르기 fn:substring() => ${fn:substring(txt2, 5, 7)}<br>
	공백 제거 fn:trim() => ${fn:trim(txt1)}<br>
	문자열 바꾸기 fn:replace() => ${fn:replace(txt2, "태그", "Tag")}<br>
	문자열 위치 찾기 fn:indexOf() => ${fn:indexOf(txt2, "태그")}<br>
	저장할 문자열 존재 유무 fn:contains() => ${fn:contains(txt2, "태그")}<br>
	문자열 분리 fn:split() => ${fn:split(txt2, " ")}<br>
	<c:forEach var="t" items="${fn:split(txt2, ' ')}">
		<span>${t}</span>
	</c:forEach>
	<c:set var="arr1" value="${fn:split(txt2, ' ')}" />
	${fn:join(arr1,"-")}
</body>
</html>
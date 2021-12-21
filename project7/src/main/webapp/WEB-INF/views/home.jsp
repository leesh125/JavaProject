<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<title>Home</title>
	<link type="text/css" rel="stylesheet" href="/static/bs-5.1.3/css/bootstrap.min.css">
	<script type="text/javascript" src="/static/bs-5.1.3/js/popper.min.js"></script>
	<script type="text/javascript" src="/static/bs-5.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/jquery/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img alt="정적이미지 불러오기" src="/img/illustration.png">
</body>
</html>
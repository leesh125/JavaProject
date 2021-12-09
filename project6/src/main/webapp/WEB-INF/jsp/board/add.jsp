<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 작성</title>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
</head>
<c:url var="ajax_url" value="/board/ajax/add" />
<script type="text/javascript">
function sendAjax() {
	$.ajax({
		type: "get",
		url: "${ajax_url}",
		data: {
			val: "데이터 전송 확인!"
		},
		dataType: "json",
		success: function(data, status) {
			// 여기에 기능을 구현.
			// data 인자는 서버가 전송한 데이터 이다.
			// document.getElementById("result").innerText = data.result;
			console.log(data);
			console.log(data.firstName);
			console.log(data.lastName);
			console.log(data.phoneNumbers);
			console.log(data.phoneNumbers[0]);
			console.log(data.phoneNumbers[1]);
			console.log(data.phoneNumbers[1].Home);
		},
		error: function(data, status) {
			// 여기에 기능을 구현.
			// data 인자는 서버가 전송한 데이터 이다.
			console.log("에러");
		}
	});
}
</script>
<body>
	<div>
		<input type="button" value="버튼" onclick="sendAjax();">
	</div>
	<hr>
	<div>
		<span>결과는 여기에 -></span><span id="result"></span>
	</div>
</body>
</html> 
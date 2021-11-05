<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private int i = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 진행 결과</title>
</head>
<body>
	<section>
		<h1>회원 가입 진행 결과</h1>
		<%
			request.setCharacterEncoding("UTF-8");
			System.out.println("id : " + request.getParameter("id"));
			System.out.println("password : " + request.getParameter("password"));
			if(request.getParameter("password") == request.getParameter("password_check")){
				System.out.println("password : " + request.getParameter("password_check"));	
			}else{
				System.out.println("패스워드 불일치!!");
			}
			System.out.println("name : " + request.getParameter("name"));
			System.out.println("year : " + request.getParameter("year"));
			System.out.println("month : " + request.getParameter("month"));
			System.out.println("day : " + request.getParameter("day"));
			System.out.println("gender : " + request.getParameter("gender"));
			System.out.println("email : " + request.getParameter("email"));
			System.out.println("phone : " + request.getParameter("phone"));
			System.out.println("input_phone : " + request.getParameter("input_phone"));
			System.out.println("input_certi : " + request.getParameter("input_certi"));
		%>
		<p>
			<%= request.getParameter("name") %>님의 정보를 잘 받았습니다.
		</p>
	</section>
</body>
</html>
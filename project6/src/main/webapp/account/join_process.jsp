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
			System.out.println("username : " + request.getParameter("username"));
			System.out.println("password : " + request.getParameter("password"));
			System.out.println("gender : " + request.getParameter("gender"));
			System.out.print("adv : ");
			String[] adv = request.getParameterValues("adv");
			if(adv != null){
				while(i<adv.length){
					System.out.print(adv[i] + " ");
					i++;	
				}
				/* for(String s: adv){
					System.out.print(s+ " ");
				} */
			}
			System.out.println();
			System.out.println("year : " + request.getParameter("year"));
			System.out.println("month : " + request.getParameter("month"));
			System.out.println("day : " + request.getParameter("day"));
			System.out.println("context : " + request.getParameter("context"));
		%>
		<p>
			<%= request.getParameter("username") %> 정보를 잘 받았습니다.
		</p>
	</section>
</body>
</html>
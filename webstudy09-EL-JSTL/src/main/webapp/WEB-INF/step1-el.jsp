<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-el</title>
</head>
<body>
<h2>step1 EL study</h2>
<%-- 
		아래 코드는 reques.getParameter("id")와 같은 표현
		EL을 이용하면 간결하게 표현이 가능하다
--%>
아이디 : ${param.id} <br>
이름 : ${requestScope.member.name}<br>
</body>
</html>
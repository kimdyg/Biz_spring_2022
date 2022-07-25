<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>login.jsp</title>
<style>
	html {
		width: 100vw;
		height: 100vh;
	}
	body {
		width: 100%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}
	form {
		width: 50%;
		text-align: center;
	}
	input {
		padding: 1rem;
		width: 100%;
		margin: 20% 60%;
	}

</style>

</head>
<%@ include file="/WEB-INF/views/header1.jsp" %>
<body>
	<form method="POST">
		<input name="username" placeholder="트레이너명 입력 후 Enter">
	
	</form>
</body>
</html>
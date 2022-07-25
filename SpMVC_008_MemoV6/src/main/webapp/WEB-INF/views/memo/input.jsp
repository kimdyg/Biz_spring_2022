<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>input.jsp</title>
<style>

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	background-image: url("../static/pika8.png");
	background-size: 50%;
}

form {
	width: 60%;
	text-align: center;
	margin : 6% 20%;
}

input {
	padding: 1.5rem;
	width: 100%;
	font-size: 1.5rem;
}
.file {
	color:red;
	font-weight: bold;
	text-shadow: 4px 4px 4px black;
	
}
button {
	background-color: red;
	color:yellow;
	font-size: 1.5rem;
}
</style>
</head>
<%@ include file="/WEB-INF/views/header1.jsp" %>
<body>
	<form method="POST" enctype="multipart/form-data">
		<input name="m_seq" type="hidden"
			value='<c:out value="${MEMO.m_seq}" default= "0"/>'> <input
			name="m_memo"
			placeholder="포켓몬빵 or 포켓몬고/ 지역(장소)/ 획득한 포켓몬사진↙↙"
			value="${MEMO.m_memo}" /> <input class="file"name="file" type="file"
			accept="images/*" />
		<button>메모기록</button>
	</form>
</body>
</html>
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
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

header {
	background-color: #ff0202;
	color: #ffeb3b;
	font-size: 7rem;
	height: 33vh;
	background-image: url("../static/pika.png");
	background-size: 30%;
	display: flex;
	align-items: flex-end;
	justify-content: space-around;
	text-shadow: 4px 4px 4px black;
}

body {
	width: 100%;
	height: 100%;
}

form {
	width: 50%;
	text-align: center;
}

input {
	padding: 1rem;
	width: 100%;
	
}
</style>
</head>
<header>
	<div>Ready Set 포켓몬 Go~</div>
</header>
<body>
	<form method="POST" enctype="multipart/form-data">
		<input name="m_seq" type="hidden"
			value='<c:out value="${MEMO.m_seq}" default= "0"/>'> <input
			name="m_memo" placeholder="포켓몬빵 or 포켓몬고/ 지역/ 파밍하러가요 사진↙↙에 제일쌘 포켓몬 자랑해주세요" value="${MEMO.m_memo}" /> <input
			name="file" type="file" accept="images/*" />
		<button>메모기록</button>
	</form>
</body>
</html>
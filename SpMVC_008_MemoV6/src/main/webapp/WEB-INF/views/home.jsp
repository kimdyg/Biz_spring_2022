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
<title>home.jsp</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

header {
	background-color: #ff0202;
	color: #ffeb3b;
	font-size: 7rem;
	height: 33vh;
	background-image: url("./static/pika.png");
	background-size: 30%;
	display: flex;
	align-items: flex-end;
	justify-content: space-around;
	text-shadow: 4px 4px 4px black;
}

div.trainer {
	background-image: url("./static/pika3.jpg");
	background-size: 20%;
	height: 10vh;
	font-size: 1.5rem;
	display: flex;
	align-items: flex-end;
	justify-content: space-around;
	color: blue;
	text-shadow: 4px 2px 2px black;
}

div.tableset {
	display: flex;
	justify-content: space-around;
	align-items: center;
	background-image: url("./static/pika6.PNG");
	background-size: 100%;
	font-size: 1.5rem;
	color: red;
}

th {
	padding: 0 60px;
	height: 10vh;
}

td {
	padding: 0 60px;
	text-align: center;
	height: 5vh;
}

div a {
	border: 1px solid black;
	background-color: yellow;
	color: red;
	font-size: 1.5rem;
}
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/memo.js?20220627003"></script>
</head>
<body>
	<header>
		<div>Ready Set 포켓몬 Go~</div>
	</header>
	<div class="trainer">
		<h1>${USERNAME} 트레이너님 안녕하세요~</h1>
	</div>
	<div class="tableset">
		<table class="memo">
			<div>
				<a href="${rootPath}/memo/insert">작성 GoGo</a>
			</div>
			<tr>
				<th>GoGoCount</th>
				<th>작성일자</th>
				<th>작성시간</th>
				<th>트레이너 모임</th>
			</tr>
			<c:if test="${empty MEMOS}">
				<tr>
					<td colspan="4">귀여운포켓몬이 있어요~
글을 작성해주세요</td>
				</tr>
			</c:if>
			<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<tr data-seq="${MEMO.m_seq}">
					<td>${INDEX.count}</td>
					<td>${MEMO.m_date}</td>
					<td>${MEMO.m_time}</td>
					<td>${MEMO.m_memo}</td>
				</tr>
			</c:forEach>
		</table>
		<div>
				<c:if test="${empty USERNAME}">
					<a href="${rootPath}/user/login">트레이너 등록</a>
				</c:if>
			<c:if test="${not empty USERNAME}">
				<a href="${rootPath}/user/logout">트레이너 휴식</a>
			</c:if>
		</div>
	</div>
</body>
</html>
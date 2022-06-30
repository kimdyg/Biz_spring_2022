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
		<h1>${USERNAME}트레이너님 안녕하세요~</h1>
	</div>
	<table class="memo">
		<tr>
			<th>SEQ</th>
			<th>작성일자</th>
			<th>작성시간</th>
			<th>메모</th>
		</tr>
		<c:if test="${empty MEMOS}">
			<tr>
				<td colspan="4">메모가 없습니다</td>
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
	<a href="${rootPath}/memo/insert">메모작성란</a>
	<c:if test="${empty USERNAME}">
		<a href="${rootPath}/user/login">로그인 기기</a>
	</c:if>
	<c:if test="${not empty USERNAME}">
		<a href="${rootPath}/user/logout">로그아웃 기기</a>
	</c:if>
</body>
</html>
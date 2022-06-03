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
<title>Insert title here</title>
<style>
table {
	width: 70vw;
	display: flex;
	justify-content: space-around;
	border-top: 2px solid blue;
	border-bottom: 2px solid blue;
}

.t1 {
	display: flex;
	justify-content: center;
}

td {
	padding: 10px 80px;
	font-size: 1.3rem;
}

table tr:nth-of-type(1) {
	border-bottom: 2px solid blue;
	background-color: purple;
	color: yellow;
}

.b1 {
	border: 1px solid white;
	border-radius: 5;
	display: flex;
	padding: 30px 15%;
}
button {
	margin-left: auto;
	font-size: 2rem;
	display: flex;
	font-style: inherit;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/home.jsp" %>

	<h1>도서정보 리스트 보여주기</h1>
	<div class="t1">
		<table>
			<tr>
				<td>No.</td>
				<td>ISBN</td>
				<td>도서명</td>
				<td>출판사</td>
				<td>저자</td>
				<td>출판일자</td>
			</tr>
			<c:forEach items="${BOOKS}" var="BOOK">
			<tr>
				<td>1</td>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
				<td>${book.publisher}</td>
				<td>${book.author}</td>
				<td>${book.pubdate}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="b1">
		<button type="button">
			<a href="${rootPath}/books/insert">도서정보추가</a>
		</button>
	</div>
</body>
</html>
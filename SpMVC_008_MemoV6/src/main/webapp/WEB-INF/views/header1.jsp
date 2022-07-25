<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
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
	background-image: url("${rootPath}/static/pika.png");
	background-size: 30%;
	display: flex;
	align-items: flex-end;
	justify-content: space-around;
	text-shadow: 4px 4px 4px black;
}
</style>
<header>
	<div>Ready Set 포켓몬 Go~</div>
</header>
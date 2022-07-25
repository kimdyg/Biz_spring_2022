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
	}

</style>
</head>
<%@ include file="/WEB-INF/views/header1.jsp" %>
<body>
	<div>트레이너 명 : ${MEMO.m_author}</div>
	<div>획득 일자 : ${MEMO.m_date}</div>
	<div>작성시각 : ${MEMO.m_time}</div>
	<div>메모 : ${MEMO.m_memo}</div>
	<div>이미지 : <br><img src="${rootPath}/upload/${MEMO.m_up_image}" alt="${MEMO.m_image}" width="60%"></div>
	<div>
		<a href="${rootPath}/memo/${MEMO.m_seq}/update">수정</a>
		<a href="${rootPath}/memo/${MEMO.m_seq}/delete">삭제</a>
		<a href="${rootPath}/">Comback HOME~</a> 
	</div>
</body>
</html>
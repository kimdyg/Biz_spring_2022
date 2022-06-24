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
<title>Insert title here</title>
<style>
	c:forEach {
		
	}
	img {
	
	border: 1px solid black;
	}

</style>
</head>
<body>
	<h1>메모리스트</h1>
	<a href="${rootPath}/bbs/write">메모장 글쓰기</a>
	<div class="images">
		<c:forEach items="${FILES}" var="FILE">
			<img src="${rootPath}/upload/${FILE.i_imageName}" width="100px" alt="${FILE}">
		</c:forEach>
	</div>
</body>
</html>
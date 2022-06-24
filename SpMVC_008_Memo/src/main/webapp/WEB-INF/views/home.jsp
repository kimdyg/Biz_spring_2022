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
</head>
<body>
	<h1>안녕</h1>
		<div class="images">
		<c:forEach items="${FILES}" var="FILE">
			<img src="${rootPath}/upload/${FILE.i_imageName}" width="100px" alt="${FILE}">
		</c:forEach>
	</div>
	<button>추가</button>
</body>
</html>
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
<table>
	<tr>
		<th>이름</th>
		<th>학번</th>
		<th>주소</th>
		<th>전화번호</th>
	</tr>
	<tr>
		<th>${STLIST.st_name}</th>
		<th>${STLIST.st_grade}</th>
		<th>${STLIST.st_addr}</th>
		<th>${STLIST.st_tel}</th>
	</tr>

</table>
</body>
</html>
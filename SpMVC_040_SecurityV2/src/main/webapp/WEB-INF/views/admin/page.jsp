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
	<h1>여기는 Admin Page</h1>
	<table class="w3-table w3-table-all">
	<tr>
		<th>USERNAME</th>
		<th>실명</th>
		<th>닉네임</th>
		<th>이메일</th>
	</tr>
	<c:forEach items="${USERLIST}" var="USERLIST">
	<tr>
		<td><a href="${rootPath}/admin/userupdate?username=${USERLIST.username}">${USERLIST.username}</a></td>
		<td>${USERLIST.realname}</td>
		<td>${USERLIST.nickname}</td>
		<td>${USERLIST.email}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
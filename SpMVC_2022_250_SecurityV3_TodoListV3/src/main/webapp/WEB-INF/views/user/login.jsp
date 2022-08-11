<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
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
		<h1>여긴 LOGIN HOME</h1>
		<form:form action="${rootPath}/user/login">
		<c:if test="${error == 'LOGIN_NEED'}">
			<div> * 로그인이 필요한 페이지에 접속했다</div>
		</c:if>
				<div><input name="username" placeholder="USERNAME"/></div>
				<div><input name="password" placeholder="PASSWORD"/></div>
				<div><button>로그인</button></div>
		</form:form>
</body>
</html>
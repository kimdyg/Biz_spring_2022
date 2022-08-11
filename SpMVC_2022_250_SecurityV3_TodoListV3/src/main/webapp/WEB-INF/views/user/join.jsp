<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입페이지</h1>
	<form:form>
		<div>
			<input name="username" placeholder="USERNAME">
			<input name="password" type="password"/>
			<input name="re_password" type="password"/>
			<input name="email" placeholder="이메일 입력" />
			<input name="realname" placeholder="실명입력" />
			<input name="nickname" placeholder="닉네임 입력" />
			<button>회원가입</button>
		</div>
	</form:form>

</body>
</html>
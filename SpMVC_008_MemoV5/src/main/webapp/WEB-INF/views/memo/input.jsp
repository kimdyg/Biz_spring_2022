<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	form#bbsVO {
		width: 60%;
		margin: 10px auto;
	}
	#bbsVO input, #bbsVO textarea {
		width: 90%;
		margin: 5px auto;
		padding: 8px;
	}

</style>
</head>
<body>
	<form:form modelAttribute="memoVO" enctype="multipart/form-data">
		<form:input path="m_date" type="text" />
		<form:input path="m_time" type="text" />
		<form:input path="m_author" type="text"/>
		<form:textarea path="m_memo"/>
		<form:input path="m_image"/>
		<input name="up_file" type="file"/>
		<button>작성완료</button>
	</form:form>

</body>
</html>
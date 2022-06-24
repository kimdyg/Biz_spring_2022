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
	<h2>작성자 : ${MEMO.m_writer}</h2>
	<h2>작성일자 : ${MEMO.m_date}</h2>
	<h2>작성시각 : ${MEMO.m_time}</h2>
	<h2>내용: ${MEMO.m_memo}</h2>
	<h2>이미지: ${MEMO.m_image}</h2>
	
	<c:forEach items="${MEMO.images}" var="IMAGE">
		<img src="${rootPath}/upload/${IMAGE.i_imageName}">
	</c:forEach>

</body>
</html>
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
body {
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}
/* 	background-image:
		url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA3MTVfMTc3%2FMDAxNjU3ODY3MjY3MjYx.xNlM2K_UJflNq8qyfMNORLXNPpy-KtPqzeCnHHRNpYIg.-A_57YRfu0aahC-M9Gh7CdR2bioVtuw0nCuckL2y5x4g.JPEG.sihyo29%2FIMG_9670.jpg&type=sc960_832");
	 */	 display: flex;
#main{
	background-color: white;
}
#main {
  font-family: system-ui, serif;
  font-size: 1rem;
  padding: 3rem;
  border-radius: 1rem;
}
</style>
</head>
<body>
	<div id="main">
		<h1>어디로 가야하죠 아저씨</h1>
		<h3>가게 명 : ${ADDR.a_name }</h3>
		<h3>전화번호 : ${ADDR.a_tel }</h3>
		<h3>주소 : ${ADDR.a_address}</h3>
		<div>
			<a href="${rootPath}/update?seq=${ADDR.a_seq}">수정하기</a>
			<a href="${rootPath}/delete?seq=${ADDR.a_seq}">삭제하기</a>
			<a href="${rootPath}/">처음으로</a>
		</div>
	</div>
</body>
</html>
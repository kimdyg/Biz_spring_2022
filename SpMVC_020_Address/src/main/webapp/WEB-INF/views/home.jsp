<%@page import="lombok.EqualsAndHashCode.Include"%>
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
	 display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}
/*  	background-image: */
/* 		url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA3MTVfMTc3%2FMDAxNjU3ODY3MjY3MjYx.xNlM2K_UJflNq8qyfMNORLXNPpy-KtPqzeCnHHRNpYIg.-A_57YRfu0aahC-M9Gh7CdR2bioVtuw0nCuckL2y5x4g.JPEG.sihyo29%2FIMG_9670.jpg&type=sc960_832"); */
	 

#main {
	background-color: white;
}

#main {
	font-family: system-ui, serif;
	font-size: 1rem;
	padding: 3rem;
	border-radius: 1rem;
}

a {
	text-decoration: none;
	color: black;
}

td {
	padding: 10px 20px;
}

h1 {
	text-align: center;
	font-size: 4rem;
}

tbody tr:hover {
	background-color: pink;
	color: yellow;
}
</style>
</head>

<script>
  const hypenTel = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}
</script>
<body>
	<div id="main" class="main">
		<h1>소주좀 주소</h1>
		<form method="POST">
			<div>
				<input name="a_seq" type="hidden"
					value="<c:out value='${ADDR.a_seq }' default="0" />" /> <input
					name="a_name" placeholder="식당명" value="${ADDR.a_name}" /> <input
					name="a_tel" placeholder="전화번호" type="text"
					oninput="hypenTel(this)" maxlength="13" value="${ADDR.a_tel}" /> <input
					name="a_address" placeholder="주소" value="${ADDR.a_address}" />
				<button>내 마음속에 저장</button>
			</div>
		</form>
		<table>
			<thead>
				<tr>
					<td>가게명</td>
					<td>전화를 받지 않는 너에게</td>
					<td>너는 지금 뭐해 밖이야?</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ADDRS}" var="ADDR">
					<tr>
						<td><a href="${rootPath}/detail?seq=${ADDR.a_seq}">${ADDR.a_name}</a></td>
						<td>${ADDR.a_tel}</td>
						<td>${ADDR.a_address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file ="/WEB-INF/views/pagination.jsp" %>
</body>
</html>
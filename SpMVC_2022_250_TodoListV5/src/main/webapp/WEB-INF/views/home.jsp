<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%> 
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	html {
		width: 100vw;
		height: 100vh;
	}
	body {
		display: flex;
		width: 100%;
		height: 100%;
		flex-direction: column;
	}
	header {
		padding:2rem;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	nav {
		background-color: blue;
		color: white;
	}
	nav ul {
		display: flex;
		list-style: none;
		
	}
	nav li {
		padding: 16px 12px;
		cursor: pointer;
	}
	nav a {
		text-decoration: none;
		color: inherit;
		margin: 5px 0;
		padding: 0 12px;
		border-bottom: 3px solid transparents;
		transition : 1s;
	}
	nav a:hover {
		border-bottom: 3px solid #ddd
	}
	nav li:nth-of-type(4) {
		margin-left: auto;
	}
	nav li:nth-of-type(1) {
		margin-left: 20px;
	}
	nav li:last-of-type {
		margin-right: 30px;
	}
	section.main {
		flex: 1;
	}
	article.welcome {
		height:100%;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	
</style>
</head>
<body>
<header>
	<h1>LOL</h1>
</header>
	<nav>
		<ul>
		
			<li><a href="${rootPath}/">HOME</a></li>
			<li><a href="${rootPath}/todo">나의 Todo</a></li>
			<li><a href="${rootPath}/about">About</a></li>
			
			<sec:authorize access="isAnonymous()">
			<li><a href="${rootPath}/user/login">로그인</a></li>
			<li><a href="${rootPath}/user/join">회원가입</a></li>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
			<li><a href="${rootPath}/">로그아웃</a></li>
			<li><a href="${rootPath}/user/mypage">myPage</a></li>
			</sec:authorize>
		</ul>
	</nav>
	<section class="main">
		<c:choose>
		<c:when test="${LAYOUT == 'JOIN' }">
			<%@ include file="/WEB-INF/views/user/join.jsp"%>
		</c:when>
		<c:when test="${LAYOUT == 'LOGIN' }">
			<%@ include file="/WEB-INF/views/user/login.jsp"%>
		</c:when>
		<c:when test="${LAYOUT == 'TODO_LIST' }">
			<%@ include file="/WEB-INF/views/todo/list.jsp"%>
		</c:when>
			<c:otherwise>
				<article class="welcome">
					<h1>L O L 애플리케이션 2022</h1>
					<p> L O L 을 사용하려면 회원가입, 로그인 ㄱㄱ
				
				</article>
			</c:otherwise>
		</c:choose>
	</section>

	<form:form class="logout" action="${rootPath}/logout">
	</form:form>

</body>
</html>
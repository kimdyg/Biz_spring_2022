<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div class="w3-container w3-card-4">
	<form:form class="w3-container">
		<c:if test="${error == 'PASS_FAIL'}">
			<div class="w3-text-red">
				* 비밀번호가 틀렷습니다 업데이트 불가!
			</div>
		</c:if>
	
		<label class="w3-blue">USERNAME</label>
		<input readonly="readonly" value='<sec:authentication property="principal.username"/>' class="w3-input w3-border">
		
		<label class="w3-blue">PASSWORD</label>
		<div class="w3-text-red"> * 입력한 비번은 확인용도이며 변경되지 않습니두</div>
		<input name="password" class="w3-input w3-border">
		
		<label class="w3-blue">EMAIL</label>
		<input name="email" value='<sec:authentication property="principal.email"/>'  class="w3-input w3-border">
		
		<label class="w3-blue">실명</label>
		<input name="realname" value='<sec:authentication property="principal.realname"/>'  class="w3-input w3-border">
		
		<label class="w3-blue">닉네임</label>
		<input name="nickname" value='<sec:authentication property="principal.nickname"/>'  class="w3-input w3-border">
		
		<label class="w3-blue">전화번호</label>
		<input name="tel" value='<sec:authentication property="principal.tel"/>'  class="w3-input w3-border">
		
		<button class="w3-button w3-blue">수정하기</button>
	</form:form>
</div>
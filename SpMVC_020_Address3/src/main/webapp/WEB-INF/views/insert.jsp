<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<script>
	document.addEventListener("DOMContentLoaded", () => {
	  const form = document.querySelector("form");
	  const username = document.querySelector("#username");
	  const tel = document.querySelector("#tel");
	  const address = document.querySelector("#address");
	  const btn = document.querySelector("#btn");

		  btn?.addEventListener("click", () => {
		    if (username.value === "") {
		      alert("USER NAME 은 반드시 입력하세요");
		      username.focus();
		      return false;
		    }
		    if (tel.value === "") {
		      alert("전화번호는 반드시 입력하세요");
		      tel.focus();
		      return false;
		    }
		    if (address.value === "") {
		      alert("주소는 반드시 입력하세요");
		      address.focus();
		      return false;
		    }
		    form.submit();

		  });
		});
</script>
<form method="POST">
		<input name="a_seq" type="hidden" 
			value='<c:out value="${ADDR.a_seq}" default="0"/>' />
		<input id="username" name="a_name" placeholder="이름" value="${ADDR.a_name}"/>
		<input id="tel" name="a_tel" placeholder="전화번호"  value="${ADDR.a_tel}"/>
		<input id="address" name="a_address" placeholder="주소"  value="${ADDR.a_address}"/>
		<button type="button" id="btn">저장</button>
	</form>
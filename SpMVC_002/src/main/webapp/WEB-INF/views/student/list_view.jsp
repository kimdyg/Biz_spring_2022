<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>
<style>
section {
	display: flex;
	flex-direction: column;
}
article {
	width:80%;
	margin:0 auto;
}
table {
	width:80%;
	margin: 0 auto;
	border-top: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
	border-collapse: collapse;
}
tr {
	border-bottom: 1px solid #ddd;
	border-top: 1px solid #ddd;
}
th, td {
	padding: 5px;
	text-align: left;
	cursor: pointer;
}
tr:nth-of-type(even) {/*  홀수 */
		background-color: #eee;
} 
tr:nth-of-type(odd) {/* 짝수 */
		background-color: #fff;
} 
tr:nth-of-type(n+2):hover {
	background-color: #ddd;
}
tr:not(:first-of-type):hover {
	background-color: #ddd;
}
div.button-box {
	width: 80%;
	margin: 5px auto;
	text-align: right;
	padding: 5px 0;
}
div.button-box a {
	display: inline-block;
	padding: 12px 16px;
	text-decoration: none;
	color: white;
	background-color: blue;
	border-radius: 5px;
}
div.button-box a:hover {
	box-shadow: 2px 2px 2px rgba(1,1,1,2.0)
}
</style>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jsp" %>
<%@ include file="/WEB-INF/views/include/include_nav.jsp" %>
	<section>
		<article>학생정보</article>
		<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>학년</th>
			<th>주소</th>
		</tr>
		<tr>
			<td>0001</td>
			<td>진모리</td>
			<td>내거친생각과</td>
			<td>3</td>
			<td>광주시 적혈구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>단모리</td>
			<td>불안한눈빛과</td>
			<td>3</td>
			<td>광주시 백혈구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>자진모리</td>
			<td>그걸지켜보는과</td>
			<td>3</td>
			<td>광주시 오구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>휘모리</td>
			<td>위키백과</td>
			<td>3</td>
			<td>광주시 오구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>오소리</td>
			<td>자주사각사각사과</td>
			<td>3</td>
			<td>광주시 오구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>홍길동</td>
			<td>황금사과</td>
			<td>3</td>
			<td>광주시 오구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>오모리</td>
			<td>선악과</td>
			<td>3</td>
			<td>광주시 오구 중동</td>
		</tr>
		<tr>
			<td>0001</td>
			<td>우뭇가사리</td>
			<td>무화과</td>
			<td>3</td>
			<td>광주시 오구 중동</td>
		</tr>
		</table>
		<div class="button-box">
			<a href="${pageContext.request.contextPath}/student/insert">학생정보 등록</a>
		</div>
		
	</section>
<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
	

</body>
</html>
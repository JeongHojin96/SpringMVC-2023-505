<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<c:set var="ymd" value="<%=new java.util.Date()%>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/resources/css/home.css?" rel="stylesheet">
</head>
<body>
	<h1>TO DO List 2023</h1>
	<form class=input>
		<div>
			<input type="date" placeholder ="작성일자" />
		</div>
		<div>
			<input placeholder = <fmt:formatDate value="${ymd}" pattern="hh:mm:ss" /> />
		</div>
		<div>
			<input placeholder ="할일"/>
		</div>
	</form>

	<table class="list">
		<tr>
			<th>No.</th>
			<th>할일</th>
			<th>완료여부</th>
		</tr>
		<tr>
			<td>21</td>
			<td>2</td>
			<td>3</td>
		</tr>
		<tr>
			<td>4</td>
			<td>5</td>
			<td>6</td>
		</tr>
	</table>

</body>
</html>
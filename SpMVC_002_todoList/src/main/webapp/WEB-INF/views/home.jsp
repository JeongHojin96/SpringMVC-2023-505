<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뭐</title>
<link href="${rootPath}/static/css/main.css?" rel="stylesheet">
</head>
<body>
	<header>
		<h1>반갑습니다</h1>
	</header>
	<section class="main">
		<form class="main">
			<input name="to_sdate" value="${TODO.to_sdate}" type="date"
				placeholder="작성일자"> 
			<input name="to_stime" value="${TODO.to_stime}" type="time" placeholder="작성시각"> 
			<input name="to_content" placeholder="할일">
		</form>
		<table class="list">
			<c:if test="${empty TODOS}">
				<tr>
					<td>데이터가없습니다</td>
				</tr>
			</c:if>
			<c:forEach items="${TODOS}" var="TO">
				<tr>
					<td>${TO.to_sdate}</td>
					<td>${TO.to_stime}</td>
					<td>${TO.to_content}</td>
				</tr>
			</c:forEach>
		</table>
	</section>

</body>
</html>
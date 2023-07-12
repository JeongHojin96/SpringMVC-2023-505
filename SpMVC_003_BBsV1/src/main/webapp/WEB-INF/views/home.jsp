<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>집가고싶다</title>
<link href="${rootPath}/static/css/table.css?" rel="stylesheet">
</head>
<body>
	<header class="main">
		<h1>이미지 겔러리</h1>
	</header>

	<table class="main">
		<tr>
			<th>seq</th>
			<th>date</th>
			<th>time</th>
			<th>username</th>
			<th>subject</th>
			<th>count</th>
		</tr>
		<c:forEach items="${BBS_LIST}" var="BBS">
			<tr>
				<td>${BBS.b_seq}</td>
				<td>${BBS.b_date}</td>
				<td>${BBS.b_time}</td>
				<td><a href="${rootPath}/search/user?username=${BBS.b_username}">${BBS.nickname}</a></td>
				<td><a href="${rootPath}/detail?seq=${BBS.b_seq}">${BBS.b_subject}</a></td>
				<td>${BBS.b_count}</td>
				
			</tr>
		</c:forEach>
	</table>
	<button></button>

</body>
</html>
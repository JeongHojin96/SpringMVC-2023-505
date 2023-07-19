<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="date" />
<fmt:formatDate value="${now}" pattern="HH:mm:ss" var="time" />
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY CAR</title>
<link href="${rootPath}/static/css/main.css?018" rel="stylesheet">
</head>

<body>

	<header class="main">
		<h1>MY CAR</h1>
		<p>MY CAR MANAGER 2023</p>
		<input class="now" name="c_sdate" value="${date}">
		<input class="now" name="c_stime" value="${time}">
		
	</header>
	
	<form class="main" method="POST"  >
		<p>운행등록
		<div><input name="c_cate" placeholder="구분"/></div>
		<div><input name="c_skm" placeholder="시작거리"/></div>
		<div><input name="c_place" placeholder="장소"/></div>
		<div><input name="c_ekm" placeholder="종료거리"/></div>
		<div><input name="c_fee" placeholder="소요비용"/></div>
		<div class="button-box"><button>저장</button></div>
	</form>

	<!-- car list -->
	<table class="main">
		<tr>
			<th>No.</th>
			<th>구분</th>
			<th>출발일자</th>
			<th>출발시간</th>
			<th>출발거리(Km)</th>
			<th>도착일자</th>
			<th>도착시간</th>
			<th>도착거리(Km)</th>
			<th>장소</th>
			<th>소요비용</th>
		</tr>
		<c:forEach items="${CAR_LIST}" var="CAR">
			<tr>
				<td>${CAR.c_seq}</td>
				<td>${CAR.c_cate}</td>
				<td>${CAR.c_sdate}</td>
				<td>${CAR.c_stime}</td>
				<td>${CAR.c_skm}</td>
				<td>${CAR.c_edate}</td>
				<td>${CAR.c_etime}</td>
				<td>${CAR.c_ekm}</td>
				<td>${CAR.c_place}</td>
				<td>${CAR.c_fee}</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>
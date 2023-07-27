<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리뷰</h1>

<div>
	<p>카테고리</p>
	<P>${REVIEW.b_ccode}</P>
</div>

<table class="review">
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>닉네임</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${not empty REVIEW}">
				<c:forEach items="${REVIEWS}" var="REVIEW">
					<tr>
						<td>${REVIEW.b_seq}</td>
						<td>
						<a href="${rootPath}/rivew/${REVIEW.b_seq}/detail">
						${REVIEW.b_title}</a>
						</td>
						<td>${REVIEW.b_nickname}</td>
						<td>${REVIEW.b_date}</td>
						<td>${REVIEW.b_viewcount}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	
	

<div class="write button">
		<a href="${rootPath}/">홈으로</a>
		<a href="${rootPath}/review/write">게시글작성</a>
	</div>
</body>
</html>
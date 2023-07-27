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
	
	<div><strong>카테고리 : </strong>${REVIEW.b_ccode}</div>
	
	<div><strong>제목 : </strong>${REVIEW.b_title}</div>
	<div><strong>작성자 : </strong>${REVIEW.b_nickname}</div>	
	<div><strong>작성일자 : </strong>${REVIEW.b_title}</div>
	<div><strong>조회수 : </strong>${REVIEW.b_viewcount}</div>
	
	<div><strong>내용 : </strong>${REVIEW.b_content}</div>
	
	<div><strong>사진 : </strong>${REVIEW.b_icode}</div>
	
	<div>
		<a href="${rootPath}/review">리스트로</a>
		<a href="${rootPath}/review/${REVIEW.b_seq}/update">수정하기</a>
		<a href="${rootPath}/review/${REVIEW.b_seq}/delete">삭제하기</a>
	</div>




</body>
</html>


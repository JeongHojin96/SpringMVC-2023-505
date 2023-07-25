<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 ${STATE == 'UPDATE' ? '수정' : '추가' }</h1>
	
	<c:if test="${not empty MESSAGE && MESSAGE == 'NAME_TEL'}">
	<h3>
		* 이미 등록된 이름과 전화번호
	</h3>
	</c:if>
	<f:form modelAttribute="MEMBER">
		<c:if test="${STATE != 'UPDATE'}">
		</c:if>
		<div>
			<label>회원명</label>
			<f:input path="m_name" />
		</div>
		<div>
			<label>전화번호</label>
			<f:input path="m_tel" />
		</div>
		<div>
			<label>주소</label>
			<f:input path="m_addr" />
		</div>
		<div>
			<a href = "${rootPath}/member">리스트로</a>
			<button>저장하기</button>
			<button type="reset">새로작성</button>
		</div>
	</f:form>


</body>
</html>
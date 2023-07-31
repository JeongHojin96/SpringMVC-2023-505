<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<f:form modelAttribute="BBS" enctype="multipart/form-data">
		<f:input placeholder ="제목"  path="b_title"/>
		<f:input placeholder ="내용" path="b_content"/>
		<f:input placeholder ="대표이미지" path="b_file" type="file" accept="image/*"/>
		<f:input placeholder ="이미지들" path="b_files" name="b_images" type="file" accept="image/*" multiple="multiple" />
		<button>저장</button>
	</f:form>

</body>
</html>
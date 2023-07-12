<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p>작성일자<p>
	<p>${BBS.b_date}</p>
	<p>작성시각</p>
	<p>${BBS.b_time}<p>
	<p>작성자</p>
	<p>${BBS.b_username}<p>
	<p>제목<p>
	<p>${BBS.b_subject}<p>
	<p>내용<p>
	<p>${BBS.b_content}<p>

</body>
</html>

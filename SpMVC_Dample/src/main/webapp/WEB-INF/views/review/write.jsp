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
	<h1>게시글 ${STATE == 'UPDATE' ? '수정' : '작성' }</h1>

	<f:form modelAttribute="WRITE">


		<label>게시판선택</label>
		<select name="b_ccode">
			<option value="B00001" selected>리뷰</option>
			<option value="C00001">소식</option>
			<option value="D00001">소개</option>
			<option value="E00001">추천</option>
		</select>
		
		<div>
			<label>제목</label>
			<f:input path="b_title" />
		</div>
		<div>
			<label>내용</label>
			<f:input path="b_content" />
		</div>
		<div>
			<label>사진</label>
			<f:input path="b_icode" />
		</div>
		<div>
			<label>작성자</label>
			<f:input path="b_nickname" />
		</div>
		<c:if test="${STATE != 'UPDATE' }">
			<div>
				<label>비밀번호</label>
				<f:input path="b_password" />
			</div>
		</c:if>
		<div>
			<button type="button" onclick="location.href='${rootPath}/'">목록으로</button>
			<button>저장하기</button>
			<button type="reset">새로작성</button>
		</div>
	</f:form>
</body>
</html>
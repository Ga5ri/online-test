<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>시험 문제수정</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/modifyQuestion">
		<c:forEach var="m" items="${list}">
		<table border="1">
			<tr>
				<th>문제 번호</th>
				<td><input type="number" name="questionIdx" value="${m.questionIdx}"></td>
			</tr>
			<tr>
				<th>문제</th>
				<td><textarea rows="3" cols="20" name="questionTitle">${m.questionTitle}</textarea></td>
			</tr>
			
		</table>
		</c:forEach>
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>
</body>
</html>
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
	<form method="post" action="${pageContext.request.contextPath}/teacher/question/modifyQuestion">
		<input type="hidden" name="questionNo" value="${questionNo}">
		<input type="hidden" name="testNo" value="${testNo}">
		<table border="1">
			<tr>
				<th>문제</th>
				<td><textarea rows="3" cols="20" name="questionTitle">${questionTitle}</textarea></td>
			</tr>		
		</table>
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>
</body>
</html>
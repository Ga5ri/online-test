<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>시험 수정</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/modifyTest">
	<input type="hidden" name="testNo" value="${testNo}">
		<table border="1">
			<tr>
				<th>시험명</th>
				<td><input type="text" name="testTitle"></td>
			</tr>
			<tr>
				<th>시험 일자</th>
				<td><input type="date" name="testDate"></td>
			</tr>
		</table>
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>
</body>
</html>
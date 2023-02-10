<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>시험 문제 등록</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/addQuestion">
		<table border="1">		
			<tr>
				<td>시험 회차 번호</td>
				<td><input type="number" name="testNo" value="${testNo}" readonly="readonly"></td>
			</tr>		
			<tr>
				<td>시험 문제 번호</td>
				<td><input type="number" name="questionIdx"></td>
			</tr>
			<tr>
				<td>시험 문제</td>
				<td><textarea rows="3" cols="20" name="questionTitle"></textarea></td>
			</tr>
		</table>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>시험 등록</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/addTest">
		<table border="1">
			<tr>
				<td>시험 제목</td>
				<td><input type="text" name="testTitle"></td>
			</tr>
		</table>
		<div>
			<button type="submit">등록하기</button>
		</div>
	</form>
</body>
</html>
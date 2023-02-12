<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보기 수정</h1>
	<table border="1">
		<tr>
			<th>보기 번호</th>
			<td><input type="number" name="exampleIdx"></td>
		</tr>
		<tr>
			<th>보기</th>
			<td><input type="text" name="exampleTitle"></td>
		</tr>
		<tr>
			<th>정답 유무</th>
			<td>
				<input type="radio" name="exampleOx" value="정답" <c:if test="${exampleOx == '정답'}"> checked </c:if>>정답
				<input type="radio" name="exampleOx" value="오답" <c:if test="${exampleOx == '오답'}"> checked </c:if>>오답
			</td>
		</tr>
	</table>
</body>
</html>
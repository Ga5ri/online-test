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
	<form action="${pageContext.request.contextPath}/teacher/example/modifyExample" method="post">
		<input type="hidden" name="questionNo" value="${questionNo}">
		<input type="hidden" name="exampleNo" value="${exampleNo}">
		<table border="1">
			<tr>
				<th>보기 번호</th>
				<td><input type="number" name="exampleIdx" value="${ex.exampleIdx}"></td>
			</tr>
			<tr>
				<th>보기</th>
				<td>
					<input type="text" name="exampleTitle" value="${ex.exampleTitle}">
				</td>
			</tr>
			<tr>
				<th>정답 유무</th>
				<td>
					<input type="radio" name="exampleOx" value="정답" <c:if test="${ex.exampleOx eq '정답'}"> checked </c:if>>정답
					<input type="radio" name="exampleOx" value="오답" <c:if test="${ex.exampleOx eq '오답'}"> checked </c:if>>오답
				</td>
			</tr>
		</table>
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>
</body>
</html>
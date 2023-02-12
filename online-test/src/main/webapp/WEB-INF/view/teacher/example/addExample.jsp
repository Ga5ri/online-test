<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보기 추가</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/example/addExample">
	<input type="hidden" name="questionTitle" value="questionTitle">
		<table>
			<tr>
				<th>문제 번호</th>
				<td><input type="number" name="questionNo" value="${questionNo}" readonly="readonly"></td>
			</tr>
			
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
					<input type="radio" name="exampleOx" value="정답">정답
					<input type="radio" name="exampleOx" value="오답">오답
				</td>
			</tr>
		</table>
		<div>
			<button type="submit">추가하기</button>
		</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>login Employee</h1>
	<form method="post" action="${pageContext.request.contextPath}/employee/loginEmp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="empId">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="empPw">
				</td>
			</tr>
		</table>
		<button type="submit">로그인</button>
	</form>
</body>
</html>
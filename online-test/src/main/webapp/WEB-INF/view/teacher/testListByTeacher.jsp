<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>시험 관리</h1>
	<a href="${pageContext.request.contextPath}/teacher/addTest">시험 등록</a>
	<table border="1">
		<tr>
			<th>시험 번호</th>
			<th>시험 제목</th>
			<th>등록 날짜</th>
		</tr>
		<c:forEach var="t" items="${list}">	
			<tr>
				<td>${t.testNo}</td>
				<td>
					<a href="${pageContext.request.contextPath}/teacher/testOne?testNo=${t.testNo}&testTitle=${t.testTitle}">
						${t.testTitle}
					</a>
				</td>
				<td>${t.testDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
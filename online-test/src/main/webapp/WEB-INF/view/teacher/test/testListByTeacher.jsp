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
	<a href="${pageContext.request.contextPath}/teacher/test/addTest">시험 등록</a>
	<table border="1">
		<tr>
			<th>시험 번호</th>
			<th>시험 제목</th>
			<th>시험 일자</th>
			<th>수정/삭제</th>
		</tr>
		<c:forEach var="t" items="${list}">	
			<tr>
				<td>${t.testNo}</td>
				<td>
					<a href="${pageContext.request.contextPath}/teacher/question/questionOne?testNo=${t.testNo}">
						${t.testTitle}
					</a>
				</td>
				<td>${t.testDate}</td>
				<td>
					<a href="${pageContext.request.contextPath}/teacher/test/modifyTest?testNo=${t.testNo}">수정</a>
					<a href="${pageContext.request.contextPath}/teacher/removeTest?testNo=${t.testNo}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
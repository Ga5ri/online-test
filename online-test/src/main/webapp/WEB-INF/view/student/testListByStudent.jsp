<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- jstl 페이지 include -->
	<div>
		<c:import url="/WEB-INF/view/student/inc/studentMenu.jsp"></c:import>
	</div>

	<h1>학생시험리스트</h1>
	<table border="1">
		<tr>
			<th>시험 번호</th>
			<th>시험 제목</th>
			<th>등록 날짜</th>
			<th>시험 응시</th>
		</tr>
		<c:forEach var="t" items="${list}">	
			<tr>
				<td>${t.testNo}</td>
				<td>${t.testTitle}</td>
				<td>${t.testDate}</td>
				<td><a href="${pageContext.request.contextPath}/student/takeQuestion?testNo=${t.testNo}">응시하기</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
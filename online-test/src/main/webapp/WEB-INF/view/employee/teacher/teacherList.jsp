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
		<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
	</div>

	<h1>Teacher List</h1>
	<a href="${pageContext.request.contextPath}/employee/teacher/addTeacher">강사등록</a>
	<table border="1">
		<tr>
			<th>teacherId</th>
			<th>teacherName</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="t" items="${list}">	
			<tr>
				<td>${t.teacherId}</td>
				<td>${t.teacherName}</td>
				<td><a href="${pageContext.request.contextPath}/employee/teacher/removeTeacher?teacherNo=${t.teacherNo}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<!-- 검색기능 -->
	<form method="get" action="${pageContext.request.contextPath}/employee/teacher/teacherList">
		<input type="text" name="searchWord" value="${searchWord}">
		<button type="submit">이름검색</button>
	</form>
	
	<!-- 페이징 -->
	<div>
		<a class="btn" href="${pageContext.request.contextPath}/employee/teacher/teacherList?currentPage=1&searchWord=${searchWord}">처음</a>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/employee/teacher/teacherList?currentPage=${currentPage-1}&searchWord=${searchWord}">&lt;</a>
		</c:if>
		<c:forEach var="index" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${index <= lastPage}">
				<c:choose>
					<c:when test="${index != currentPage}">
						<a href="${pageContext.request.contextPath}/employee/teacher/teacherList?currentPage=${index}&searchWord=${searchWord}">${index}</a>
					</c:when>
					<c:otherwise>
						<strong>${index}</strong>
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:forEach>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/employee/teacher/teacherList?currentPage=${currentPage+1}&searchWord=${searchWord}">&gt;</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/employee/teacher/teacherList?currentPage=${lastPage}&searchWord=${searchWord}">마지막</a>
	</div>
</body>
</html>
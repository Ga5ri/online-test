<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- jstl 페이지 include -->
		<div>
			<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
		</div>
	
		<h1>Employee List</h1>
		<a href="${pageContext.request.contextPath}/employee/addEmp">사원등록</a>
		<table border="1">
			<tr>
				<th>empId</th>
				<th>empName</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="e" items="${list}">	
				<tr>
					<td>${e.empId}</td>
					<td>${e.empName}</td>
					<td><a href="${pageContext.request.contextPath}/employee/removeEmp?empNo=${e.empNo}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- 검색기능 -->
		<form method="get" action="${pageContext.request.contextPath}/employee/empList">
			<input type="text" name="searchWord">
			<button type="submit">이름검색</button>
		</form>
		
		<!-- 페이징 -->
		<div>
			<a class="btn" href="${pageContext.request.contextPath}/employee/empList?currentPage=1&searchWord=${searchWord}">처음</a>
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/employee/empList?currentPage=${currentPage-1}&searchWord=${searchWord}">&lt;</a>
			</c:if>
			<c:forEach var="index" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${index <= lastPage}">
					<c:choose>
						<c:when test="${index != currentPage}">
							<a href="${pageContext.request.contextPath}/employee/empList?currentPage=${index}&searchWord=${searchWord}">${index}</a>
						</c:when>
						<c:otherwise>
							<strong>${index}</strong>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/employee/empList?currentPage=${currentPage+1}&searchWord=${searchWord}">&gt;</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/employee/empList?currentPage=${lastPage}&searchWord=${searchWord}">마지막</a>
		</div>
	</body>
</html>
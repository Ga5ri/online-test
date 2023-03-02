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
			<th>점수 확인</th>
		</tr>
		<c:forEach var="t" items="${list}">	
			<tr>
				<td>${t.testNo}</td>
				<td>${t.testTitle}</td>
				<td>${t.testDate}</td>
				<td>
					<!-- JOIN할지 따로 만들지 고민중 -->
					<c:choose>
						<c:when test="${score == 0}">
							응시완료
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/student/takeQuestion?testNo=${t.testNo}&testTitle=${t.testTitle}&studentNo=${loginStudent.studentNo}">응시하기</a>
						</c:otherwise>
					</c:choose>
				</td>
				<td><a href="${pageContext.request.contextPath}/student/paperOne?testNo=${t.testNo}&testTitle=${t.testTitle}&studentNo=${loginStudent.studentNo}">점수확인</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
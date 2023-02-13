<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	.td {
		text-align:center;
	}
</style>
</head>
<body>
	<h1>문제별 상세보기</h1>
	<a href="${pageContext.request.contextPath}/teacher/example/addExample?questionNo=${questionNo}">보기 추가</a>
	<br>
	<c:forEach var="m" items="${list}">
		<c:if test="${m.exampleIdx == 1}">
			<div><strong>${m.questionIdx}번 문제 ${m.questionTitle}</strong></div>
		</c:if>
	</c:forEach>
	<table border="1">
			<tr>
				<th>정답 번호</th>
				<th>정답 이름</th>
				<th>정답 유무</th>
				<th>수정/삭제</th>
			</tr>
			<c:forEach var="m" items="${list}">
				<tr>			
					<td class="td">${m.exampleIdx}</td>
					<td class="td">${m.exampleTitle}</td>
					<!-- 정답 active속성 주기 완료 -->
					<td class="td">
						<c:choose>
							<c:when test="${m.exampleOx == '정답'}">
								<strong>${m.exampleOx}</strong>
							</c:when>
							<c:otherwise>
								${m.exampleOx}
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/teacher/example/modifyExample?exampleNo=${m.exampleNo}&questionNo=${questionNo}">수정</a>
						<a href="${pageContext.request.contextPath}/teacher/example/removeExample?exampleNo=${m.exampleNo}&questionNo=${questionNo}">삭제</a>
					</td>				
				</tr>
			</c:forEach>		
	</table>
</body>
</html>
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
	<div><strong>${questionNo}번 문제 ${questionTitle}</strong></div>
	<table border="1">
			<tr>
				<th>정답 번호</th>
				<th>정답 이름</th>
				<th>정답 유무</th>
			</tr>
			<c:forEach var="m" items="${list}" varStatus="s">
				<tr>			
					<td class="td">${m.exampleIdx}</td>
					<td class="td">${m.exampleTitle}</td>
					<!-- 정답 active속성 주기 -->
					<td class="td">${m.exampleOx}</td>				
				</tr>
			</c:forEach>
	</table>
</body>
</html>
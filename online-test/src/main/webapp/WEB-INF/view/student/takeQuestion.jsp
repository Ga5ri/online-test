<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${testNo}회차 시험명:${testTitle}</h1>
	<c:forEach var="q" items="${qList}">
		<div>${q.questionIdx} 문제 : ${q.questionTitle}</div>
		<c:forEach var="e" items="${exList}">
			<c:if test="${e.exampleIdx =}">
				${e.exampleTitle}
			</c:if>	
		</c:forEach>

	</c:forEach>
</body>
</html>
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
		<c:forEach var="m" items="${list}">
					<c:if test="${m.exampleIdx == 1}">
						${m.questionIdx} 문제 : ${m.questionTitle}
					</c:if>
					<div>
						<c:if test="${m.exampleIdx == 1}">
							<input type="radio" name="answer${m.exampleIdx}" value="1">1. ${m.exampleTitle}
						</c:if>
						<c:if test="${m.exampleIdx == 2}">
							<input type="radio" name="answer${m.exampleIdx}" value="2">2. ${m.exampleTitle}
						</c:if>
						<c:if test="${m.exampleIdx == 3}">
							<input type="radio" name="answer${m.exampleIdx}" value="3">3. ${m.exampleTitle}
						</c:if>
						<c:if test="${m.exampleIdx == 4}">
							<input type="radio" name="answer${m.exampleIdx}" value="4">4. ${m.exampleTitle}
						</c:if>
					</div>
		</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:forEach var="a" items="${scoreList}">
		<h1>내 점수 : ${a.score} 점</h1>
	</c:forEach>
	<c:forEach var="s" items="${scoreQuestionList}" varStatus="i">
		<div>${s.questionIdx}번 문제 : ${s.questionTitle}</div>
		<div>내가 선택한 답 : <strong>${s.answer}</strong></div>
		<c:forEach var="e" items="${exList}">
			<c:if test="${s.questionNo == e.questionNo}">
				<div>
					<input type="radio" name="answer${i.index}" id="answer${i.index}" value="${e.exampleIdx}" <c:if test="${e.exampleOx eq '정답'}">checked</c:if>>
						${e.exampleIdx}. ${e.exampleTitle} ${e.exampleOx}
				</div>
			</c:if>				
		</c:forEach>
	</c:forEach>
</body>
</html>
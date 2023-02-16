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
	<form action="${pageContext.request.contextPath}/student/takeQuestion" method="post">
		<input type="hidden" name="testNo" value="${testNo}">
		<c:forEach var="q" items="${qList}">
			<div>${q.questionIdx}번 문제 : ${q.questionTitle}</div>
			<c:forEach var="e" items="${exList}" varStatus="i">
				<input type="hidden" name="questionNo" value="${e.questionNo}">
				<c:if test="${q.questionNo == e.questionNo}">
					<div>
						<input type="radio" name="answer[${i.index}]" value="e.exampleIdx">
							${e.exampleIdx}. ${e.exampleTitle}
					</div>
				</c:if>	
			</c:forEach>
		</c:forEach>
		<br>
		<div>
			<button type="submit">제출하기</button>
		</div>
	</form>
</body>
</html>
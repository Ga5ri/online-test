<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>시험 상세정보</h1>
	<div style="text-align:center"><strong>${testNo} 회차 ${testTitle} 시험</strong></div>
	<table border="1">
		<tr>
		<c:forEach var="m" items="${list}" varStatus="s">
			<!-- td 5개 줄바꿈 -->
			<c:if test="${s.index != 0 && s.index % 5 == 0}">
				</tr><tr>
			</c:if>
				<td>			
					<div>문제 번호 : ${m.questionIdx}</div>
					<div>
						문제 : 
						<a href="${pageContext.request.contextPath}/teacher/questionOne?questionNo=${m.questionNo}&questionTitle=${m.questionTitle}">
							${m.questionTitle}
						</a>
					</div>
					<div>
						<a href="${pageContext.request.contextPath}/teacher/modifyQuestionTitle?testNo=${testNo}&testTitle=${testTitle}">수정</a>
						<a href="${pageContext.request.contextPath}/teacher/modifyQuestionTitle?questionNo=${questionNo}">삭제</a>
					</div>
				</td>	
		</c:forEach>
		</tr>
	</table>
</body>
</html>
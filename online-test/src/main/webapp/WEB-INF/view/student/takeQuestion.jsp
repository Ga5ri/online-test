<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>시험</h1>
	<table border="1">
		<tr>
		<c:forEach var="m" items="${list}" varStatus="s">
			<!-- td 5개 줄바꿈 -->
			<c:if test="${s.index != 0 && s.index % 5 == 0}">
				</tr><tr>
			</c:if>
				<td>			
					<div>문제 번호 : ${m.questionIdx}</div>
					<div>문제 : ${m.questionTitle}</div>
					<div>
						<c:if test="${m.exampleIdx == 1}">
							<input type="radio" name="${m.exampleIdx}" value="1">${m.exampleTitle}
						</c:if>
						<c:if test="${m.exampleIdx == 2}">
							<input type="radio" name="${m.exampleIdx}" value="2">${m.exampleTitle}
						</c:if>
						<c:if test="${m.exampleIdx == 3}">
							<input type="radio" name="${m.exampleIdx}" value="3">${m.exampleTitle}
						</c:if>
						<c:if test="${m.exampleIdx == 4}">
							<input type="radio" name="${m.exampleIdx}" value="4">${m.exampleTitle}
						</c:if>
					</div>
				</td>	
		</c:forEach>
		</tr>
	</table>
</body>
</html>
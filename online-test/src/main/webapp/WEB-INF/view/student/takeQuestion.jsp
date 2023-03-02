<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$(document).ready(function() {
		let question = ${qList.size()}
		let answer = document.querySelectorAll('.answer'); // 선택된 answer 요소를 배열로 반환
		console.log("qListSize:"+question);
		console.log("answer값:"+answer);
		$("#addPaperBtn").on("click", function(){
			for(let i=0; i<question; i++){
				let answerNo = $("input[name=answer"+(i)+"]:checked").val();
				$(answer[i]).val(answerNo);
				console.log("answerNo값:"+answerNo);
			}
			
			$("#addPaperForm").submit();
		});			
	});
	</script>
</head>
<body>
	<h1>${testNo}회차 시험명:${testTitle}</h1>
	<form action="${pageContext.request.contextPath}/student/addPaper" method="post" id="addPaperForm">
		<input type="hidden" name="testNo" value="${testNo}">
		<input type="hidden" name="studentNo" value="${studentNo}">
		<c:forEach var="q" items="${qList}" varStatus="i">
			<input type="hidden" name="questionNo" value="${q.questionNo}">
			<input type="hidden" name="answer" value="" class="answer">
			<div>${q.questionIdx}번 문제 : ${q.questionTitle}</div>
			<c:forEach var="e" items="${exList}">
				<c:if test="${q.questionNo == e.questionNo}">
					<div>
						<input type="radio" name="answer${i.index}" id="answer${i.index}" value="${e.exampleIdx}">
							${e.exampleIdx}. ${e.exampleTitle}
					</div>
				</c:if>	
			</c:forEach>
		</c:forEach>
		<br>
		<div>
			<button type="button" id="addPaperBtn">제출하기</button>
		</div>
	</form>
</body>
</html>
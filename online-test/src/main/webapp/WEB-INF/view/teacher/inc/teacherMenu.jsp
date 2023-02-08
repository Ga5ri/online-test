<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href="${pageContext.request.contextPath}/teacher/modifyTeacherPw">비밀번호수정</a>
	
	<!-- 
		시험회차(table:test) 관리(시험회차 CRUD)
		개별시험회차 클릭시 해당 회차 문제리스트 출력(문제 CRUD)
		개별문제 클릭시 해당 문제의 보기 리스트 출력(보기 CRUD)  
	-->
	<a href="${pageContext.request.contextPath}/teacher/testListByTeacher">시험관리</a>
	
	<a href="${pageContext.request.contextPath}/teacher/logout">강사로그아웃</a>
</div>

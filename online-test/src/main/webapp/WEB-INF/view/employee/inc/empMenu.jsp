<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href="${pageContext.request.contextPath}/employee/empList">사원관리</a>
	<!-- 등록 시 ID체크(employee + teacher + student) -->

	<a href="${pageContext.request.contextPath}/teacher/teacherList">강사관리</a>
	<!-- 강사 목록, 삭제 -->
	
	<a href="${pageContext.request.contextPath}/student/studentList">학생관리</a>
	<!-- 학생 목록, 삭제 -->
	
	<a href="${pageContext.request.contextPath}/employee/logout">로그아웃</a>
	<a href="${pageContext.request.contextPath}/employee/modifyEmpPw">비밀번호수정</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	ul.tabs{
		margin: 0px;
		padding: 0px;
		list-style: none;
	}
	
	ul.tabs li{
	  display: inline-block;
		background: #898989;
		color: white;
		padding: 10px 15px;
		cursor: pointer;
	}
	
	ul.tabs li.current{
		background: #e0e0e0;
		color: #222;
	}
	
	.tab-content{
	  display: none;
		background: #e0e0e0;
		padding: 12px;
	}
	
	.tab-content.current{
		display: inherit;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('ul.tabs li').click(function(){
			var tab_id = $(this).attr('data-tab');
	
			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');
	
			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		})
	
	});
</script>
</head>
<body>
	<c:if test="${loginEmp == null || loginTeacher == null || loginStudent == null}">
	<div>
		<ul class="tabs">
			<li class="tab-link current" data-tab="tab-1">사원</li>
			<li class="tab-link" data-tab="tab-2">강사</li>
			<li class="tab-link" data-tab="tab-3">학생</li>
		</ul>
	</div>
	<div id="tab-1" class="tab-content current">
		<h1>employee login</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="empId">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="empPw">
					</td>
				</tr>
			</table>
			<button type="submit">로그인</button>
		</form>
	</div>
	<div id="tab-2" class="tab-content">
		<h1>Teacher Login</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="teacherId">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="teacherPw">
					</td>
				</tr>
			</table>
			<button type="submit">로그인</button>
		</form>
	</div>
	<div id="tab-3" class="tab-content">
		<h1>Student Login</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="studentId">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="studentPw">
					</td>
				</tr>
			</table>
			<button type="submit">로그인</button>
		</form>
	</div>
	</c:if>
	
	<!-- 로그인 후 -->
	<c:if test="${loginEmp != null}">
		${loginEmp.empName}님 반갑습니다
		<a href="${pageContext.request.contextPath}/employee/logout">로그아웃</a>
	</c:if>
	<!-- 로그인 후 -->
	<c:if test="${loginTeacher != null}">
		${loginTeacher.teacherName}님 반갑습니다
		<a href="${pageContext.request.contextPath}/teacher/logout">로그아웃</a>
	</c:if>
	<!-- 로그인 후 -->
	<c:if test="${loginStudent != null}">
		${loginStudent.studentName}님 반갑습니다
		<a href="${pageContext.request.contextPath}/student/logout">로그아웃</a>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>online-test|loginPage</title>
		<style>
			body{
				padding-top:100px;
			  	margin:0;
			  	color:#6a6f8c;
			  	background:#EAEAEA;
			  	font:600 16px/18px 'Open Sans',sans-serif;
			}
			*,:after,:before{box-sizing:border-box}
			.clearfix:after,.clearfix:before{content:'';display:table}
			.clearfix:after{clear:both;display:block}
			a{color:inherit;text-decoration:none}
			
			.login-wrap{
			  	width:100%;
			  	margin:auto;
			  	max-width:525px;
			  	min-height:670px;
			  	position:relative;
				background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
			  	box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
			}
			.login-html{
			  	width:100%;
			  	height:100%;
			  	position:absolute;
			  	padding:90px 70px 50px 70px;
			  	background:rgba(40,57,101,.9);
			}
			.login-html .e-htm,
			.login-html .t-htm,
			.login-html .s-htm{
			  	top:0;
			  	left:0;
			  	right:0;
			  	bottom:0;
			  	position:absolute;
			  	transform:rotateY(180deg);
			  	backface-visibility:hidden;
			  	transition:all .4s linear;
			}
			.login-html .e,
			.login-html .t,
			.login-html .s,
			.login-form .group .check{
			  	display:none;
			}
			.login-html .tab,
			.login-form .group .label,
			.login-form .group .button{
			  	text-transform:uppercase;
			}
			.login-html .tab{
			  	font-size:22px;
			  	margin-right:15px;
			  	padding-bottom:5px;
			  	margin:0 15px 10px 0;
			  	display:inline-block;
			  	border-bottom:2px solid transparent;
			}
			.login-html .e:checked + .tab,
			.login-html .t:checked + .tab,
			.login-html .s:checked + .tab{
			  	color:#fff;
			  	border-color:#1161ee;
			}
			.login-form{
			  	min-height:345px;
			  	position:relative;
			  	perspective:1000px;
			  	transform-style:preserve-3d;
			}
			.login-form .group{
			  	margin-bottom:15px;
			}
			.login-form .group .label,
			.login-form .group .input,
			.login-form .group .button{
			  	width:100%;
			  	color:#fff;
			  	display:block;
			}
			.login-form .group .input,
			.login-form .group .button{
			  	border:none;
			  	padding:15px 20px;
			  	border-radius:25px;
			  	background:rgba(255,255,255,.1);
			}
			.login-form .group input[data-type="password"]{
			  	text-security:circle;
			  	-webkit-text-security:circle;
			}
			.login-form .group .label{
			  	color:#aaa;
			  	font-size:12px;
			}
			.login-form .group .button{
			  	background:#1161ee;
			}
			.login-form .group label .icon{
			  	width:15px;
			  	height:15px;
			  	border-radius:2px;
			  	position:relative;
			  	display:inline-block;
			  	background:rgba(255,255,255,.1);
			}
			.login-form .group label .icon:before,
			.login-form .group label .icon:after{
			  	content:'';
			  	width:10px;
			  	height:2px;
			  	background:#fff;
			  	position:absolute;
			  	transition:all .2s ease-in-out 0s;
			}
			.login-form .group label .icon:before{
			  	left:3px;
			  	width:5px;
			  	bottom:6px;
			  	transform:scale(0) rotate(0);
			}
			.login-form .group label .icon:after{
			  	top:6px;
			  	right:0;
			  	transform:scale(0) rotate(0);
			}
			.login-form .group .check:checked + label{
			  	color:#fff;
			}
			.login-form .group .check:checked + label .icon{
			  	background:#1161ee;
			}
			.login-form .group .check:checked + label .icon:before{
			  	transform:scale(1) rotate(45deg);
			}
			.login-form .group .check:checked + label .icon:after{
			  	transform:scale(1) rotate(-45deg);
			}
			.login-html .e:checked + .tab + .t + .tab + .s + .tab + .login-form .e-htm{
			  	transform:rotate(0);
			}
			.login-html .t:checked + .tab + .s + .tab + .login-form .t-htm{
			  	transform:rotate(0);
			}
			.login-html .s:checked + .tab + .login-form .s-htm{
			  	transform:rotate(0);
			}
		</style>
	</head>
	
	<body>
	
		<c:if test="${loginEmp == null || loginTeacher == null || loginStudent == null}">
			<div class="login-wrap">
				<div class="login-html">
					<input id="tab-1" type="radio" name="tab" class="e" checked><label for="tab-1" class="tab">Employee</label>
					<input id="tab-2" type="radio" name="tab" class="t"><label for="tab-2" class="tab">Teacher</label>
					<input id="tab-3" type="radio" name="tab" class="s"><label for="tab-3" class="tab">Student</label>
					<div class="login-form">
						<form method="post" action="${pageContext.request.contextPath}/login">
							<div class="e-htm">
					       		<div class="group">
									<label for="user" class="label">ID</label>
									<input id="user" type="text" class="input" name="empId" value="admin">
								</div>
								<div class="group">
									<label for="pass" class="label">Password</label>
									<input id="pass" type="password" class="input" data-type="password" name="empPw" value="1234">
					        	</div>
								<div class="group">
					          		<input type="submit" class="button" value="Sign In">
					        	</div>
							</div>
						</form>
				      	<form method="post" action="${pageContext.request.contextPath}/login">
							<div class="t-htm">
					       		<div class="group">
									<label for="user" class="label">ID</label>
									<input id="user" type="text" class="input" name="teacherId" value="t1">
								</div>
								<div class="group">
									<label for="pass" class="label">Password</label>
									<input id="pass" type="password" class="input" data-type="password" name="teacherPw" value="1234">
					        	</div>
								<div class="group">
					          		<input type="submit" class="button" value="Sign In">
					        	</div>
							</div>
						</form>
				      	<form method="post" action="${pageContext.request.contextPath}/login">
							<div class="s-htm">
					       		<div class="group">
									<label for="user" class="label">ID</label>
									<input id="user" type="text" class="input" name="studentId" value="s1">
								</div>
								<div class="group">
									<label for="pass" class="label">Password</label>
									<input id="pass" type="password" class="input" data-type="password" name="studentPw" value="1234">
					        	</div>
								<div class="group">
					          		<input type="submit" class="button" value="Sign In">
					        	</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</c:if>
	</body>
</html>
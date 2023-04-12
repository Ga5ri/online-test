<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>    	
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Online-test|Emp</title>
	
	    <!-- Custom fonts for this template -->
	    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this page -->
	    <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	</head>
	
	<body>
	<!-- Sidebar -->
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
	
	    <!-- Sidebar - Brand -->
	    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/employee/empList">
	        <div class="sidebar-brand-icon rotate-n-15">
	            <i class="fas fa-laugh-wink"></i>
	        </div>
	        <div class="sidebar-brand-text mx-3">Online-Test</div>
	    </a>
	
	    <!-- Divider -->
	    <hr class="sidebar-divider my-0">
	
	    <!-- Nav Item - Dashboard -->
	    <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/employee/empList">
	            <i class="fas fa-fw fa-tachometer-alt"></i>
	            <span>Home</span></a>
	    </li>
	
	    <!-- Divider -->
	    <hr class="sidebar-divider">
	
	    <!-- Heading -->
	    <div class="sidebar-heading">
	        Interface
	    </div>
	
	    <!-- Nav Item - Pages Collapse Menu -->
	    <li class="nav-item">
	        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
	            aria-expanded="true" aria-controls="collapseTwo">
	            <i class="fas fa-fw fa-cog"></i>
	            <span>관리</span>
	        </a>
	        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
	            <div class="bg-white py-2 collapse-inner rounded">
	                <h6 class="collapse-header">관리</h6>
	                <a class="collapse-item" href="${pageContext.request.contextPath}/employee/empList">사원 관리</a>
	                <a class="collapse-item" href="${pageContext.request.contextPath}/employee/teacher/teacherList">강사 관리</a>
	                <a class="collapse-item" href="${pageContext.request.contextPath}/employee/student/studentList">학생 관리</a>
	            </div>
	        </div>
	    </li>
	
	 
	    <!-- Divider -->
	    <hr class="sidebar-divider d-none d-md-block">
	
	    <!-- Sidebar Toggler (Sidebar) -->
	    <div class="text-center d-none d-md-inline">
	        <button class="rounded-circle border-0" id="sidebarToggle"></button>
	    </div>
	
	</ul>
	
</body>
</html>
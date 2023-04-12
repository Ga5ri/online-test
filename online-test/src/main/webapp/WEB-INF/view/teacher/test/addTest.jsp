<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Online-test|Add Test</title>
	
	    <!-- Custom fonts for this template-->
	    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	    <link
	        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">
	
	    <!-- Custom styles for this template-->
	    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
	</head>
	
	<body class="bg-gradient-primary">

	    <div class="container">
	
	        <div class="card o-hidden border-0 shadow-lg my-5">
	            <div class="card-body p-0">
	                <!-- Nested Row within Card Body -->
	                <div class="row">
	                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
	                    <div class="col-lg-7">
	                        <div class="p-5">
	                            <div class="text-center">
	                                <h1 class="h4 text-gray-900 mb-4">Add Test!</h1>
	                            </div>
	                            <form method="post" action="${pageContext.request.contextPath}/teacher/test/addTest" id="addForm" class="user">
	                                <div class="form-group">
	                                    <input type="text" class="form-control form-control-user" name="testTitle" id="title"
	                                    	placeholder="시험명을 입력해주세요.">
	                                </div>
	                                <div class="form-group">
	                                        <input type="date" class="form-control form-control-user" name="testDate" id="date">
	                                </div>
	                                <button type="button" id="addBtn" class="btn btn-primary btn-user btn-block">
	                                    시험 등록
	                                </button>
	                            </form>
	                            <hr>
	                            <div class="text-center">
	                                <a class="small" href="${pageContext.request.contextPath}/teacher/test/testListByTeacher">홈으로</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	
	    </div>
	
	    <!-- Bootstrap core JavaScript-->
	    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	    <!-- Core plugin JavaScript-->
	    <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
	
	    <!-- Custom scripts for all pages-->
	    <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>
	    
	    <script>
		    $('#addBtn').click(function() {
				// 폼 유효성 검사
				if($('#title').val() == ''){
					alert('시험명을 입력해주세요.');
					return;
				}
				if($('#date').val() == ''){
					alert('날짜를 선택해주세요.');
					return;
				}
				
				// 폼 액션 전송
				$('#addForm').submit();
			});
	    </script>
	    
	</body>
</html>
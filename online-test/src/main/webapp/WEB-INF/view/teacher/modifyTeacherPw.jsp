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
	
	    <title>Online-test|Modify Pw</title>
	
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
	
	        <!-- Outer Row -->
	        <div class="row justify-content-center">
	
	            <div class="col-xl-10 col-lg-12 col-md-9">
	
	                <div class="card o-hidden border-0 shadow-lg my-5">
	                    <div class="card-body p-0">
	                        <!-- Nested Row within Card Body -->
	                        <div class="row">
	                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
	                            <div class="col-lg-6">
	                                <div class="p-5">
	                                    <div class="text-center">
	                                        <h1 class="h4 text-gray-900 mb-2">Modify PassWord</h1>
	                                        <p class="mb-4">비밀번호 수정</p>
	                                    </div>
	                                    <form method="post" action="${pageContext.request.contextPath}/teacher/modifyTeacherPw" id="mdForm" class="user">
	                                        <div class="form-group">
	                                            <input type="password" name="oldPw" id="oldPw" class="form-control form-control-user"
	                                                id="exampleInputEmail" aria-describedby="emailHelp"
	                                                placeholder="현재 비밀번호를 입력해주세요.">
	                                                
	                                        </div>
	                                        <div class="form-group">
	                                            <input type="password" name="newPw" id="newPw" class="form-control form-control-user"
	                                                id="exampleInputEmail" aria-describedby="emailHelp"
	                                                placeholder="변경하실 비밀번호를 입력해주세요.">
	                                                
	                                        </div>
	                                        <button type="button" id="mdBtn" class="btn btn-primary btn-user btn-block">
	                                            Modify Password
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
		    $('#mdBtn').click(function() {
				// 폼 유효성 검사
				if($('#oldPw').val() == ''){
					alert('현재 비밀번호를 입력해주세요.');
					return;
				}
				if($('#newPw').val() == ''){
					alert('새로운 비밀번호를 입력해주세요.');
					return;
				}
				
				// 폼 액션 전송
				alert('비밀번호가 변경되었습니다.');
				$('#mdForm').submit();
				
			});
	    </script>
	    
	</body>
</html>
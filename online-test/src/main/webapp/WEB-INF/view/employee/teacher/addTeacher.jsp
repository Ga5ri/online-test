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
	
	    <title>Online-test|Add Emp</title>
	
	    <!-- Custom fonts for this template-->
	    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	    <link
	        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">
	
	    <!-- Custom styles for this template-->
	    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
		<style>
			#btn {
				padding-top:8px;
			}
		</style>
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
	                                <h1 class="h4 text-gray-900 mb-4">Add Teacher!</h1>
	                            </div>
	                            <form method="post" action="${pageContext.request.contextPath}/employee/teacher/addTeacher" id="addForm" class="user">
	                            	<div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                        <input type="text" class="form-control form-control-user" id="checkId"
	                                            placeholder="사용할 ID를 입력해주세요.">
	                                    </div>
	                                    <div class="col-sm-6" id="btn">
	 									<button type="button" id="ckBtn" class="btn btn-sm btn-secondary btn-icon-split">
											<span class="icon text-white-50">
	                                    		<i class="fas fa-arrow-right"></i>
	                                		</span>
		                    				<span class="text">중복검사</span>
		                    			</button>
	                                    </div>
	                                </div>
	                                <div class="form-group">
	                                    <input type="text" class="form-control form-control-user" name="teacherId" id="id" readonly="readonly">
	                                </div>
	                                <div class="form-group">
	                                        <input type="password" class="form-control form-control-user" name="teacherPw" id="pw"
	                                            placeholder="Password">
	                                </div>
	                                <div class="form-group">
	                                        <input type="text" class="form-control form-control-user"
	                                            name="teacherName" id="name" placeholder="Name">
	                                </div>
	                                <button type="button" id="addBtn" class="btn btn-primary btn-user btn-block">
	                                    강사 등록
	                                </button>
	                            </form>
	                            <hr>
	                            <div class="text-center">
	                                <a class="small" href="${pageContext.request.contextPath}/login">Already have an account? Login!</a>
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
	    <!-- restAPI JavaScript ajax -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	 	
		<script>
			$('#ckBtn').click(function(){
				$.ajax({
					url:'idck'
					, type:'get'
					, data : {checkId:$('#checkId').val()}
					, success:function(model){ // model : 'yes' / 'no'
						if(model=='yes') {
							// 사용가능한 아이디
							$('#id').val($('#checkId').val());
						} else {
							// 사용중인 아이디
							alert($('#checkId').val()+'는 사용중인 아이디입니다');
						}
					}
				});
			});
			
			$('#addBtn').click(function() {
				// 폼 유효성 검사
				if($('#id').val() == ''){
					alert('ID를 확인해주세요.');
					return;
				}
				if($('#pw').val() == ''){
					alert('비밀번호를 확인해주세요.');
					return;
				}
				if($('#name').val() == ''){
					alert('이름을 확인해주세요.');
					return;
				}
				
				// 폼 액션 전송
				$('#addForm').submit();
			});
		</script>
	</body>
</html>
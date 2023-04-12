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
	
	    <title>Online-test|TestOneByStudent</title>
	
	    <!-- Custom fonts for this template -->
	    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this page -->
	    <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
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
	
	<body id="page-top">
		
	    <!-- Page Wrapper -->
	    <div id="wrapper">
	    
	    	<!-- jstl 페이지 include -->
			<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
			
	        <!-- Content Wrapper -->
	        <div id="content-wrapper" class="d-flex flex-column">
	
	            <!-- Main Content -->
	            <div id="content">
	
	                <!-- Topbar -->
	                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
	
	                    <!-- Sidebar Toggle (Topbar) -->
	                    <form class="form-inline">
	                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
	                            <i class="fa fa-bars"></i>
	                        </button>
	                    </form>
	                    
	                    <!-- Topbar Navbar -->
	                    <ul class="navbar-nav ml-auto">
	
	                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
	                        <li class="nav-item dropdown no-arrow d-sm-none">
	                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
	                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                <i class="fas fa-search fa-fw"></i>
	                            </a>
	                            <!-- Dropdown - Messages -->
	                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
	                                aria-labelledby="searchDropdown">
	                                <form class="form-inline mr-auto w-100 navbar-search">
	                                    <div class="input-group">
	                                        <input type="text" class="form-control bg-light border-0 small"
	                                            placeholder="Search for..." aria-label="Search"
	                                            aria-describedby="basic-addon2">
	                                        <div class="input-group-append">
	                                            <button class="btn btn-primary" type="button">
	                                                <i class="fas fa-search fa-sm"></i>
	                                            </button>
	                                        </div>
	                                    </div>
	                                </form>
	                            </div>
	                        </li>
	                        <!-- Nav Item - User Information -->
	                        <li class="nav-item dropdown no-arrow">
	                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
	                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${studentName}</span>
	                                <img class="img-profile rounded-circle"
	                                    src="${pageContext.request.contextPath}/resources/img/undraw_profile.svg">
	                            </a>
	                            <!-- Dropdown - User Information -->
	                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
	                                aria-labelledby="userDropdown">
	                                <a class="dropdown-item" href="${pageContext.request.contextPath}/student/modifyStudentPw">
	                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
	                                    비밀번호 수정
	                                </a>
	                                <div class="dropdown-divider"></div>
	                                <a class="dropdown-item" href="${pageContext.request.contextPath}/student/logout" data-toggle="modal" data-target="#logoutModal">
	                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
	                                    로그아웃
	                                </a>
	                            </div>
	                        </li>
	
	                    </ul>
	
	                </nav>
	                <!-- End of Topbar -->
	
	                <!-- Begin Page Content -->
	                <div class="container-fluid">
	
	                    <!-- Page Heading -->
	                    <h1 class="h3 mb-2 text-gray-800">Take Test</h1>
	                    <p class="mb-4">
	                    	시험에 응시중입니다.
	                    </p>
	
	                    <!-- DataTales Example -->
	                    <div class="card shadow mb-4">
	                        <div class="card-header py-3">
	                            <h6 class="m-0 font-weight-bold text-primary">
	                            	List 
		                            <button type="button" style="float: right;" class="btn btn-primary btn-icon-split btn-sm" id="addPaperBtn">제출하기
			                            <span class="icon text-white-50">
		                                    <i class="fas fa-flag"></i>
		                                </span>
		                                <span class="text">제출하기</span>
	                                </button>
	                            </h6>
	                        </div>
	                        <div class="card-body">
	                            <div class="table-responsive">
	                            	<h3>${testNo}회차 시험명:${testTitle}</h3>
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
											<br>
										</c:forEach>
									</form>
	                            </div>
	                        </div>
	                    </div>
	
	                </div>
	                <!-- /.container-fluid -->
	
	            </div>
	            <!-- End of Main Content -->
	
	            <!-- Footer -->
	            <footer class="sticky-footer bg-white">
	                <div class="container my-auto">
	                    <div class="copyright text-center my-auto">
	                        <span>Copyright &copy; Your Website 2020</span>
	                    </div>
	                </div>
	            </footer>
	            <!-- End of Footer -->
	
	        </div>
	        <!-- End of Content Wrapper -->
	
	    </div>
	    <!-- End of Page Wrapper -->
	
	    <!-- Scroll to Top Button-->
	    <a class="scroll-to-top rounded" href="#page-top">
	        <i class="fas fa-angle-up"></i>
	    </a>
	
	    <!-- Logout Modal-->
	    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	        aria-hidden="true">
	        <div class="modal-dialog" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h5 class="modal-title" id="exampleModalLabel">정말로 로그아웃 하시겠습니까?</h5>
	                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">×</span>
	                    </button>
	                </div>
	                <div class="modal-body">로그아웃시 현재 작성중인 사항들은 저장되지 않습니다.</div>
	                <div class="modal-footer">
	                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
	                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/student/logout">Logout</a>
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
	
	    <!-- Page level plugins -->
	    <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	    <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	
	    <!-- Page level custom scripts -->
	    <script src="${pageContext.request.contextPath}/resources/js/demo/datatables-demo.js"></script>

	</body>
</html>
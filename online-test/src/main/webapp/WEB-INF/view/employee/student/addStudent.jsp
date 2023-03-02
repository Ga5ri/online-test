<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
 	<h1>학생 추가</h1>
	<form method="post" action="${pageContext.request.contextPath}/employee/student/addStudent" id="addForm">
		<table border="1">
			<tr>
				<td>ID중복검사</td>
				<td>
					<input type="text" id="checkId" placeholder="사용할ID를 입력해주세요.">
					<button type="button" id="ckBtn">중복검사</button>
				</td>
			</tr>
			<tr>
				<td>studentId</td>
				<td><input type="text" name="studentId" id="id" readonly="readonly"></td>
			</tr>
			<tr>
				<td>studentPw</td>
				<td><input type="password" name="studentPw" id="pw"></td>
			</tr>
			<tr>
				<td>studentName</td>
				<td><input type="text" name="studentName" id="name"></td>
			</tr>	
		</table>
		<button type="button" id="addBtn">등록</button>
	</form>
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
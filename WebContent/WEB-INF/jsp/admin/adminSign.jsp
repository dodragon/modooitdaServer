<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../resources/webImages/favicon.ico">
<!-- Bootstrap core CSS-->
<link href="../../resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="../../resources/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="../../resources/assets/css/sb-admin.css" rel="stylesheet">
<title>모두잇다 관리자</title>
<script type="text/javascript">
function submitForm(){
	if(confirm(document.getElementById('department').value + ' ' + document.getElementById('userName').value + ' ' + 
			document.getElementById('jobClass').value + '가 맞으십니까?')){
		document.getElementById('form').submit();
	}else{
		alert('다시 입력해 주시기 바랍니다.');
	}
}
</script>
<style type="text/css">
select{
	width: 100%;
}
</style>
</head>
<body class="bg-dark">
<div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">모두잇다 관리자 로그인</div>
        <div class="card-body">
          <form id="form" action="./adminSignConfirm.api" method="post">
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="userName" name="userName" class="form-control" readonly="readonly" value="${vo.userName }">
                <label for="inputEmail">이름</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <b>닉네임</b>
                <input type="text" id="jobClass" name="jobClass" class="form-control" placeholder="닉네임을 입력해주세요."/>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <b>부서</b>
                <select id="department" name="department" class="form-control">
                	<option>경영팀</option>
                	<option>영업팀</option>
                	<option>마케팅팀</option>
                	<option>개발팀</option>
                </select>
              </div>
            </div>
            <input type="hidden" name="email" value="${vo.email }"/>
            <input type="hidden" name="pw" value="${vo.user_password }"/>
          </form>
          <button class="btn btn-primary btn-block" onclick="submitForm()">등록하기</button>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="../../resources/assets/vendor/jquery/jquery.min.js"></script>
    <script src="../../resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    <!-- Core plugin JavaScript-->
    <script src="../../resources/assets/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../resources/webImages/favicon.ico">
<!-- Bootstrap core CSS-->
<link href="../../resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="../../resources/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="../../resources/assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<!-- Custom styles for this template-->
<link href="../../resources/assets/css/sb-admin.css" rel="stylesheet">
<title>모두잇다 관리자</title>
<!-- Bootstrap core JavaScript-->
<script src="../../resources/assets/vendor/jquery/jquery.min.js"></script>
<script src="../../resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="../../resources/assets/vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript-->
<script src="../../resources/assets/vendor/chart.js/Chart.min.js"></script>
<script src="../../resources/assets/vendor/datatables/jquery.dataTables.js"></script>
<script src="../../resources/assets/vendor/datatables/dataTables.bootstrap4.js"></script>
<!-- Custom scripts for all pages-->
<script src="../../resources/assets/js/sb-admin.min.js"></script>
<script type="text/javascript">
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "../admin.api";
	}
}

function back(){
	window.history.back();
}

$(function() {
	$('#content').keyup(function(e) {
		var content = $(this).val();
		$('#counter').html(content.length + '/800');
	});
	$('#content').keyup();
});

$(document).ready(function(){
	$('#submit-btn').click(function(){
		var obj = $("[name=reader]");
	    var chkArray = new Array(); // 배열 선언

	    $('input:checkbox[name=reader]:checked').each(function() { // 체크된 체크박스의 value 값을 가지고 온다.
	        chkArray.push(this.value);
	    });
	    $('#checkBoxes').val(chkArray);
	    
	    var title = $("#title-input").val();
	    var content = $("#content").val();
	    
	    if(chkArray.length == 0){
	    	alert('읽기 권한은 선택해 주세요.');
	    }else if(title == null || title == ''){
	    	alert('제목을 입력해 주세요.');
	    }else if(content == null || content == ''){
	    	alert('내용을 입력해 주세요.');
	    }else{
	    	$('#form').submit();
	    }
	});
});

function serviceReady(){
	alert('준비 중 입니다.');
}
</script>
<style type="text/css">
body{
	text-align: center;
}
#close-btn, #submit-btn{
	display: inline;
	margin: 0 auto;
	border: 1px solid rgba(0,0,0,.125);
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px);
}
#close-btn{
	margin-right: 20px;
}
#submit-btn{
	background-color: #fc8443;
	color: white;
}
#title-input{
	width: 640px;
	margin-right: 10px;
}
h2{
	font-weight: bolder;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">공지사항 작성</a>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <!-- <div class="input-group">
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div> -->
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
      	<li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>
    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="./mainpage.api">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>홈</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>페이지</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Management</h6>
            <a class="dropdown-item" href="./noticepage.api?result=3">공지사항</a>
            <a class="dropdown-item" href="./eventPush.api?result=3">이벤트 푸시</a>
            <a class="dropdown-item" href="./meetingLog.api">회의록</a>
            <a class="dropdown-item" href="./dailyReport.api">업무일지</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">INFO</h6>
            <a class="dropdown-item" href="./userList.api">회원정보</a>
            <a class="dropdown-item" href="./ownerList.api">사장님정보</a>
            <a class="dropdown-item" href="./cpList.api">업체정보</a>
            <a class="dropdown-item" href="./payHistory.api">결제내역</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Marketing</h6>
            <a class="dropdown-item" href="./listUpdate.api">리스트 타이틀</a>
            <a class="dropdown-item" href="./mainListCp.api">리스트 업체</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Development</h6>
            <a class="dropdown-item" href="./appInfo.api">앱 정보 수정</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Sales</h6>
            <a class="dropdown-item" href="#" onclick="serviceReady()">영업일지</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">ETC</h6>
            <a class="dropdown-item" href="./addrConversion.api">경위도 조회</a>
            <a class="dropdown-item" href="./bankAccount.api">계좌조회</a>
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="charts.html">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Charts</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="tables.html">
            <i class="fas fa-fw fa-table"></i>
            <span>Tables</span></a>
        </li>
      </ul>
	  
      <div id="content-wrapper">
      	<h2 style="margin-bottom: 17px;">공지사항 작성</h2>
        <div class="container-fluid">
          <!-- DataTables Example -->
          <div class="card mb-3">
          	<form id="form" action="./notiInput.api" method="post">
	            <div class="card-header">
	            	<input name="title" id="title-input" type="text" placeholder="제목" maxlength="20"/>
	            	<input name="reader" type="checkbox" value="C"/>사장님
	            	<input name="reader" type="checkbox" value="U"/>일반회원
	            	<input name="reader" type="checkbox" value="A"/>관리자
	            	<input name="readers" type="hidden" id="checkBoxes"/>
		            <div class="card-body">
		                <textarea name="content" id="content" name="content" cols="120" rows="25" style="resize: none;" maxlength="800" placeholder="내용을 입력해 주세요.(800)"></textarea>
		            	<br>
		            	<span id="counter">###</span>
		            </div>
	          	</div>
			</form>
        </div>
        
        <div>
	        <button id="close-btn" onclick="back()">닫기</button>
	        <button id="submit-btn">확인</button>
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © (주)위대한</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->
      
      <a class="scroll-to-top rounded" href="#page-top">
	      <i class="fas fa-angle-up"></i>
	    </a>

    </div>
    <!-- /#wrapper -->
    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">로그아웃</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">업무를 종료하고 로그아웃 하시겠습니까?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="../admin.api">Logout</a>
          </div>
        </div>
      </div>
    </div>
    
    
<!-- Demo scripts for this page-->
<script src="../../resources/assets/js/demo/datatables-demo.js"></script>
<script src="../../resources/assets/js/demo/chart-area-demo.js"></script>
</body>
</html>
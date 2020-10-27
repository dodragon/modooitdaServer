<%@page import="com.baobab.m.vo.UserTicketHistoryVO"%>
<%@page import="java.util.List"%>
<%@page import="com.baobab.m.vo.AdminPayDetailVO"%>
<%@page import="com.baobab.m.vo.OwnerInfoVO"%>
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
	
	var attendHourStr = '';
	var closeHourStr = '';
	var minStr = '';
	
	for(var i=0;i<=24;i++){
		if(i == 9){
			attendHourStr += '<option selected="selected">' + makeTimeStr(i) + '</option>';
		}else{
			attendHourStr += '<option>' + makeTimeStr(i) + '</option>';
		}
	}
	
	for(var i=0;i<=24;i++){
		if(i == 18){
			closeHourStr += '<option selected="selected">' + makeTimeStr(i) + '</option>';
		}else{
			closeHourStr += '<option>' + makeTimeStr(i) + '</option>';
		}
	}
	
	for(var i=0;i<60;i++){
		if((i % 5) == 0){
			if(i == 30){
				minStr += '<option selected="selected">' + makeTimeStr(i) + '</option>';
			}else{
				minStr += '<option>' + makeTimeStr(i) + '</option>';
			}
		}
	}
	
	document.getElementById('attend-hour').innerHTML = attendHourStr;
	document.getElementById('attend-min').innerHTML = minStr;
	document.getElementById('close-hour').innerHTML = closeHourStr;
	document.getElementById('close-min').innerHTML = minStr;
}

function makeTimeStr(time){
	if(time > 9){
		return time;
	}else{
		return '0' + time;
	}
}

function insert(){
	var id = '<%=session.getAttribute("id") %>';
	var name = '<%=session.getAttribute("name") %>';
	var department = '<%=session.getAttribute("department") %>';
	var jobClass = '<%=session.getAttribute("jobClass") %>';
	var attendTime = document.getElementById('attend-hour').value + ':' + document.getElementById('attend-min').value;
	var closeTime = document.getElementById('close-hour').value + ':' + document.getElementById('close-min').value;
	var todayJob = document.getElementById('today').value;
	var tomorrowJob = document.getElementById('tomorrow').value;
	var successJob = document.getElementById('success').value;
	var unSuccessJob = document.getElementById('unSuccess').value;
	
	var nameArr = new Array('id', 'name', 'department', 'jobClass', 'attendTime', 'closeTime', 'todayJob', 'tomorrowJob', 'successJob', 'unSuccessJob');
	var valueArr = new Array(id, name, department, jobClass, attendTime, closeTime, todayJob, tomorrowJob, successJob, unSuccessJob);
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "./reportInsertSuccess.api");
	
	if(!todayJob){
		alert('금일 업무는 꼭 작성 해 주세요.');
	}else if(!tomorrowJob){
		alert('명일 업무는 꼭 작성 해 주세요.');
	}else{
		for(var i=0;i<nameArr.length;i++){
			var hiddenField = document.createElement("input");
			hiddenField.setAttribute("type", "hidden");
			hiddenField.setAttribute("name", nameArr[i]);
			hiddenField.setAttribute("value", valueArr[i]);
			form.appendChild(hiddenField);
		}

		document.body.appendChild(form);
		form.submit();
	}
}

function serviceReady(){
	alert('준비 중 입니다.');
}
</script>
<style type="text/css">
.card-body{
	position: relative;
	display: block;
}

a{
	text-decoration: none;
	color: black;
}

h3{
	margin-top: 12px;
}

textarea{
	width: 50%;
	height: 200px;
}

#form-div{
	margin-top: 30px;
}

select{
	width: 70px;
}

button{
	margin-bottom: 20px;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">업무일지</a>

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
        <div class="container-fluid">
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <div id="default-info">
              	<h3>업무일지</h3>
              	<div id="form-div">
	              	출근시간 : 
	              	<select id="attend-hour">
	              	</select>시
	              	<select id="attend-min">
	              	</select>분&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	              	퇴근시간 : 
	              	<select id="close-hour">
	              	</select>시
	              	<select id="close-min">
	              	</select>분<br><br>
	              	금일 업무<br>
	              	<textarea id="today" style="resize: none;">${bj }</textarea><br><br>
	              	명일 업무<br>
	              	<textarea id="tomorrow" style="resize: none;"></textarea><br><br>
	              	완성 업무<br>
	              	<textarea id="success" style="resize: none;"></textarea><br><br>
	              	미완성 업무<br>
	              	<textarea id="unSuccess" style="resize: none;"></textarea><br><br>
              	</div>
              </div>
            </div>
            </div>
            <button onclick="insert()">저장하기</button>
          </div>
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
</body>
</html>
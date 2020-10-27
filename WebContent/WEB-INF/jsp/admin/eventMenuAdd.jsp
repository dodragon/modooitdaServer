<%@page import="com.baobab.m.vo.EventCpMenuVO"%>
<%@page import="com.baobab.m.vo.EventCpOptionVO"%>
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
}

function save(){
	var menuData = {
		menuName: document.getElementById('menuName').value,
		price: document.getElementById('price').value,
		disPrice: document.getElementById('disPrice').value,
		percentAge: document.getElementById('percentAge').value,
		optionSerial: '${optionSerial}',
		menuInfo:document.getElementById('menuInfo').value
	};
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "./menuaddSuccess.api");
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "data");
	hiddenField.setAttribute("value", JSON.stringify(menuData));
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type", "hidden");
	hiddenField2.setAttribute("name", "cpSeq");
	hiddenField2.setAttribute("value", ${cpSeq});
	form.appendChild(hiddenField2);
	
	document.body.appendChild(form);
	form.submit();
}

var oldVal = '';

$(document).ready(function(){
	$('#disPrice').on('change keyup paste', function(){
		var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    var price = $('#price').val();

	    var result = Math.floor(100 - (currentVal / price * 100));
	    if(result < 0){
	    	result = 0;
	    }
	    $('#percentAge').val(result);
	});
	
	$('#price').on('change keyup paste', function(){
		var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    var disPrice = $('#disPrice').val();

	    var result = Math.floor(100 - (disPrice / currentVal * 100));
	    if(result < 0){
	    	result = 0;
	    }
	    $('#percentAge').val(result);
	});
	
	$('#percentAge').on('change keyup paste', function(){
		var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    var price = $('#price').val();

	    var result = Math.floor(price - (price * (currentVal / 100)));
	    if(result < 0){
	    	result = 0;
	    }
	    $('#disPrice').val(result);
	});
});
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

h4{
	margin-top: 30px;
}

#menuName, textarea{
	width: 44%;
}

select{
	width: 22%;
}

textarea{
	height: 150px;
}

.priceDiv{
	display: inline-block;
	margin-right: 50px;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">상품 추가</a>

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
            <a class="dropdown-item" href="./eventPush.api">이벤트 푸시</a>
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
            <h6 class="dropdown-header">Develop</h6>
            <a class="dropdown-item" href="./appInfo.api">앱 정보 수정</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Sales</h6>
            <a class="dropdown-item" href="#">영업일지</a>
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
              	<b>소분류명</b><br>
              	<input type="text" id="menuName"/><br><br>
              	<div class="priceDiv">
	              	<b>판매가</b><br>
	              	<input type="number" id="price"/>&nbsp;원<br><br>
              	</div>
              	<div class="priceDiv">
	              	<b>할인가</b><br>
	              	<input type="number" id="disPrice"/>&nbsp;원<br><br>
	            </div>
              	<div class="priceDiv">
	              	<b>할인율</b><br>
	              	<input type="number" id="percentAge"/>&nbsp;%<br><br>
              	</div><br>
              	<b>상품 상세정보</b><br>
              	<textarea id="menuInfo" style="resize: none;"></textarea><br>
              </div>
            </div>
            </div>
            <button onclick="save()">저장</button>
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
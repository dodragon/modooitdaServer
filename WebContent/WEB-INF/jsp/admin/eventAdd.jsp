<%@page import="com.baobab.m.vo.NoticeVO"%>
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
var oldVal = '';

window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "../admin.api";
	}
	
	setPriceData();
}

var optionIndex = 0;

function makeOption(){
	optionIndex++;
	var newDiv = document.createElement('div');
	newDiv.id = 'option' + optionIndex;
	newDiv.className = 'card mb-3';
	newDiv.innerHTML = '<div class="card-header">' + 
	'<input type="text" class="optionName" placeholder="중분류명 입력"/><br>' + '<button onclick="deleteOption(this)">중분류삭제</button>' + '</div>' + '<div class="card-body">' + 
	'<input type="text" class="menuName" placeholder="소분류명 입력"/><br>' + '<input type="number" class="menuPrice" placeholder="판매가(원가) 입력"/>' + 
	'<input type="number" class="menuDisprice" placeholder="할인가 입력"/>' + '<input type="number" class="menuPercent" placeholder="할인율 입력"/><br>' + 
	'<textarea class="menuInfo" style="resize: none;" placeholder="상세정보 입력"></textarea><br>' + '<button onclick="makeMenu(this)">소분류추가</button>' + 
	'</div>';
	document.getElementById('event-container').appendChild(newDiv);
	setPriceData();
}

function deleteOption(tag){
	var deleteTag = tag.parentNode.parentNode;
	deleteTag.parentNode.removeChild(deleteTag);
}

function makeMenu(tag){
	var newDiv = document.createElement('div');
	newDiv.className = 'card-body';
	
	newDiv.innerHTML += '<input type="text" class="menuName" placeholder="소분류명 입력"/><br>' + 
	'<input type="number" class="menuPrice" placeholder="판매가(원가) 입력"/>' + '<input type="number" class="menuDisprice" placeholder="할인가 입력"/>' + 
	'<input type="number" class="menuPercent" placeholder="할인율 입력"/><br>' + '<textarea class="menuInfo" style="resize: none;" placeholder="상세정보 입력">' + 
	'</textarea><br>' + '<button onclick="makeMenu(this)">소분류추가</button>' + '<button onclick="deleteMenu(this)">소분류삭제</button>';
	
	tag.parentNode.parentNode.appendChild(document.createElement('hr'));
	tag.parentNode.parentNode.appendChild(newDiv);
	setPriceData();
}

function deleteMenu(tag){
	var deleteTag = tag.parentNode;
	var parentTag = deleteTag.parentNode;
	var hr = deleteTag.previousSibling;
	parentTag.removeChild(deleteTag);
	parentTag.removeChild(hr);
}

function setPriceData(){
	$('.menuDisprice').on('change keyup paste', function(){
		var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    var price = $(this).prev().val();

	    var result = Math.floor(100 - (currentVal / price * 100));
	    if(result < 0){
	    	result = 0;
	    }
	    $(this).next().val(result);
	});
	
	$('.menuPrice').on('change keyup paste', function(){
		var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    var disPrice = $(this).next().val();

	    var result = Math.floor(100 - (disPrice / currentVal * 100));
	    if(result < 0){
	    	result = 0;
	    }
	    $(this).next().next().val(result);
	});
	
	$('.menuPercent').on('change keyup paste', function(){
		var currentVal = $(this).val();
	    if(currentVal == oldVal) {
	        return;
	    }
	 
	    var price = $(this).prev().prev().val();

	    var result = Math.floor(price - (price * (currentVal / 100)));
	    if(result < 0){
	    	result = 0;
	    }
	    $(this).prev().val(result);
	});
}

function save(){
	var eventCpVO = {
		eventName: document.getElementById('eventName').value,
		cpSeq: ${cpSeq},
		optionList: getOption()
	}
	
	var data = JSON.stringify(eventCpVO);
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "./eventaddSuccess.api");
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "data");
	hiddenField.setAttribute("value", data);
	form.appendChild(hiddenField);
	
	document.body.appendChild(form);
	form.submit();
}

function getMenus(option){
	var menus = new Array();
	
	if(document.getElementById(option)){
		var menusTagList = document.getElementById(option).getElementsByClassName('card-body');
		
		for(var i=0;i<menusTagList.length;i++){
			var eventCpMenuVO = {
				menuName: menusTagList[i].getElementsByClassName('menuName')[0].value,
				price: menusTagList[i].getElementsByClassName('menuPrice')[0].value,
				disPrice: menusTagList[i].getElementsByClassName('menuDisprice')[0].value,
				percentAge: menusTagList[i].getElementsByClassName('menuPercent')[0].value,
				menuInfo: menusTagList[i].getElementsByClassName('menuInfo')[0].value
			};
				
			menus.push(eventCpMenuVO);
		}
		
		return menus;
	}else{
		return null;	
	}
}

function getOption(){
	var options = new Array();
	
	for(var i=0;i<=optionIndex;i++){
		if(document.getElementById('option' + i)){
			var eventCpOptionVO = {
				optionName: document.getElementById('option' + i).getElementsByClassName('optionName')[0].value,
				menuList: getMenus('option' + i)
			};
			
			options.push(eventCpOptionVO);
		}
	}
	
	return options;
}

function checkData(){
	var eventName = document.getElementById('eventName');
	var options = document.getElementsByClassName('optionName');
	var prices = document.getElementsByClassName('menuPrice');
	var disPrices = document.getElementsByClassName('menuDisprice');
	var percents = document.getElementsByClassName('menuPercent');
	
	if(!eventName.value){
		alert('대분류명을 입력해 주세요.');
	}else if(checkArray(options) == false){
		alert('입력하지 않은 중분류가 있습니다.');
	}else if(checkArray(prices) == false){
		alert('잘못 입력한 판매가(원가)가 있습니다.');
	}else if(checkArray(disPrices) == false){
		alert('잘못 입력한 할인가가 있습니다.');
	}else if(checkArray(percents) == false){
		alert('잘못 입력한 할인율이 있습니다.');
	}else{
		save();
	}
}

function checkArray(arr){
	var none = true;
	for(var i=0;i<arr.length;i++){
		if(!arr[i].value){
			none = false;
		}
	}
	
	return none;
}

function serviceReady(){
	alert('준비 중 입니다.');
}
</script>
<style type="text/css">
a{
	text-decoration: none;
	color: black;
}

#eventName{
	width: 350px;
	height: 40px;
	margin: 0 0 15px 15px;
	font-size: 1.3em;
}

.optionName{
	width: 350px;
	height: 35px;
	font-size: 1.2em;
}

.menuName, .menuInfo{
	width: 50%;
}

.menuInfo{
	height: 120px;
	margin-top: 15px;
}

.menuPrice, .menuDisprice, .menuPercent{
	width: 15.4%;
	margin: 15px 15px 0 0;
}

button{
	margin-top: 15px;
	margin-right: 15px;
}

#option-add, #event-save{
	width: 200px;
	height: 50px;
	margin-left: 15px;
	margin-bottom: 10px;
	border: 1px solid rgba(0,0,0,.125);
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px);
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
		<input type="text" id="eventName" placeholder="대분류명 입력"/>
        <div class="container-fluid" id="event-container">
          <!-- DataTables Example -->
          <div class="card mb-3" id="option0">
            <div class="card-header">
            	<input type="text" class="optionName" placeholder="중분류명 입력"/>
            </div>
            <div class="card-body">
            	<input type="text" class="menuName" placeholder="소분류명 입력"/><br>
            	<input type="number" class="menuPrice" placeholder="판매가(원가) 입력"/>
            	<input type="number" class="menuDisprice" placeholder="할인가 입력"/>
            	<input type="number" class="menuPercent" placeholder="할인율 입력"/><br>
          		<textarea class="menuInfo" style="resize: none;" placeholder="상세정보 입력"></textarea><br>
          		<button onclick="makeMenu(this)">소분류추가</button>
            </div>
          </div>
        </div>
        <button id="option-add" onclick="makeOption()">중분류 추가하기</button>
        <button id="event-save" onclick="checkData()">대분류 전체 저장</button>
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
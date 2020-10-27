<%@page import="com.baobab.m.vo.CPmainImgVO"%>
<%@page import="java.util.List"%>
<%@page import="com.baobab.m.service.rsa.RandomNumber"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	response.setHeader("pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.addHeader("Cache-Control","No-store");
	response.setDateHeader("Expires",1L);
%>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>
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

function imgAddClick(){
	$('#img-input').trigger('click');
}

function CheckuploadFileExt(objFile){
	var strFilePath = objFile.value;
	var RegExtFilter = /\.(png|jpg|jpeg)$/i;

	if (strFilePath.match(RegExtFilter) == null){
		objFile.outerHTML = objFile.outerHTML;
		alert("허용하지 않는 확장자 입니다.(1)");
	}else if (RegExtFilter.test(strFilePath) == false){
		objFile.outerHTML = objFile.outerHTML;
		alert("허용하지 않는 확장자 입니다.(2)");
	}else{
		document.getElementById('img-form').submit();
	}
}

function makeDialog(){
	alert('해당 이미지를 삭제하시겠습니까?');
}

var selectedSrcUrl = '';

$(document).ready(function(){
	$('.imgs').click(function(){
		selectedSrcUrl = $(this).children('.img-tag').attr('src');
		$('#selected-img').attr('src', selectedSrcUrl);
		$('#image-modal').show();
	});
});

function closeModal() {
	$('#image-modal').hide();
};

function ubdateImgTrigger(){
	$('#img-update-input').trigger('click');
}

function updateImg(){
	var objFile = document.getElementById('img-update-input');
	var strFilePath = objFile.value;
	var RegExtFilter = /\.(png|jpg|jpeg)$/i;
	
	console.log(selectedSrcUrl);

	if (strFilePath.match(RegExtFilter) == null){
		objFile.outerHTML = objFile.outerHTML;
		alert("허용하지 않는 확장자 입니다.(1)");
	}else if (RegExtFilter.test(strFilePath) == false){
		objFile.outerHTML = objFile.outerHTML;
		alert("허용하지 않는 확장자 입니다.(2)");
	}else{
		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "url");
		hiddenField.setAttribute("value", selectedSrcUrl.split('?')[0]);
		document.getElementById('img-update-form').appendChild(hiddenField);
		document.getElementById('img-update-form').submit();
	}
}

function deleteImg(){
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "./deleteMainImg.api");

	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "cpSeq");
	hiddenField.setAttribute("value", "${cpSeq}");
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type", "hidden");
	hiddenField2.setAttribute("name", "url");
	hiddenField2.setAttribute("value", selectedSrcUrl.split('?')[0]);
	form.appendChild(hiddenField2);
	
	var hiddenField3 = document.createElement("input");
	hiddenField3.setAttribute("type", "hidden");
	hiddenField3.setAttribute("name", "cpName");
	hiddenField3.setAttribute("value", "${cpName}");
	form.appendChild(hiddenField3);

	document.body.appendChild(form);
	form.submit();
}

function serviceReady(){
	alert('준비 중 입니다.');
}
</script>
<style type="text/css">
#notiTitle{
	font-size: 1.5em;
	font-weight: bolder;
	margin-top: 8px;
}

#push-btn{
	margin: 0 auto;
	border: 1px solid rgba(0,0,0,.125);
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px);
	background-color: #fc8443;
	color: white;
}

#push-form{
	display: none;
}

#img-container{
	display: grid;
	grid-row-gap: 50px;
	grid-column-gap: 10px;
	grid-template-columns: auto auto auto auto;
 	padding: 10px;
}

.imgs{
	width: 320px;
	height: 250px;
	border: 1px solid rgba(0,0,0,.125);
  	border-radius: calc(.25rem - 1px) calc(.25rem - 1px);
}

#img-add{
	background-color: rgba(0,0,0,.03);
	width: 320px;
	height: 250px;
	cursor: pointer;
	border: 1px solid rgba(0,0,0,.125);
  	border-radius: calc(.25rem - 1px) calc(.25rem - 1px);
  	text-align: center;
}

#img-add h2{
	font-size: 7em;
	font-weight: bolder;
	margin-top: 45px;
}

.imgs img{
	width: 320px;
	height: 250px;
	cursor: pointer;
}

#img-form, #img-update-form{
	display: none;
}

#image-modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 10; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0,0,0); /* Fallback color */
	background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}
/* Modal Content/Box */
.image-fade-modal {
	background-color: #fefefe;
	margin: 0 15% 0 15%; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 70%; /* Could be more or less, depending on screen size */
}

#selected-img{
	width: 100%;
	height: 700px;
}

#update-btn, #delete-btn{
	margin-top: 15px;
	margin-left: 15px;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<div id="image-modal">
	<div class="image-fade-modal">
		<div class="page-header">
			<h1>Main Images</h1>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<div id="banner">
							<img id="selected-img" alt="이미지없음" />
						</div>
					</div>
					<button id="update-btn" onclick="ubdateImgTrigger()">수정</button>
					<button id="delete-btn" onclick="deleteImg()">삭제</button>
				</div>
			</div>
		</div>
		<hr>
		<div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="closeModal();">
			<span class="pop_bt modalCloseBtn" style="font-size: 13pt;">닫기
			</span>
		</div>
	</div>
</div>
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">메인 이미지 수정</a>

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
      
      <form id="img-form" action="./uploadImg.api" method="post" enctype="multipart/form-data">
      	<input type="hidden" name="cpSeq" value="${cpSeq }" />
      	<input type="hidden" name="cpName" value="${cpName }" />
      	<input id="img-input" multiple="multiple" type="file" name="imgs" accept="image/*" onchange="CheckuploadFileExt(this)"/>
      </form>
      
      <form id="img-update-form" action="./updateImg.api" method="post" enctype="multipart/form-data">
      	<input type="hidden" name="cpSeq" value="${cpSeq }" />
      	<input type="hidden" name="cpName" value="${cpName }" />
      	<input id="img-update-input" type="file" name="img" accept="image/*" onchange="updateImg()"/>
      </form>

      <div id="content-wrapper">
        <div class="container-fluid">
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <h3 id="notiTitle">${cpName }</h3>
            </div>
            <div class="card-body">
              <div	id="img-container">
              	<div id="img-add" onclick="imgAddClick()"><h2>+</h2></div>
              	<c:forEach items="${vo}" var="vo">
              		<div class="imgs">
              			<img class="img-tag" alt="이미지없음" src="${vo.img_url }"/>
              		</div>
              	</c:forEach>
              </div>
            </div>
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
    
    
<!-- Demo scripts for this page-->
<script src="../../resources/assets/js/demo/datatables-demo.js"></script>
<script src="../../resources/assets/js/demo/chart-area-demo.js"></script>
</body>
</html>
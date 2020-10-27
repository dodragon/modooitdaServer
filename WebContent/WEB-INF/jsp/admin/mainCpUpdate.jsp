<%@page import="com.baobab.m.vo.MainCpListVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.baobab.m.vo.CPInfoVO"%>
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
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
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
<!-- daum address api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "../admin.api";
	}
	
	imgSetting();
}

function imgSetting(){
	<c:forEach items="${imgList}" var="imgs">
		if('${imgs.img_url}' == '${vo.imgUrl}'){
			imgClick(document.getElementById('${vo.imgUrl}'));
		}
	</c:forEach>
}

function save(){
	var seqNum = '${vo.seqNum}';
	var title = radio_check('title');
	var menuSeq = radio_check('menu');
	var imgUrl = radio_check('img');
	
	if(!title){
		alert('타이틀을 선택 해 주세요.');
	}else if(!menuSeq){
		alert('상품을 선택 해 주세요.');
	}else if(!imgUrl){
		alert('이미지를 선택 해 주세요.');
	}else{
		var nameArr = new Array('seqNum', 'title', 'menuSeq', 'imgUrl');
		var valueArr = new Array(seqNum, title, menuSeq, imgUrl);
		
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "Post"); // Get 또는 Post 입력
		form.setAttribute("action", "./updateMainList.api");
		
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

function radio_check(name) {
    var check_count = document.getElementsByName(name).length;

    for (var i=0; i<check_count; i++) {
        if (document.getElementsByName(name)[i].checked == true) {
        	return document.getElementsByName(name)[i].value;
        	break;
        }
    }
}

function imgClick(tag){
	var imgs = document.getElementsByClassName('imgs');
	for(var i=0;i<imgs.length;i++){
		imgs[i].style.opacity = '1.0';
	}
	
	if(tag.style.opacity !== '0.2'){
		tag.style.opacity = '0.2';
	}else{
		tag.style.opacity = '1.0';
	}
}

function serviceReady(){
	alert('준비 중 입니다.');
}
</script>
<style type="text/css">
.imgs{
	width: 300px;
	height: 250px;
}

.img_radio{
	display: none;
}

.img_container{
	display: grid;
	grid-template-columns: auto auto auto auto;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">메인 리스트 수정</a>

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
	            <h3>어떤 타이틀에 설정하실 건가요?</h3>
	            <c:set var="listDiv" value="${vo.listDiv }" />
	            <c:forEach items="${titleList}" var="title">
	            	<c:set var="mainText" value="${title.mainText }" />
	            	<c:choose>
		            	<c:when test="${fn:contains(listDiv, mainText) }">
		            		<input type="radio" name="title" id="${title.titleDiv }_title" value="${title.titleDiv }" checked/>
		            		<label for="${title.titleDiv }_title">${title.mainText }</label>
		            		<br>
		            	</c:when>
		            	<c:otherwise>
					    	<input type="radio" name="title" id="${title.titleDiv }_title" value="${title.titleDiv }"/>
		            		<label for="${title.titleDiv }_title">${title.mainText }</label>
		            		<br>
					    </c:otherwise>
	            	</c:choose>
	            </c:forEach>
	            <br>
	            <hr>
	            <h3>어떤 상품을 대표로 하시겠어요?</h3>
	            <!-- TODO:// 상품 선택부터 시작하면 됨 -->
	            <c:set var="menuSeq" value="${vo.menuSeq }" />
	            <c:forEach items="${menuList}" var="menu">
	            	<c:set var="seq" value="${menu.seqNum}" />
	            	<c:choose>
	            		<c:when test="${menuSeq eq seq }">
	            			<input type="radio" name="menu" id="${menu.seqNum }" value="${menu.seqNum }" checked/>
			            	<label for="${menu.seqNum }">${menu.menuName }  (<fmt:formatNumber value="${menu.price }" pattern="###,###원"/> => <fmt:formatNumber value="${menu.disPrice }" pattern="###,###원"/>, ${menu.percentAge }%)</label>
			            	<br>
	            		</c:when>
	            		<c:otherwise>
	            			<input type="radio" name="menu" id="${menu.seqNum }" value="${menu.seqNum }"/>
			            	<label for="${menu.seqNum }">${menu.menuName }  (<fmt:formatNumber value="${menu.price }" pattern="###,###원"/> => <fmt:formatNumber value="${menu.disPrice }" pattern="###,###원"/>, ${menu.percentAge }%)</label>
			            	<br>
	            		</c:otherwise>
	            	</c:choose>
	            </c:forEach>
	            <br>
	            <hr>
	            <h3>어떤 이미지를 노출 시킬까요?</h3>
	            <div class="img_container">
		            <c:forEach items="${imgList}" var="img">
		            	<div class="img_item">
		            		<input type="radio" class="img_radio" name="img" id="${img.seq_num }_img" value="${img.img_url }" />
		            		<label for="${img.seq_num }_img"><img id="${img.img_url }" onclick="imgClick(this)" class="imgs" src="${img.img_url }" /></label>
		            	</div>
		            </c:forEach>
	            </div>
	            <br><hr><br>
	            <button onclick="save()">저장</button>
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
<script src="../../resources/assets/js/demo/chart-area-demo.js"></script>
</body>
</html>
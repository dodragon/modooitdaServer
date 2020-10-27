<%@page import="com.google.gson.Gson"%>
<%@page import="com.baobab.m.vo.AdminCpDetailVO"%>
<%@page import="com.baobab.m.vo.AdminUserDetailVO"%>
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
<script src="../..//resources/assets/vendor/datatables/jquery.dataTables.js"></script>
<script src="../..//resources/assets/vendor/datatables/dataTables.bootstrap4.js"></script>
<!-- Custom scripts for all pages-->
<script src="../../resources/assets/js/sb-admin.min.js"></script>
<!-- bxSlider -->
<script src="../../resources/bxslider/js/jquery.bxslider.js"></script>
<script src="../../resources/bxslider/css/jquery.bxslider.css"></script>
<script type="text/javascript">
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "../admin.api";
	}
	
	var result = <%=request.getAttribute("result") %>;
	if(!(result == null) || !(result == undefined)){
		if(result > 0){
			alert('수정이 완료되었습니다.');
		}else if(result == 0){
			alert('수정이 완료되지 않았습니다. 새로고침 후 정보가 바뀌지 않으면 다시 시도해 주세요.');
		}
	}
	
	document.getElementById('profile-img').onmouseover = function(){
		document.getElementById('img-hover').style.display = 'block';
	}
	
	document.getElementById('profile-img').onmouseout = function(){
		document.getElementById('img-hover').style.display = 'none';
	}
	
	$('#dataTable').DataTable();
	/* $('#date-sorting').trigger('click'); */
}

function serviceReady(){
	alert('준비 중 입니다.');
}

$(document).ready(function(){
	$('#main-select').change(function(){
		var selectedVal = this.value;
		
		var tags = '';
		
		if(selectedVal == '판매상품'){
			var head = '<thead>' + '<tr>' + '<th>' + '대분류명' + '</th>' + '<th>' + '대분류 시리얼' + '</th>' + '<th>' + '대분류 상태' + '</th>' + 
			'</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '대분류명' + '</th>' + '<th>' + '대분류 시리얼' + '</th>' + '<th>' + '대분류 상태' + '</th>' + 
			'</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.events}" var="eve">' + '<tr>' + '<td>' + 
			'<a href="#">${eve.eventName }</a>' + '</td>' + '<td>' + '${eve.eventSerial }' + '</td>' + '<td>' + 
			'${eve.eventStatus }' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
			
			$('.table-responsive')[0].innerHTML = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">' + tags + 
			'</table>';
			$('#dataTable').DataTable();
		}else if(selectedVal == '기본메뉴'){
			var head = '<thead>' + '<tr>' + '<th>' + '메뉴 구분' + '</th>' + '<th>' + '메뉴사진' + '</th>' + '<th>' + '메뉴명' + '</th>' + 
			'<th>' + '메뉴 옵션' + '</th>' + '<th>' + '가격' + '</th>' + '</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '메뉴 구분' + '</th>' + '<th>' + '메뉴사진' + '</th>' + '<th>' + '메뉴명' + '</th>' + 
			'<th>' + '메뉴 옵션' + '</th>' + '<th>' + '가격' + '</th>' + '</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.menus}" var="menu">' + '<tr>' + '<td>' + 
			'${menu.menu_div }' + '</td>' + '<td>' + '<img class="menu-img" alt="이미지 없음" src="${menu.menu_img }" />' + '</td>' + '<td>' + 
			'<a href="#">${menu.menu_name }</a>' + '</td>' + '<td>' + '${menu.menu_option }' + '</td>' + '<td>' + '${menu.menu_dis_price }' + 
			'</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
			
			$('.table-responsive')[0].innerHTML = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">' + tags + 
			'</table>';
			$('#dataTable').DataTable();
		}else if(selectedVal == '판매내역'){
			var head = '<thead>' + '<tr>' + '<th id="date-sorting">' + '기준일' + '</th>' + '<th>' + '메뉴명' + '</th>' + '<th>' + '결제금액' + '</th>' + 
			'<th>' + '수량' + '</th>' + '<th>' + '상태' + '</th>' + '</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '기준일' + '</th>' + '<th>' + '메뉴명' + '</th>' + '<th>' + '결제금액' + '</th>' + 
			'<th>' + '수량' + '</th>' + '<th>' + '상태' + '</th>' + '</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.sales}" var="sales">' + '<tr>' + '<td>' + 
			'<fmt:formatDate value="${sales.curDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' + '</td>' + '<td>' + '${sales.menuName }' + '</td>' + '<td>' + 
			'<fmt:formatNumber value="${sales.salesPrice}" pattern="###,###원"/>' + '</td>' + '<td>' + '${sales.ea }' + '</td>' + '<td>' + 
			'${sales.salesStatus }' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
			
			$('.table-responsive')[0].innerHTML = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">' + tags + 
			'</table>';
			$('#dataTable').DataTable();
			$('#date-sorting').trigger('click');
		}else if(selectedVal == '리뷰'){
			var head = '<thead>' + '<tr>' + '<th id="date-sorting">' + '작성일' + '</th>' + '<th>' + '이메일' + '</th>' + '<th>' + '평점' + '</th>' + '<th>' + 
			'내용' + '</th>' + '</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '작성일' + '</th>' + '<th>' + '이메일' + '</th>' + '<th>' + '평점' + '</th>' + '<th>' + '내용' + '</tr>' + 
			'</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.revs}" var="rev">' + '<tr>' + '<td>' + 
			'<fmt:formatDate value="${rev.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' + '</td>' + '<td>' + '${rev.userEmail }(${rev.nickName })' + 
			'</td>' + '<td>' + '${rev.score}' + '</td>' + '<td>' + '${rev.content }' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
			
			$('.table-responsive')[0].innerHTML = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">' + tags + 
			'</table>';
			$('#dataTable').DataTable();
			$('#date-sorting').trigger('click');
		}
	});
	
	$('#img-atag').click(function(){
		alert('216 * 216 사이즈 이상의 정사각형 이미지를 올려주세요.');
		$('#img-input').trigger('click');
	});
});

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

function goInfoChange(){
	var value = ${vo.defaultVo.seq_num};
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Get"); // Get 또는 Post 입력
	form.setAttribute("action", "./cpInfoUpdate.api");

	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "cpSeq");
	hiddenField.setAttribute("value", value);
	form.appendChild(hiddenField);

	document.body.appendChild(form);
	form.submit();
}

function goImgUpdate(){
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Get"); // Get 또는 Post 입력
	form.setAttribute("action", "./mainImgInfo.api");

	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "cpSeq");
	hiddenField.setAttribute("value", "${vo.defaultVo.seq_num}");
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type", "hidden");
	hiddenField2.setAttribute("name", "cpName");
	hiddenField2.setAttribute("value", "${vo.defaultVo.CP_name}");
	form.appendChild(hiddenField2);

	document.body.appendChild(form);
	form.submit();
}

function deleteCp(){
	if(confirm('정말 \'' + '${vo.defaultVo.CP_name}' + '\' 업체를 삭제 하시겠습니까?')){
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "Post"); // Get 또는 Post 입력
		form.setAttribute("action", "./cpDelete.api");

		var hiddenField = document.createElement("input");
		hiddenField.setAttribute("type", "hidden");
		hiddenField.setAttribute("name", "cpSeq");
		hiddenField.setAttribute("value", "${vo.defaultVo.seq_num}");
		form.appendChild(hiddenField);
		
		var hiddenField2 = document.createElement("input");
		hiddenField2.setAttribute("type", "hidden");
		hiddenField2.setAttribute("name", "email");
		hiddenField2.setAttribute("value", "${vo.defaultVo.owner_email}");
		form.appendChild(hiddenField2);

		document.body.appendChild(form);
		form.submit();
	}
}

function goAddEvent(){
	window.location.href = './eventAdd.api?cpSeq=' + ${vo.defaultVo.seq_num};
}

function mainList(){
	window.location.href = './selectMain.api?cpSeq=' + ${vo.defaultVo.seq_num};
}
</script>
<style type="text/css">
#notiTitle{
	font-size: 1.2em;
	font-weight: bolder;
}

#close-btn{
	display: block;
	margin: 0 auto;
	border: 1px solid rgba(0,0,0,.125);
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px);
}

#profile-img{
	width: 150px;
	height: 150px;
	border-radius: 70%;
    overflow: hidden;
    float: left;
}

#img-hover{
	width: 80px;
	height: 30px;
	margin: 25px 25px;
	border: 1px solid black;
	text-align: center;
	background-color: white;
	position: absolute;
	display: none;
}

#default-info{
	height: 150px;
	margin-left: 20px;
	display: block;
	float: left;
}

.default-men-info, .default-phone-info{
	display: inline;
	margin-right: 30px;
}

#cp-name-p{
	font-size: 1.3em;
}

.card-body{
	position: relative;
	display: block;
}

.second-btn{
	width: 200px;
	height: 50px;
	margin-left: 15px;
	margin-bottom: 10px;
	border: 1px solid rgba(0,0,0,.125);
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px);
	display: inline-block;
	position: relative;
	background-color: #fc8443;
	color: white;
	cursor: pointer;
}

#cp-delete{
	background-color: #cfcfcf;
	color: black;
}

.menu-img{
	width: 100px;
	height: 80px;
	display: block;
}

a{
	text-decoration: none;
	color: black;
}

#img-form{
	display: none;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<form id="img-form" action="./logoUpdate.api" method="post" enctype="multipart/form-data">
      <input type="hidden" name="cpSeq" value="${vo.defaultVo.seq_num }" />
      <input id="img-input" type="file" name="logo" accept="image/*" onchange="CheckuploadFileExt(this)"/>
</form>
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">업체정보</a>

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
	      <button class="second-btn" id="default-info-change" onclick="goInfoChange()">기본 정보 변경</button>
	      <button class="second-btn" id="main-img" onclick="goImgUpdate()">메인 이미지 수정</button>
	      <button class="second-btn" id="event-upload" onclick="goAddEvent()">상품 추가</button>
	      <button class="second-btn" id="sales-history" onclick="serviceReady()">매출 통계</button>
	      <button class="second-btn" id="sales-history" onclick="mainList()">메인 리스트 선정</button>
	      <button class="second-btn" id="cp-delete" onclick="deleteCp()">업체 삭제</button>
        <div class="container-fluid">
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <div id="img-hover">
              	<p>수정하기</p>
              </div>	
              <a id="img-atag">
              	<img id="profile-img" onerror="this.src='../../resources/webImages/profile-default.jpg'" src="${vo.defaultVo.cpLogo }">
              </a>
              <div id="default-info">
              	<p id="cp-name-p">${vo.defaultVo.CP_name }</p>
              	<div>
              		<p class="default-men-info">사장님 정보 : <a href="./ownerDetail.api?email=${vo.defaultVo.owner_email}">${vo.defaultVo.owner_email}</a></p>
              		<p class="default-men-info">전화번호 : ${vo.defaultVo.CP_phon }</p>
              		<p class="default-men-info">주소 : ${vo.defaultVo.CP_address } ${vo.defaultVo.CP_addr_details }</p>
              	</div>
              	<div>
              		<p class="default-phone-info">업체 소개 : ${vo.defaultVo.CP_intro }</p>
              		<p class="default-phone-info">휴무일 : ${vo.defaultVo.close_day }&nbsp;${vo.defaultVo.close_ect }</p>
              		<%
              			AdminCpDetailVO vo = (AdminCpDetailVO)request.getAttribute("vo");
              		%>
              		<p class="default-phone-info">영업시간 : <%=vo.getDefaultVo().getBusiness_start() %> ~ <%=vo.getDefaultVo().getBusiness_end() %></p>
              	</div>
              	<br>
              	<p class="default-phone-info">업체 상태 : ${vo.defaultVo.cpStatus }</p>
              </div>
            </div>
            <div class="card-body">
	              <div class="card mb-3">
	            <div class="card-header">
	            	<select id="main-select">
	            		<option selected="selected">판매상품</option>
	            		<option>기본메뉴</option>
	            		<option>판매내역</option>
	            		<option>리뷰</option>
	            	</select>
	            </div>
	            <div class="card-body">
	              <div class="table-responsive">
	                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                  <thead>
	                    <tr>
	                      <th>대분류명</th>
	                      <th>대분류 시리얼</th>
	                      <th>대분류 상태</th>
	                    </tr>
	                  </thead>
	                  <tfoot>
	                    <tr>
	                      <th>대분류명</th>
	                      <th>대분류 시리얼</th>
	                      <th>대분류 상태</th>
	                    </tr>
	                  </tfoot>
	                  <tbody id="list_body">
	                    <c:forEach items="${vo.events}" var="eve">
							<tr class="btn-modal-button">
								<td><a href="./eventDetail.api?serial=${eve.eventSerial }">${eve.eventName }</a></td>
								<td>${eve.eventSerial }</td>
								<td>${eve.eventStatus }</td>
							</tr>
						</c:forEach>
	                  </tbody>
	                </table>
	              </div>
	            </div>
	          </div>
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
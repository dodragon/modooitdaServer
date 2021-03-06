<%@page import="com.baobab.m.vo.AdminUserDetailVO"%>
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
	
	var pushResult = <%=request.getAttribute("result") %>;
	if(!(pushResult == null) || !(pushResult == undefined)){
		if(pushResult > 0){
			alert('푸시가 정상적으로 보내졌습니다.');
		}else{
			alert('푸시가 보내지지 않았습니다. 다시 시도해 주세요.');
		}
	}
	
	$('#dataTable').DataTable();
	$('#date-sorting').trigger('click');
}

$(document).ready(function(){
	$('#main-select').change(function(){
		var selectedVal = this.value;
		
		var tags = '';
		
		if(selectedVal == '결제내역'){
			var head = '<thead>' + '<tr>' + '<th id="date-sorting">' + '기준일' + '</th>' + '<th>' + '업체명' + '</th>' + '<th>' + '메뉴' + '</th>' + 
			'<th>' + '결제금액' + '</th>' + '<th>' + '주문번호' + '</th>' + '<th>' + '결제상태' + '</th>' + '</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '기준일' + '</th>' + '<th>' + '업체명' + '</th>' + '<th>' + '메뉴' + '</th>' + 
			'<th>' + '결제금액' + '</th>' + '<th>' + '주문번호' + '</th>' + '<th>' + '결제상태' + '</th>' + '</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.payList}" var="pay">' + '<tr>' + '<td>' + 
			'<fmt:formatDate value="${pay.curDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' + '</td>' + '<td>' + '${pay.cpName}' + '</td>' + '<td>' + 
			'${pay.goods}' + '</td>' + '<td>' + '<fmt:formatNumber value="${pay.totalDisPrice}" pattern="###,###원"/>' + '</td>' + 
			'<td>' + '${pay.orderNum}' + '</td>' + '<td>' + '${pay.payStatus}' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
		}else if(selectedVal == '티켓 히스토리'){
			var head = '<thead>' + '<tr>' + '<th id="date-sorting">' + '기준일' + '</th>' + '<th>' + '티켓명' + '</th>' + '<th>' + '업체명' + '</th>' + 
			'<th>' + '결제금액' + '</th>' + '<th>' + '주문번호' + '</th>' + '<th>' + '티켓상태' + '</th>' + '</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '기준일' + '</th>' + '<th>' + '티켓명' + '</th>' + '<th>' + '업체명' + '</th>' + 
			'<th>' + '결제금액' + '</th>' + '<th>' + '주문번호' + '</th>' + '<th>' + '티켓상태' + '</th>' + '</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.ticketList}" var="tic">' + '<tr>' + '<td>' + 
			'<fmt:formatDate value="${tic.curDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' + '</td>' + '<td>' + '${tic.ticketTitle}' + '</td>' + '<td>' + 
			'${tic.cpName }' + '</td>' + '<td>' + '<fmt:formatNumber value="${tic.amount }" pattern="###,###원"/>' + '</td>' + 
			'<td>' + '${tic.orderNum }' + '</td>' + '<td>' + '${tic.ticketStatus }' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
		}else if(selectedVal == '리뷰'){
			var head = '<thead>' + '<tr>' + '<th id="date-sorting">' + '기준일' + '</th>' + '<th>' + '평점' + '</th>' + '<th>' + '내용' + '</th>' + 
			'<th>' + '업체명' + '</th>' + '<th>' + '사용티켓' + '</th>' + '</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '기준일' + '</th>' + '<th>' + '평점' + '</th>' + '<th>' + '내용' + '</th>' + 
			'<th>' + '업체명' + '</th>' + '<th>' + '사용티켓' + '</th>' + '</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.revList}" var="rev">' + '<tr>' + '<td>' + 
			'<fmt:formatDate value="${rev.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>' + '</td>' + '<td>' + '${rev.score}' + '</td>' + '<td>' + 
			'${rev.content}' + '</td>' + '<td>' + '${rev.cpName }' + '</td>' + '<td>' + '${rev.usedTicket}' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
		}else if(selectedVal == '찜하기'){
			var head = '<thead>' + '<tr>' + '<th id="date-sorting">' + '찜한날짜' + '</th>' + '<th>' + '업체명' + '</th>' + '<th>' + '업체주소' + '</th>' + 
			'</tr>' + '</thead>';
			var foot = '<tfoot>' + '<tr>' + '<th>' + '찜한날짜' + '</th>' + '<th>' + '업체명' + '</th>' + '<th>' + '업체주소' + '</th>' + 
			'</tr>' + '</tfoot>';
			var body = '<tbody id="list_body">' + '<c:forEach items="${vo.pokeList}" var="poke">' + '<tr>' + '<td>' + 
			'<fmt:formatDate value="${poke.poke_date}" pattern="yyyy-MM-dd HH:mm:ss"/>' + '</td>' + '<td>' + '${poke.cp_name}' + '</td>' + '<td>' + 
			'${poke.cp_address}' + '</td>' + '</tr>' + '</c:forEach>' + '</tbody>';
			
			tags = head + foot + body;
		}
		
		$('.table-responsive')[0].innerHTML = '<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">' + tags + 
		'</table>';
		$('#dataTable').DataTable();
		$('#date-sorting').trigger('click');
	});
});

function serviceReady(){
	alert('준비 중 입니다.');
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

#default-info{
	height: 150px;
	margin-left: 20px;
	display: block;
	float: left;
	overflow: hidden;
}

.default-men-info, .default-phone-info{
	display: inline;
	margin-right: 30px;
}

#email-p{
	font-size: 1.3em;
}

.card-body{
	position: relative;
	display: block;
}

a{
	text-decoration: none;
	color: black;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">회원정보</a>

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
              <img id="profile-img" onerror="this.src='../../resources/webImages/profile-default.jpg'" src="${vo.defaultInfo.profileImg }">
              <div id="default-info">
              	<p id="email-p">${vo.defaultInfo.email }(${vo.defaultInfo.div_code })</p>
              	<div>
              		<p class="default-men-info">이름 : ${vo.defaultInfo.userName }(${vo.defaultInfo.nickName })</p>
              		<p class="default-men-info">생년월일 : ${vo.defaultInfo.birth }</p>
              		<%
              			String gender = "";
              			AdminUserDetailVO vo = (AdminUserDetailVO)request.getAttribute("vo");
              			if(vo.getDefaultInfo().getGender() == 0){
              				gender = "남자";
              			}else if(vo.getDefaultInfo().getGender() == 1){
              				gender = "여자";
              			}
              		%>
              		<p class="default-men-info">성별 : <%=gender %></p>
              	</div>
              	<div>
              		<p class="default-phone-info">통신사 : ${vo.defaultInfo.phone_corp }</p>
              		<p class="default-phone-info">휴대폰 번호 : ${vo.defaultInfo.phon_num }</p>
              	</div>
              	<br>
              	<p class="default-phone-info">마지막 주소 : ${vo.userLocation }</p>
              </div>
            </div>
            <div class="card-body">
	              <div class="card mb-3">
	            <div class="card-header">
	            	<select id="main-select">
	            		<option selected="selected">결제내역</option>
	            		<option>티켓 히스토리</option>
	            		<option>리뷰</option>
	            		<option>찜하기</option>
	            	</select>
	            </div>
	            <div class="card-body">
	              <div class="table-responsive">
	                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                  <thead>
	                    <tr>
	                      <th id="date-sorting">기준일</th>
	                      <th>업체명</th>
	                      <th>메뉴</th>
	                      <th>결제금액</th>
	                      <th>주문번호</th>
	                      <th>결제상태</th>
	                    </tr>
	                  </thead>
	                  <tfoot>
	                    <tr>
	                      <th>기준일</th>
	                      <th>업체명</th>
	                      <th>메뉴</th>
	                      <th>결제금액</th>
	                      <th>주문번호</th>
	                      <th>결제상태</th>
	                    </tr>
	                  </tfoot>
	                  <tbody id="list_body">
	                    <c:forEach items="${vo.payList}" var="pay">
							<tr class="btn-modal-button">
								<td><fmt:formatDate value="${pay.curDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${pay.cpName }</td>
								<td>${pay.goods }</td>
								<td><fmt:formatNumber value="${pay.totalDisPrice }" pattern="###,###원"/></td>
								<td>${pay.orderNum }</td>
								<td>${pay.payStatus }</td>
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
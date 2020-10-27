<%@page import="com.baobab.m.vo.EventCpOptionVO"%>
<%@page import="com.baobab.m.vo.EventCpVO"%>
<%@page import="java.util.List"%>
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
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "../admin.api";
	}
}

 $(document).ready(function(){
	$('#update-option').click(function(){
		$('#update-modal').show();
	});
});

function closeModal() {
	$('#update-modal').hide();
};

function updateOption(){
	var serial = '${vo.optionSerial}';
	var updateName = document.getElementById('optionName').value;
	var eventSerial = document.getElementById('eventSelect').value;
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "./updateOption.api");
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "optionSerial");
	hiddenField.setAttribute("value", serial);
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type", "hidden");
	hiddenField2.setAttribute("name", "optionName");
	hiddenField2.setAttribute("value", updateName);
	form.appendChild(hiddenField2);
	
	var hiddenField3 = document.createElement("input");
	hiddenField3.setAttribute("type", "hidden");
	hiddenField3.setAttribute("name", "eventSerial");
	hiddenField3.setAttribute("value", eventSerial);
	form.appendChild(hiddenField3);
	
	var hiddenField4 = document.createElement("input");
	hiddenField4.setAttribute("type", "hidden");
	hiddenField4.setAttribute("name", "cpSeq");
	hiddenField4.setAttribute("value", '${cpSeq}');
	form.appendChild(hiddenField4);

	document.body.appendChild(form);
	form.submit();
}

function deleteOption(){
	var serial = '${vo.optionSerial}';
	var eventSerial = '${vo.eventSerial}';
	
	var form = document.createElement("form");
	form.setAttribute("charset", "UTF-8");
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "./deleteOption.api");
	
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "serial");
	hiddenField.setAttribute("value", serial);
	form.appendChild(hiddenField);
	
	var hiddenField2 = document.createElement("input");
	hiddenField2.setAttribute("type", "hidden");
	hiddenField2.setAttribute("name", "eventSerial");
	hiddenField2.setAttribute("value", eventSerial);
	form.appendChild(hiddenField2);
	
	document.body.appendChild(form);
	form.submit();
}

function addMenu(){
	window.location.href = './eventMenuAdd.api?os=${vo.optionSerial}&cpSeq=${cpSeq}';
}
</script>
<style type="text/css">
#input-notice{
	width: 200px;
	height: 50px;
	margin-left: 15px;
	margin-bottom: 10px;
	border: 1px solid rgba(0,0,0,.125);
	border-radius: calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px) calc(.25rem - 1px);
}

a{
	text-decoration: none;
	color: black;
}

#update-option{
	margin: 0 0 15px 15px;
}

/* Modal Content/Box */
#update-modal {
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

.update-fade-modal {
	background-color: #fefefe;
	margin: 0 35% 0 35%; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}

#update-btn, #delete-btn{
	margin-top: 15px;
	margin-left: 15px;
}

#modal-content{
	margin-top: 30px;
}

#optionName, #eventSelect{
	width: 300px;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<div id="update-modal">
	<div class="update-fade-modal">
		<div class="page-header">
			<h1>중분류 수정</h1>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<div id="modal-content">
							<b>중분류명 수정</b><br>
							<input name="optionName" id="optionName" type="text" placeholder="수정할 중분류명을 입력해 주세요." value="${vo.optionName }"/>
							<br>
							<br>
							<%
								EventCpOptionVO vo = (EventCpOptionVO)request.getAttribute("vo");
								List<EventCpVO> eventList = (List<EventCpVO>)request.getAttribute("serials");
								String optionTagHtml = "";
								String defaultEventName = "";
								for(int i=0;i<eventList.size();i++){
									if(vo.getEventSerial().equals(eventList.get(i).getEventSerial())){
										optionTagHtml += "<option selected=\"selected\" value=\"" + eventList.get(i).getEventSerial() + "\">";
										defaultEventName = eventList.get(i).getEventName();
									}else{
										optionTagHtml += "<option value=\"" + eventList.get(i).getEventSerial() + "\">";
									}
									
									optionTagHtml += eventList.get(i).getEventName() + "</option>";
								}
							%>
							<b>이동할 대분류 (기존 : <%=defaultEventName %>)</b><br>
							<select id="eventSelect"><%=optionTagHtml %></select>
						</div>
					</div>
					<br>
					<button id="delete-btn" onclick="deleteOption()">삭제</button>
					<button id="update-btn" onclick="updateOption()">저장</button>
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
      <a class="navbar-brand mr-1" href="./mainpage.api">중분류 수정</a>

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
      	<button id="update-option">중분류 수정</button>
      	<button id="add-menu" onclick="addMenu()">소분류 추가</button>
        <div class="container-fluid">
          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <p><strong>${vo.optionName }</strong>&nbsp;&nbsp;&nbsp;&nbsp;판매량 : ${vo.salesRate }</p>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>소분류명</th>
                      <th>원가</th>
                      <th>할인가</th>
                      <th>할인율</th>
                      <th>판매량</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>소분류명</th>
                      <th>원가</th>
                      <th>할인가</th>
                      <th>할인율</th>
                      <th>판매량</th>
                    </tr>
                  </tfoot>
                  <tbody id="list_body">
                    <c:forEach items="${vo.menuList}" var="menu">
						<tr class="btn-modal-button">
							<td><a href="./eventMenuDetail.api?seq=${menu.seqNum}&cpSeq=${cpSeq}">${menu.menuName }</a></td>
							<td><fmt:formatNumber value="${menu.price }" pattern="###,###원"/></td>
							<td><fmt:formatNumber value="${menu.disPrice }" pattern="###,###원"/></td>
							<td>${menu.percentAge }%</td>
							<td>${menu.salesRate }</td>
						</tr>
					</c:forEach>
                  </tbody>
                </table>
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
<%@page import="com.baobab.m.vo.MeetingLogVO"%>
<%@page import="com.baobab.m.vo.AdminAccountVO"%>
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
	
	var today = new Date();
	
	dateSetting(today);
	timeSetting(today);
}

function dateSetting(today){
	var year = today.getFullYear();
	var month = today.getMonth() + 1;
	var date = today.getDate();
	
	if(hours < 10){
		hours = '0' + hours;
	}
	if(minutes < 10){
		minutes = '0' + minutes;
	}
	
	document.getElementById('startTime').value = hours + ':' + minutes;
	document.getElementById('endTime').value = hours + ':' + minutes;
}

function timeSetting(today){
	var hours = today.getHours();
	var minutes = today.getMinutes();
	
	if(hours < 10){
		hours = '0' + hours;
	}
	if(minutes < 10){
		minutes = '0' + minutes;
	}
	
	document.getElementById('startTime').value = hours + ':' + minutes;
	document.getElementById('endTime').value = hours + ':' + minutes;
}



function update(){
	var meetTitle = document.getElementById('meet_title').value;
	var mainAgenda = document.getElementById('main_agenda').value;
	var place = document.getElementById('place').value;
	var meetDate = document.getElementById('meetDate').value;
	var startTime = document.getElementById('startTime').value;
	var endTime = document.getElementById('endTime').value;
	var contents = document.getElementById('contents').value;
	var result = document.getElementById('result').value;
	var director = document.getElementById('director').value;
	var writer = '<%=session.getAttribute("jobClass") %> 님(<%=session.getAttribute("department") %>)';
	var attendees = '';
	
	var attendeesCnt = document.getElementsByClassName('attendees').length;
	for(var i=0;i<attendeesCnt;i++){
		if(document.getElementsByClassName('attendees')[i].checked == true){
			if(i == attendeesCnt - 1){
				attendees += document.getElementsByClassName('attendees')[i].value;
			}else{
				attendees += document.getElementsByClassName('attendees')[i].value + ', ';
			}
		}
	}
	
	if(attendees.charAt(attendees.length - 1) == ','){
		attendees = attendees.slice(0, -1);
	}
	
	if(!meetTitle){
		alert('제목을 입력 해 주세요.');
	}else if(!mainAgenda){
		alert('주요 안건을 입력 해 주세요.');
	}else if(!place){
		alert('회의 장소를 입력 해 주세요.');
	}else if(!contents){
		alert('회의 내용을 입력 해 주세요.');
	}else if(!result){
		alert('회의 결과를 입력 해 주세요.');
	}else if(!attendees){
		alert('참석자가 없을 수 없습니다.');
	}else{
		var nameArr = new Array('meetTitle', 'mainAgenda', 'place', 'meetDate', 'startTime', 'endTime', 'contents', 'result', 'director', 'writer', 'attendees', 'seqNum');
		var valueArr = new Array(meetTitle, mainAgenda, place, meetDate, startTime, endTime, contents, result, director, writer, attendees, '${vo.seqNum}');
		
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "Post"); // Get 또는 Post 입력
		form.setAttribute("action", "./meetLogUpdate.api");
		
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

#meet_title{
	width: 50%;
}

#agenda_div{
	width: 50%;
	margin-top: 15px;
}

#agenda_div input{
	width: 48.69%;
}

#place{
	margin-left: 15px;
}

#date_time_div{
	width: 50%;
	height: 60px;
	margin-top: 25px;
}

#margin_child{
	margin-right: 15px;
	margin-left: 15px;
}

#date_time_div div{
	width: 32%;
	float: left;
}

#date_time_div div input{
	width: 100%;
}

textarea{
	width: 50%;
	height: 350px;
	margin-top: 25px;
}

#person_div{
	width: 50%;
	height: 60px;
}

#person_div div{
	width: 49.05%;
	float: left;
}

#writer_div{
	margin-left: 15px;
}

#director{
	width: 100%;
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
      <a class="navbar-brand mr-1" href="./mainpage.api">회의록</a>

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
              	<h3>회의록</h3>
              	<div id="form-div">
	              	<input id="meet_title" type="text" placeholder="회의 제목을 작성해 주세요." maxlength="200" value="${vo.meetingTitle }"/><br>
	              	<div id="agenda_div">
	              		<input id="main_agenda" type="text" placeholder="주요 안건" value="${vo.mainAgenda }"/>
	              		<input id="place" type="text" placeholder="회의 장소" value="${vo.place }"/>
	              	</div>
	              	<div id="date_time_div">
	              		<div>
		              		회의 날짜<br>
		              		<input id="meetDate" type="date" value="<fmt:formatDate value="${vo.meetingDate }" pattern="yyyy-MM-dd"/>"/>
		              	</div>
		              	<div id="margin_child">
		              		시작시간<br>
		              		<input id="startTime" type="time" value="<fmt:formatDate value="${vo.startTime }" pattern="HH:mm"/>"/>
		              	</div>
		              	<div>
		              		종료시간<br>
		              		<input id="endTime" type="time" value="<fmt:formatDate value="${vo.endTime }" pattern="HH:mm"/>"/>
		              	</div>
	              	</div>
	              	<textarea id="contents" style="resize: none;" placeholder="회의 내용을 작성해 주세요.">${vo.meetingContents }</textarea>
	              	<textarea id="result" style="resize: none;" placeholder="회의 결과룰 작성해 주세요.">${vo.meetingResult }</textarea><br><br>
	              	<div id="person_div">
	              		<div>
		              		책임자<br>
			              	<select id="director">
			              		<%
			              			List<AdminAccountVO> adminList = (List<AdminAccountVO>) request.getAttribute("adminList");
			              			MeetingLogVO vo = (MeetingLogVO) request.getAttribute("vo");
			              			for(int i=0;i<adminList.size();i++){
			              				if(vo.getDirector().contains(adminList.get(i).getJob_class())){
			              				%>
			              					<option selected="selected"><%=adminList.get(i).getJob_class() %> 님(<%=adminList.get(i).getDepartment() %>)</option>
			              				<%
			              				}else{
			              				%>
			              					<option><%=adminList.get(i).getJob_class() %> 님(<%=adminList.get(i).getDepartment() %>)</option>
			              				<% 	
			              				}
			              			}
			              		%>
		              		</select>
	              		</div>
	              	</div><br>
	              	<div>
	              		참석자<br>
	              		<%
	              			String[] attendeesArr = vo.getAttendees().split(", ");
	              			for(int i=0;i<adminList.size();i++){
	              				if(vo.getAttendees().contains(adminList.get(i).getJob_class())){
	              				%>
	              					<input class="attendees" id="<%=adminList.get(i).getName() %>" type="checkbox" value="<%=adminList.get(i).getJob_class() %> 님(<%=adminList.get(i).getDepartment() %>)" checked/>
	              					<label for="<%=adminList.get(i).getName() %>"><%=adminList.get(i).getJob_class() %> 님(<%=adminList.get(i).getDepartment() %>)</label><br>
	              				<% 
	              					//break;
	              				}else{
	              				%>	
	              					<input class="attendees" id="<%=adminList.get(i).getName() %>" type="checkbox" value="<%=adminList.get(i).getJob_class() %> 님(<%=adminList.get(i).getDepartment() %>)" />
	              					<label for="<%=adminList.get(i).getName() %>"><%=adminList.get(i).getJob_class() %> 님(<%=adminList.get(i).getDepartment() %>)</label><br>
	              				<%
	              					//break;
	              				}
	              			}
	              		%>
	              	</div>
              	</div>
              </div>
            </div>
            </div>
            <button onclick="update()">저장하기</button>
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
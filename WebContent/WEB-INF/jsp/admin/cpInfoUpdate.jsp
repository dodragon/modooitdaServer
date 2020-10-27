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
<!-- daum address api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
<%
	CPInfoVO vo = (CPInfoVO)request.getAttribute("vo");
%>
window.onload = function(){
	var id = "<%=session.getAttribute("id")%>";
	if (id == "null") {
		window.location.href = "../admin.api";
	}
	
	weekSetting();
	themeSetting();
	statusSetting('${vo.cpStatus}');
}

function weekSetting(){
	/* 휴무일 */
	var weekValue = '${vo.close_day}';
	var weekArr = new Array();
	weekArr = weekValue.split('~');
	
	var first = document.getElementsByClassName('first-week');
	var second = document.getElementsByClassName('second-week');
	var third = document.getElementsByClassName('third-week');
	var fourth = document.getElementsByClassName('fourth-week');
	var fifth = document.getElementsByClassName('fifth-week');
	
	var checksDoubleArr = new Array(first, second, third, fourth, fifth);

	for(var i=0;i<5;i++){
		var weekStr = weekArr[i];
		for(var j=0;j<checksDoubleArr.length;j++){
			for(var k=0;k<checksDoubleArr[j].length;k++){
				if(weekStr.indexOf(checksDoubleArr[j][k].value) != -1){
					checksDoubleArr[j][k].checked = true;
				}
			}
		}
	}
}

$(document).ready(function(){
	/* 영업시간 */
	var bStartHselect = $('#b-start-h');
	var bStartMselect = $('#b-start-m');
	var bEndHselect = $('#b-end-h');
	var bEndMselect = $('#b-end-m');
	
	var bStartH = '<%=vo.getBusiness_start().split(":")[0] %>';
	var bStartM = '<%=vo.getBusiness_start().split(":")[1] %>';
	var bEndH = '<%=vo.getBusiness_end().split(":")[0] %>';
	var bEndM = '<%=vo.getBusiness_end().split(":")[1] %>';
	
	bStartHselect.val(bStartH).attr('selected', 'selected');
	bStartMselect.val(bStartM).attr('selected', 'selected');
	bEndHselect.val(bEndH).attr('selected', 'selected');
	bEndMselect.val(bEndM).attr('selected', 'selected');
	
	/* kind, type */
	var kind = '${vo.CP_kind}';
	var type = '${vo.CP_type}';
	
	$('#kind').val(kind).attr('selected', 'selected');
	
	var kindArrStr = '한식, 탕류/건강식, 중국, 일식, 서양식, 외국음식점(태국, 인도), 돈까스,회,일식, 술집/소주방/호프, 카페,디저트, 레스토랑/붸페식, 고기집, 치킨, 분식, 페스트푸드,피자, 족발,보쌈, 냉면집/면류, 도시락/간단식, 곱창(막창), 포장마차(실내,실외), 찻집, 다방, 아이스크림,팥빙수, 제과제빵, 고속도로, 공항, 극장, 백화점, 아이스크림, 유원지, 전통찻집, 철도역구내(지하철), 푸드트럭';
	
	var typeArr = rtnTypeArr(kind);
	var typeHtml = '';
	
	for(var i=0;i<typeArr.length;i++){
		if(type == typeArr[i]){
			typeHtml += '<option selected="selected">' + typeArr[i] + '</option>';
		}else{
			typeHtml += '<option>' + typeArr[i] + '</option>';
		}
	}
	
	$('#type')[0].innerHTML = typeHtml;
	
	$('#kind').change(function(){
		var kindStr = $('#kind').val();
		var typeArr = rtnTypeArr(kindStr);
		var typeHtml = '';
		
		for(var i=0;i<typeArr.length;i++){
			if(type == typeArr[i]){
				typeHtml += '<option selected="selected">' + typeArr[i] + '</option>';
			}else{
				typeHtml += '<option>' + typeArr[i] + '</option>';
			}
		}
		
		$('#type')[0].innerHTML = typeHtml;
	});
});

function themeSetting(){
	/* 테마 */
	var theme1 = '${vo.CP_Theme1}';
	var theme2 = '${vo.CP_Theme2}';
	
	var theme1Box = document.getElementsByClassName('theme-1');
	var theme2Box = document.getElementsByClassName('theme-2');
	
	for(var i=0;i<9;i++){
		if(theme1.indexOf(theme1Box[i].value) != -1){
			theme1Box[i].checked = true;
		}
		if(theme2.indexOf(theme2Box[i].value) != -1){
			theme2Box[i].checked = true;
		}
	}
	
	var theme1_10 = '';
	var theme2_10 = '';
	
	var theme1Arr = theme1.replace('[', '').replace(']', '').split(', ');
	var theme2Arr = theme2.replace('[', '').replace(']', '').split(', ');
	
	var theme1All = '';
	var theme2All = '';
	
	for(var i=0;i<theme1Box.length;i++){
		theme1All += theme1Box[i].value;
		theme2All += theme2Box[i].value;
	}
	
	for(var i=0;i<theme1Arr.length;i++){
		if(theme1All.indexOf(theme1Arr[i]) == -1){
			theme1_10 = theme1Arr[i];
			break;
		}
	}
	for(var i=0;i<theme2Arr.length;i++){
		if(theme2All.indexOf(theme2Arr[i]) == -1){
			theme2_10 = theme2Arr[i];
			break;
		}
	}
	
	document.getElementById('theme1-10').value = theme1_10;
	document.getElementById('theme2-10').value = theme2_10;
}

function statusSetting(status){
	if(status == 'open'){
		document.getElementById('status-open').checked = true;
	}else{
		document.getElementById('status-close').checked = true;
	}
}

function rtnTypeArr(kind){
	if(kind == '한식'){
		return new Array('순대', '오리', '닭갈비', '감자탕', '찜닭', '샤브샤브', '게 요리', '해산물', '기타(직접입력)');
	}else if(kind == '탕류/건강식'){
		return new Array('염소고기', '장어', '추어탕', '기타(직접입력)');
	}else if(kind == '중국'){
		return new Array('중국요리', '양꼬치', '훠궈', '기타(직접입력)');
	}else if(kind == '일식'){
		return new Array('초밥', '돈까스', '횟집', '복어', '기타(직접입력)');
	}else if(kind == '외국음식점(태국,인도)'){
		return new Array('인도', '베트남', '태국', '필리핀', '기타(직접입력)');
	}else if(kind == '돈까스,회,일식'){
		return new Array('돈까스', '회', '일식', '기타(직접입력)');
	}else if(kind == '술집/소주방/호프'){
		return new Array('소주방', '호프', '주점', '기타(직접입력)');
	}else if(kind == '카페,디저트'){
		return new Array('커피샵', '라이브카페', '키즈카페', '기타(직접입력)');
	}else if(kind == '레스토랑/뷔페식'){
		return new Array('레스토랑', '뷔페식', '패밀리 레스토랑', '기타(직접입력)');
	}else if(kind == '고기집'){
		return new Array('삼겹살', '갈비', '한우', '기타(직접입력)');
	}else if(kind == '치킨'){
		return new Array('통닭', '치킨', '닭강정', '기타(직접입력)');
	}else if(kind == '분식'){
		return new Array('분식', '기타(직접입력)');
	}else if(kind == '페스트푸드,피자'){
		return new Array('패스트푸드', '피자', '기타(직접입력)');
	}else if(kind == '족발,보쌈'){
		return new Array('족발', '보쌈', '기타(직접입력)');
	}else if(kind == '냉면집/면류'){
		return new Array('메밀국수', '막국수', '기타(직접입력)');
	}else if(kind == '포장마차(실내,실외)'){
		return new Array('실내', '실외', '기타(직접입력)');
	}else if(kind == '찻집'){
		return new Array('전통찻집', '기타(직접입력)');
	}else if(kind == '다방'){
		return new Array('다방', '기타(직접입력)');
	}else if(kind == '아이스크림,팥빙수'){
		return new Array('아이스크림', '팥빙수', '기타(직접입력)');
	}else if(kind == '제과제빵'){
		return new Array('제과영업', '기타(직접입력)');
	}else{
		return new Array('기타(직접입력)');
	}
}

function infoSubmit(){
	document.getElementById('info-form').submit();
}

function findAddr(){
	new daum.Postcode({
		oncomplete: function(data){
			var addr = '';
			var extraAddr = '';
			
			if(data.userSelectedType === 'R'){
				addr = data.roadAddress;
				
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				if(data.buildingName !== '' && data.apratment === 'Y'){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				if(extraAddr !== ''){
					extraAddr = ' (' + extraAddr + ')';
				}
				
			}else{
				addr = data.jibunAddress;
			}
			
			document.getElementById('addr').value = addr;
			document.getElementById('addrDetail').value = extraAddr;
			document.getElementById('zipcode').value = data.zonecode;
			
			document.getElementById('addrDetail').focus();
		}
	}).open();
}

function serviceReady(){
	alert('준비 중 입니다.');
}
</script>
<style type="text/css">
input[type="text"]{
	display: block;
	margin-top: 20px;
}

#cpName, #phoneNum, #addr{
	width: 300px;
}

#addrDetail, #zipcode, #b-start, #b-end{
	display: inline;
}

#zipcode{
	width: 113px;
}

#addr-btn{
	margin-top: 5px;
	border: 1px solid black;
}

#time-ect{
	width: 300px;
}

input[type="checkbox"]{
	margin-left: 5px;
}

#kind, #type{
	width: 186px;
}

#intro{
	width: 377px;
}

#cp-kind-ect, #cp-type-ect{
	display: inline;
	width: 186px;
}
</style>
<title>모두잇다 관리자</title>
</head>
<body id="page-top">
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
      <a class="navbar-brand mr-1" href="./mainpage.api">업체 정보 수정</a>

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
	            <form id="info-form" action="./infoUpdate.api" method="post">
	            	<input name="cpSeq" type="hidden" value="${vo.seq_num }">
	            	<input name="cpName" id="cpName" type="text" maxlength="35" placeholder="업체명" value="${vo.CP_name }">
	            	<input name="cpPhone" id="phoneNum" type="text" placeholder="전화번호(-제외)" value="${vo.CP_phon }">
	            	<input name="cpAddr" id="addr" type="text" placeholder="주소" value="${vo.CP_address }" readonly="readonly">
	            	<input name="cpAddrDetail" id="addrDetail" type="text" placeholder="상세주소" value="${vo.CP_addr_details }">
	            	<input name="zipcode" id="zipcode" type="text" placeholder="우편번호" value="${vo.CP_zipcode }" readonly="readonly">
	            	<br>
	            	<button id="addr-btn" type="button" onclick="findAddr()">주소찾기</button>
	            	<hr>
	            	첫째주 : <input name="first_week" class="first-week" id="first-mon" type="checkbox" value="월"><label for="first-mon">월</label>
	            	<input name="first_week" class="first-week" id="first-tue" type="checkbox" value="화"><label for="first-tue">화</label>
	            	<input name="first_week" class="first-week" id="first-wed" type="checkbox" value="수"><label for="first-wed">수</label>
	            	<input name="first_week" class="first-week" id="first-thu" type="checkbox" value="목"><label for="first-thu">목</label>
	            	<input name="first_week" class="first-week" id="first-fri" type="checkbox" value="금"><label for="first-fri">금</label>
	            	<input name="first_week" class="first-week" id="first-sat" type="checkbox" value="토"><label for="first-sat">토</label>
	            	<input name="first_week" class="first-week" id="first-sun" type="checkbox" value="일"><label for="first-sun">일</label><br>
	            	둘째주 : <input name="second_week" class="second-week" id="second-mon" type="checkbox" value="월"><label for="second-mon">월</label>
	            	<input name="second_week" class="second-week" id="second-tue" type="checkbox" value="화"><label for="second-tue">화</label>
	            	<input name="second_week" class="second-week" id="second-wed" type="checkbox" value="수"><label for="second-wed">수</label>
	            	<input name="second_week" class="second-week" id="second-thu" type="checkbox" value="목"><label for="second-thu">목</label>
	            	<input name="second_week" class="second-week" id="second-fri" type="checkbox" value="금"><label for="second-fri">금</label>
	            	<input name="second_week" class="second-week" id="second-sat" type="checkbox" value="토"><label for="second-sat">토</label>
	            	<input name="second_week" class="second-week" id="second-sun" type="checkbox" value="일"><label for="second-sun">일</label><br>
	            	셋째주 : <input name="third_week" class="third-week" id="third-mon" type="checkbox" value="월"><label for="third-mon">월</label>
	            	<input name="third_week" class="third-week" id="third-tue" type="checkbox" value="화"><label for="third-tue">화</label>
	            	<input name="third_week" class="third-week" id="third-wed" type="checkbox" value="수"><label for="third-wed">수</label>
	            	<input name="third_week" class="third-week" id="third-thu" type="checkbox" value="목"><label for="third-thu">목</label>
	            	<input name="third_week" class="third-week" id="third-fri" type="checkbox" value="금"><label for="third-fri">금</label>
	            	<input name="third_week" class="third-week" id="third-sat" type="checkbox" value="토"><label for="third-sat">토</label>
	            	<input name="third_week" class="third-week" id="third-sun" type="checkbox" value="일"><label for="third-sun">일</label><br>
	            	넷째주 : <input name="fourth_week" class="fourth-week" id="fourth-mon" type="checkbox" value="월"><label for="fourth-mon">월</label>
	            	<input name="fourth_week" class="fourth-week" id="fourth-tue" type="checkbox" value="화"><label for="fourth-tue">화</label>
	            	<input name="fourth_week" class="fourth-week" id="fourth-wed" type="checkbox" value="수"><label for="fourth-wed">수</label>
	            	<input name="fourth_week" class="fourth-week" id="fourth-thu" type="checkbox" value="목"><label for="fourth-thu">목</label>
	            	<input name="fourth_week" class="fourth-week" id="fourth-fri" type="checkbox" value="금"><label for="fourth-fri">금</label>
	            	<input name="fourth_week" class="fourth-week" id="fourth-sat" type="checkbox" value="토"><label for="fourth-sat">토</label>
	            	<input name="fourth_week" class="fourth-week" id="fourth-sun" type="checkbox" value="일"><label for="fourth-sun">일</label><br>
	            	다섯째주 : <input name="fifth_week" class="fifth-week" id="fifth-mon" type="checkbox" value="월"><label for="fifth-mon">월</label>
	            	<input name="fifth_week" class="fifth-week" id="fifth-tue" type="checkbox" value="화"><label for="fifth-tue">화</label>
	            	<input name="fifth_week" class="fifth-week" id="fifth-wed" type="checkbox" value="수"><label for="fifth-wed">수</label>
	            	<input name="fifth_week" class="fifth-week" id="fifth-thu" type="checkbox" value="목"><label for="fifth-thu">목</label>
	            	<input name="fifth_week" class="fifth-week" id="fifth-fri" type="checkbox" value="금"><label for="fifth-fri">금</label>
	            	<input name="fifth_week" class="fifth-week" id="fifth-sat" type="checkbox" value="토"><label for="fifth-sat">토</label>
	            	<input name="fifth_week" class="fifth-week" id="fifth-sun" type="checkbox" value="일"><label for="fifth-sun">일</label><br><br>
	            	영업시간<br>
	            	<select name="bStartH" id="b-start-h">
	            		<option>00</option>
	            		<option>01</option>
	            		<option>02</option>
	            		<option>03</option>
	            		<option>04</option>
	            		<option>05</option>
	            		<option>06</option>
	            		<option>07</option>
	            		<option>08</option>
	            		<option>09</option>
	            		<option>10</option>
	            		<option>11</option>
	            		<option>12</option>
	            		<option>13</option>
	            		<option>14</option>
	            		<option>15</option>
	            		<option>16</option>
	            		<option>17</option>
	            		<option>18</option>
	            		<option>19</option>
	            		<option>20</option>
	            		<option>21</option>
	            		<option>22</option>
	            		<option>23</option>
	            		<option>24</option>
	            		<option>25</option>
	            		<option>26</option>
	            		<option>27</option>
	            		<option>28</option>
	            		<option>29</option>
	            		<option>30</option>
	            	</select>
	            	 : 
	            	<select name="bStartM" id="b-start-m">
	            		<option>00</option>
	            		<option>10</option>
	            		<option>20</option>
	            		<option>30</option>
	            		<option>40</option>
	            		<option>50</option>
	            	</select> ~ 
	            	<select name="bEndH" id="b-end-h">
	            		<option>00</option>
	            		<option>01</option>
	            		<option>02</option>
	            		<option>03</option>
	            		<option>04</option>
	            		<option>05</option>
	            		<option>06</option>
	            		<option>07</option>
	            		<option>08</option>
	            		<option>09</option>
	            		<option>10</option>
	            		<option>11</option>
	            		<option>12</option>
	            		<option>13</option>
	            		<option>14</option>
	            		<option>15</option>
	            		<option>16</option>
	            		<option>17</option>
	            		<option>18</option>
	            		<option>19</option>
	            		<option>20</option>
	            		<option>21</option>
	            		<option>22</option>
	            		<option>23</option>
	            		<option>24</option>
	            		<option>25</option>
	            		<option>26</option>
	            		<option>27</option>
	            		<option>28</option>
	            		<option>29</option>
	            		<option>30</option>
	            	</select>
	            	 : 
	            	<select name="bEndM" id="b-end-m">
	            		<option>00</option>
	            		<option>10</option>
	            		<option>20</option>
	            		<option>30</option>
	            		<option>40</option>
	            		<option>50</option>
	            	</select><br>
	            	<input name="time_ect" id="time-ect" type="text" maxlength="20" placeholder="휴무일 및 영업시간 기타" value="${vo.close_ect }">
	            	<hr>
	            	테마1<br>
	            	<input name="theme1" class="theme-1" id="theme1-1" type="checkbox" value="아침 가능"><label for="theme1-1">아침 가능</label>
	            	<input name="theme1" class="theme-1" id="theme1-2" type="checkbox" value="점심 가능"><label for="theme1-2">점심 가능</label>
	            	<input name="theme1" class="theme-1" id="theme1-3" type="checkbox" value="저녁 가능"><label for="theme1-3">저녁 가능</label><br>
	            	<input name="theme1" class="theme-1" id="theme1-4" type="checkbox" value="포장가능"><label for="theme1-4">포장가능</label>
	            	<input name="theme1" class="theme-1" id="theme1-5" type="checkbox" value="방문 식사"><label for="theme1-5">방문 식사</label>
	            	<input name="theme1" class="theme-1" id="theme1-6" type="checkbox" value="주차 가능"><label for="theme1-6">주차 가능</label><br>
	            	<input name="theme1" class="theme-1" id="theme1-7" type="checkbox" value="좌식테이블"><label for="theme1-7">좌식테이블</label>
	            	<input name="theme1" class="theme-1" id="theme1-8" type="checkbox" value="베이비 시트"><label for="theme1-8">베이비 시트</label>
	            	<input name="theme1" class="theme-1" id="theme1-9" type="checkbox" value="혼밥/혼술"><label for="theme1-9">혼밥/혼술</label>
	            	<input name="theme1_ect" class="theme-1" id="theme1-10" type="text" placeholder="기타(직접입력)">
	            	<input name="parking" id="parking" type="text" placeholder="주차가능 차량 수" value="${vo.parking }"><br><br>
	            	테마2<br>
	            	<input name="theme2" class="theme-2" id="theme2-1" type="checkbox" value="유아직 제공"><label for="theme2-1">유아직 제공</label>
	            	<input name="theme2" class="theme-2" id="theme2-2" type="checkbox" value="엄청 매운집"><label for="theme2-2">엄청 매운집</label>
	            	<input name="theme2" class="theme-2" id="theme2-3" type="checkbox" value="양많은 집"><label for="theme2-3">양많은 집</label><br>
	            	<input name="theme2" class="theme-2" id="theme2-4" type="checkbox" value="안심식당"><label for="theme2-4">안심식당</label>
	            	<input name="theme2" class="theme-2" id="theme2-5" type="checkbox" value="할인"><label for="theme2-5">할인</label>
	            	<input name="theme2" class="theme-2" id="theme2-6" type="checkbox" value="웰빙 식당"><label for="theme2-6">웰빙 식당</label><br>
	            	<input name="theme2" class="theme-2" id="theme2-7" type="checkbox" value="이색컨셉"><label for="theme2-7">이색컨셉</label>
	            	<input name="theme2" class="theme-2" id="theme2-8" type="checkbox" value="방송출연식당"><label for="theme2-8">방송출연식당</label>
	            	<input name="theme2" class="theme-2" id="theme2-9" type="checkbox" value="데이트코스"><label for="theme2-9">데이트코스</label>
	            	<input name="theme2_ect" class="theme-2" id="theme2-10" type="text" placeholder="기타(직접입력)">
	            	<hr>
	            	업종&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;업태<br>
	            	<select name="kind" id="kind">
	            		<option>한식</option>
				        <option>탕류/건강식</option>
				        <option>중국</option>
				        <option>일식</option>
				        <option>서양식</option>
				        <option>외국음식점(태국,인도)</option>
				        <option>돈까스,회,일식</option>
				        <option>술집/소주방/호프</option>
				        <option>카페,디저트</option>
				        <option>레스토랑/뷔페식</option>
				        <option>고기집</option>
				        <option>치킨</option>
				        <option>분식</option>
				        <option>페스트푸드,피자</option>
				        <option>족발,보쌈</option>
				        <option>냉면집/면류</option>
				        <option>도시락/간단식</option>
				        <option>곱창(막창)</option>
				        <option>포장마차(실내,실외)</option>
				        <option>찻집</option>
				        <option>다방</option>
				        <option>아이스크림,팥빙수</option>
				        <option>제과제빵</option>
				        <option>고속도로</option>
				        <option>공항</option>
				        <option>극장</option>
				        <option>백화점</option>
				        <option>아이스크림</option>
				        <option>유원지</option>
				        <option>전통찻집</option>
				        <option>철도역구내(지하철)</option>
				        <option>푸드트럭</option>
				        <option>기타(직접입력)</option>
	            	</select>
	            	<select name="type" id="type">
	            		
	            	</select><br>
	            	<input name="kind_ect" id="cp-kind-ect" type="text" placeholder="업종 (직접입력)">
	            	<input name="type_ect" id="cp-type-ect" type="text" placeholder="업태 (직접입력)">
	            	<input name="intro" id="intro" type="text" maxlength="20" placeholder="소개" value="${vo.CP_intro }"><br>
	            	<hr>
	            	자유 이용권 할인<br>
	           		<input name="free_percent" type="number" placeholder="할인율을 입력하세요" value="${vo.cpPercentage }">%
	            	<hr>
	            	업체 노출<br>
	            	<input name="status" id="status-open" type="radio" value="open">
	            	<label for="status-open">Open</label>
	            	<input name="status" id="status-close" type="radio" value="close">
	            	<label for="status-close">Close</label>
	            	<br>
	            	<button onclick="infoSubmit()">저장</button>
	            </form>
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
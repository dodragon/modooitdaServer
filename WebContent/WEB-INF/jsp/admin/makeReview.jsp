<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="../../resources/webImages/favicon.ico">
<link
	href="<c:url value="http://192.168.0.11/baobab/resources/css/artDefault.css" />"
	rel="stylesheet">
<script
	src="<c:url value="http://192.168.0.11/baobab/resources/js/default.js"/>"
	type="text/javascript" /></script>
<title>리뷰 작성</title>
<style type="text/css">
#main_section>form {
	width: 62%;
	margin-left: 20%;
	margin-bottom: 50px;
	float: left;
	display: block;
}

#main_section>form textarea {
	width: 100%;
	height: 50vh;
	margin-top: 20px;
	padding: 15px;
	border: 3px solid #FF8224;
	border-radius: 30px;
	outline: none;
}

#main_section>form input, #main_section>form textarea {
	float: left;
	display: block;
}

input[type="button"], input[type="text"], input[type="file"] {
	border: 3px solid #FF8224;
	border-radius: 50px;
	margin-right: 20px;
	text-align: center;
	outline: none;
}

input[type="button"] {
	background-color: #FF8224;
	width: 50px;
	height: 30px;
	margin-top: 18px;
	color: white;
	cursor: pointer;
}

input[type="button"]:hover {
	background-color: white;
	color: black;
}

#submit {
	width: 10%;
	height: 3vh;
	margin-top: 25px;
	margin-left: 45%;
	background-color: #6799FF;
	color: white;
	font-size: 1.5em;
	border: 0px;
	border-radius: 30px;
	outline: none;
	float: left;
}

#submit:hover {
	border: 3px solid #6799FF;
	background-color: white;
	color: #6799FF;
	cursor: pointer;
}

#counter {
	background: rgba(255, 0, 0, 0.5);
	border-radius: 0.5em;
	padding: 0 .5em 0 .5em;
	font-size: 1em;
}

#img_layout {
	width: 850px;
	height: 0px;
	margin-top: 20px;
}

.img_div {
	width: 150px;
	height: 150px;
	margin-right: 20px;
	margin-bottom: 20px;
	border-radius: 2em;
	background-color: #f9f9f9;
	float: left;
}

#add_img_div {
	cursor: pointer;
}

#add_img {
	margin-top: 51px;
}

input[type="file"], input[type="text"] {
	width: 300px;
	height: 25px;
	margin-top: 20px;
}

.img_a {
	width: 150px;
	height: 150px;
	margin-right: 20px;
	margin-bottom: 20px;
	display: block;
	float: left;
}

.choose_img {
	width: 150px;
	height: 150px;
	border-radius: 2em;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
		var selectFiles;

		function cpSearch() {
			window.open('C:/Users/dohyeon/Desktop/바로가기/html/cpSearchPopup.html', '업체검색',
			'width=500px, height=600px, toolbars=no, scrollbars=no, top=150px, left=600px');
		}

		var sel_files = [];

		$('#file_chooser').change(function(evt) {
			handleImgsFilesSelect(evt);
		});

		function handleImgsFilesSelect(e) {
			sel_files = [];
			$('#img_layout').empty();
			var files = e.files;
			var filesArr = Array.prototype.slice.call(files);

			var index = 0;

			if(filesArr.length > 5){
				$('#img_layout').attr('style', "height:340px");
			}else if(filesArr.length <= 5 && filesArr.length > 0){
				$('#img_layout').attr('style', "height:170px");
			}else{
				$('#img_layout').attr('style', "height:0px");
			}

			if(filesArr.length > 9){
				alert("사진은 9개를 초과할 수 없습니다.");
		   		filesArr = [];
		   		files = [];
		   		sel_files = [];
		   		$("#file_chooser").val("");
		   		$('#img_layout').attr('style', "height:0px");
			}else{
				filesArr.forEach(function(f) {
			 		if(!f.type.match("image.*")){
			    		alert("확장자는 이미지 확장자만 가능합니다.");
			    		filesArr = [];
				   		files = [];
				   		sel_files = [];
				   		$("#file_chooser").val("");
				   		$('#img_layout').attr('style', "height:0px");
			    		return;
			   		}

			   		sel_files.push(f);

					var reader = new FileReader();
			   		reader.onload = function(e) {
				    	var html = "<a href=\"javascript:void(0);\" id=\"img_id_"+index+"\" class=\"img_a\"><img src=\"" + e.target.result +"\" data-file='"+f.name+"' class='choose_img' title='Click to remove'></a>";
				    	$("#img_layout").append(html);
				    	index++;
			    	}
					reader.readAsDataURL(f);
			    });
			}
 		}
	</script>
</head>
<body>
	<div>
		<div id="header">
			<ul>
				<li><a href="#" onclick="javascript:page_notice();">공지사항</a>
					<ul>
						<li><a class="small_menu" href="#">공지사항 작성</a></li>
					</ul></li>
				<li><a href="#" onclick="javascript:page_push();">푸시내역</a>
					<ul>
						<li><a class="small_menu"
							href="http://192.168.0.5/baobab/jsp/admin/pushInput.api">푸시작성</a></li>
					</ul></li>
				<li><a href="#" onclick="javascript:page_user();">회원정보</a></li>
				<li><a href="#" onclick="javascript:page_cp();">업체정보</a></li>
				<li><a href="#">결제내역</a></li>
				<li><a href="#" onclick="javascript:page_review();">리뷰조회</a>
					<ul>
						<li><a class="small_menu" href="#">리뷰작성</a></li>
					</ul></li>
				<li><a href="#">기타</a>
					<ul>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_visitant();">방문자 조회</a></li>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_search();">검색어 조회</a></li>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_cpPush();">사장님 푸시 조회</a></li>
						<li><a class="small_menu" href="#" onclick="hitsUp()">당일
								조회수 강제 초기화</a></li>
						<li><a class="small_menu" href="#"
							onclick="javascript:page_logHistory()">로그인 기록 조회</a></li>
						<li><a class="small_menu" href="#" onclick="version()">버전
								업데이트</a></li>
						<li><a class="small_menu" href="#" onclick="addrConversion()">경위도
								찾기</a></li>
						<li><a class="small_menu" href="#" onclick="checkServer()">점검
								수정</a></li>
					</ul></li>
			</ul>
		</div>
		<div id="section">
			<div id="article">
				<div id="main_article">
					<div>
						<a href="http://192.168.0.11/baobab/jsp/admin/main.api"> <img
							src="https://www.baobab858.com/resources/webImages/logo.png"
							alt="logo" title="logo">
						</a>
					</div>
					<div id="admin_session">
						<h1><%=session.getAttribute("department")%></h1>
						<h3><%=session.getAttribute("name")%>
							<%=session.getAttribute("jobClass")%>님
						</h3>
						<p>오늘도 즐거운 업무 되시길 바랍니다.</p>
					</div>
				</div>
				<div id="sub_article">
					<h1>최근 접속 내역</h1>
					<div>
						<c:forEach var="item" items="${loginHistory}" step="1" varStatus="status">
							<p class="history">${item}</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<div id="main_section">
				<h1>리뷰작성</h1>
				<form id="insert" action="#" method="post">
					<div id="img_layout"></div>
					<input id="file_chooser" type="file" name="img_file" accept="image/jpeg,image/png,image/webp" multiple="multiple" onchange="handleImgsFilesSelect(this)"> 
					<input type="text" name="nick_name" placeholder="닉네임" maxlength="20"> 
					<input type="text" name="cp_name" placeholder="업체명" readonly="readonly">
					<input type="hidden" name="email" value="<%=session.getAttribute("id")%>">
					<input type="text" name="menu_name" placeholder="선택메뉴" readonly="readonly"> <input type="button" value="검색" onclick="cpSearch()" />
					<textarea class="content" name="rev_content" cols="50" rows="16" style="resize: none" maxlength="180" placeholder="내용(180자 미만)"></textarea>
					<input id="submit" type="button" value="작성완료" onclick="insert()">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
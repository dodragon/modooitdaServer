<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.body {
	background: lightgray;
}

.contain {
	position: relative;
	width: 237px;
	height: 372px;
	background: white;
}

#gcDiv {
	height: 100px;
	position: absolute;
	width: 100px;
	top: 23%;
	left: 29%;
	margin: auto;
}
/*    	.qrbox{ */
/*    		position: absolute; */
/*    		width: 100px; */
/*    		height: 100px; */
/*    		background: coral; */
/*    		top: 23%; */
/*    		left: 27%; */
/*    		margin: auto; */
/*    	} */
table {
	width: 100%;
	height: 100%;
}

.footbox {
	position: absolute;
	width: 237px;
	height: 130px;
	bottom: 0px;
	background: #ff6a29;
}

.logobox {
	position: absolute;
	display: inline-block;
	width: 200px;
	height: 50px;
	top: 30%;
	left: 8%;
	background: #ff6a29;
}

.headbox {
	width: 237px;
	height: 1px;
}

.h1box {
	width: 237px;
	height: 60px;
	text-align: center;
}

#pdf_wrap {
	background-color: black;
	text-align: center;
}

#pdf_wrap>h1 {
	color: blue;
}

#pdf_wrap>h2 {
	color: yellow;
}
</style>
</head>
<body class="body">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
	<script type="text/javascript" src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="../resources/js/jquery.qrcode.js"></script>
	<script type="text/javascript" src="../resources/js/qrcode.js"></script>
	<script>
		window.onload = function() {
			jQuery("#gcDiv").qrcode({
				render : "table",
				text : "https://www.baobab858.com/",
				width : "100px",
				height : "100px"

			});
		}
			window.onload(function() {
				  //pdf_wrap을 canvas객체로 변환
				  html2canvas($('#pdf_wrap')[0]).then(function(canvas) {
				    var doc = new jsPDF('p', 'mm', 'a4'); //jspdf객체 생성
				    var imgData = canvas.toDataURL('image/png'); //캔버스를 이미지로 변환
				    doc.addImage(imgData, 'PNG', 0, 0); //이미지를 기반으로 pdf생성
				    doc.save('sample-file.pdf'); //pdf저장
				    
				  });
				});
	</script>
	<div id="pdf_wrap">
		<div class="contain">
			<div class="headbox"></div>
			<div class="h1box">
				<h2>cpName</h2>
			</div>
			<div id="gcDiv"></div>
			<div class="footbox">
				<div class="logobox">
					<img src="../resources/webImages/logo.png" width="200" height="50"
						alt="logoImg">
				</div>
			</div>
		</div>
	</div>
	<button id="create_pdf">
	      pdf 생성
	</button>
</body>
</html>


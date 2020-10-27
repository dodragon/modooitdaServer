<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#main_div {
	display: grid;
	grid-template-columns: auto auto auto;
	width: 210mm;
	height: 297mm;
	border: 1px solid black;
}

.container {
	width: 33%;
	height: 33%;
}

.item {
	width: 60mm;
	height: 91mm;
	border: 1px solid black;
	overflow: hidden;
}

h2 {
	width: 100%;
	text-align: center;
	font-size: 21px;
}

.qr {
	width: 45mm;
	height: 45mm;
}

.qr_div {
	width: 100%;
	height: 45mm;
	text-align: center;
}

.footer {
	width: 100%;
	height: 33%;
	background-color: #ff6a29 !important;
	text-align: center;
}

.logo {
	margin-top: 13%;
	width: 80%;
	height: 40%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
<script type="text/javascript">
	window.onload = function() {
		var str = '${str}';
		var secondArr = str.split(',');
		var ea = 0;

		for (var i = 0; i < secondArr.length; i++) {
			var thirdArr = secondArr[i].split('|');
			makeContent(thirdArr[2].replace('개', '') * 1, thirdArr[0],
					thirdArr[1]);
			ea += thirdArr[2].replace('개', '') * 1;
		}
		
		if(ea > 9){
			alert('총 수량을 9 이하로 맞추십시오.');
			history.back(-1);
		}
	}

	function makeContent(ea, name, seq) {
		var itemContainer = document.getElementById('main_div');
		var htmlText = itemContainer.innerHTML;
		for (var i = 0; i < ea; i++) {
			htmlText += '<div class="container">'
					+ '<div class="item">'
					+ '<h2>'
					+ name
					+ '</h2>'
					+ '<div class="qr_div">'
					+ '<img class="qr" alt="qr" src="https://baobabimage.cafe24.com/'
	          + 'cpQRcode/' + seq + '.png"/>'
					+ '</div>'
					+ '<div class="footer">'
					+ '<img class="logo" alt="logo" src="https://www.baobab858.com/resources/webImages/logo.png">'
					+ '</div>' + '</div>' + '</div>';
		}

		itemContainer.innerHTML = htmlText;
	}
</script>
</head>
<body>
	<div id="main_div"></div>
</body>
</html>
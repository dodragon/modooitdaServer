<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="qrcode.js"></script>
<script type="text/javascript">
	var qrcode = new QRCode(document.getElementById("qrcode"), {
		text : "http://web-inf.tistory.com/",
		width : 128,
		height : 128,
		colorDark : "#000000",
		colorLight : "#ffffff",
		correctLevel : QRCode.CorrectLevel.H
	});

	$("#qrcode > img").css({
		"margin" : "auto"
	});
</script>
<title>Insert title here</title>
</head>

<body>
	<div style="border: 2px solid #000; width: 500px">
		<div id="qrcode"></div>
	</div>
</body>

</html>
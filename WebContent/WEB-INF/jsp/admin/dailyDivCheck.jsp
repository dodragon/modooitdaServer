<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../resources/webImages/favicon.ico">
<title>모두잇다 관리자</title>
<script type="text/javascript">
	window.onload = function(){
		var result = ${result};
		var resultUrl = '';
		
		if(result == 0){
			window.location.href = './dailyDetail.api?seq=' + ${seq};
		}else{
			alert('권한이 없습니다.')
			window.history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>
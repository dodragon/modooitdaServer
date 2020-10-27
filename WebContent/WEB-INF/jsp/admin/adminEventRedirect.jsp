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
		var url = '${url}'
		var resultUrl = '';
		if(url == './cpDetail.api'){
			var action = '${action}';
			resultUrl = url + '?cpSeq=${seq}&result=-1';
			if(action == 'delete'){
				alert('${eventResult}개의 이벤트, ${optionResult}개의 옵션, ${menuResult}개의 메뉴가 삭제되었습니다.');
			}else{
				alert('${eventResult}개의 이벤트, ${optionResult}개의 옵션, ${menuResult}개의 메뉴가 생성되었습니다.');
			}
		}else if(url == './eventDetail.api'){
			resultUrl = url + '?serial=${serial}';
			if('${action}' == 'insert'){
				alert('${optionResult}개의 옵션, ${menuResult}개의 메뉴가 생성되었습니다.');
			}else{
				alert('${optionResult}개의 옵션, ${menuResult}개의 메뉴가 삭제되었습니다.');
			}
		}else if(url == './optionDetail.api'){
			resultUrl = url + '?serial=${serial}&cpSeq=${cpSeq}';
			if('${action}' == 'delete'){
				alert('${menuResult}개의 메뉴가 삭제되었습니다.');
			}else{
				alert('${menuResult}개의 메뉴가 생성되었습니다.');
			}
		}
		window.location.href = resultUrl;
	}
</script>
</head>
<body>

</body>
</html>
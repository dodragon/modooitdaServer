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
		if(url == './noticepage.api' || url == './eventPushList.api'){
			resultUrl = url + '?result=${result}';
		}else if(url == './noticeDetail.api' || url == './pushDetail.api' || url == './dailyDetail.api'){
			resultUrl = url + '?seq=${cpSeq}&result=${result}';
		}else if(url == './cpDetail.api'){
			resultUrl = url + '?cpSeq=${cpSeq}&result=${result}';
		}else if(url == './dailyReport.api'){
			resultUrl = url;
		}else if(url == './eventDetail.api'){
			resultUrl = url + '?serial=${serial}';
			var result = '${result}';
			if(result == 1){
				alert('수정이 완료되었습니다.');
			}else if(result == 0){
				alert('메인이 걸려있는 이벤트는 off할 수 없습니다.');
			}else if(result == -1){
				alert('모든 이벤트를 off할 수 없습니다.');
			}else{
				alert('수정에 실패하였습니다.');
			}
		}else if(url == './optionDetail.api'){
			resultUrl = url + '?serial=${serial}&cpSeq=${cpSeq}';
			var result = '${result}';
			if(result > 0){
				alert('수정이 완료되었습니다.');
			}else{
				alert('수정에 실패하였습니다.');
			}
		}else if(url == './eventMenuDetail.api'){
			resultUrl = url + '?seq=${seq}&cpSeq=${cpSeq}';
			var result = '${result}';
			if(result > 0){
				alert('수정이 완료되었습니다.');
			}else{
				alert('수정에 실패하였습니다.');
			}
		}else if(url == '관리자등록'){
			resultUrl = 'https://baobab858.com/jsp/admin.api';
			var result = '${result}';
			if(result == 1){
				alert('등록이 완료되었습니다.\n다시 로그인 하시면 관리자 페이지 이용이 가능합니다.');
			}else{
				alert('등록에 실패하였습니다.\n다시 시도해 주시기 바랍니다.');
			}
		}else if(url == '업체삭제'){
			resultUrl = './cpList.api';
			alert('${result}'.replace(/%%/gi, '\n'));
		}else if(url.indexOf('mlDetail') !== -1){
			resultUrl = url;
			var result = '${result}';
			if(result > 0){
				alert('수정이 완료 되었습니다.');
			}else{
				alert('수정에 실패 하였습니다.');
			}
		}else if(url == './listUpdate.api'){
			resultUrl = url;
			var result = '${result}';
			if(result > 0){
				alert('수정이 완료 되었습니다.');
			}else{
				alert('수정에 실패 하였습니다.');
			}
		}else if(url == '메인리스트 업체 저장' || url == '메인리스트 업체 삭제' || url == '메인리스트 업체 수정'){
			resultUrl = './mainListCp.api';
			var result = '${result}';
			if(url == '메인리스트 업체 저장'){
				if(result > 0){
					alert('저장이 완료 되었습니다.');
				}else{
					alert('저장에 실패 하였습니다.');
				}
			}else if(url == '메인리스트 업체 삭제'){
				if(result > 0){
					alert('삭제가 완료 되었습니다.');
				}else{
					alert('삭제에 실패 하였습니다.');
				}
			}else{
				if(result > 0){
					alert('수정이 완료 되었습니다.');
				}else{
					alert('수정에 실패 하였습니다.');
				}
			}
		}
		window.location.href = resultUrl;
	}
</script>
</head>
<body>

</body>
</html>
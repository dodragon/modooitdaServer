<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 결제완료</title>
<%
	String result = request.getParameter("PCD_PAY_RST");
	String msg = request.getParameter("PCD_PAY_MSG");
	String payerId = request.getParameter("PCD_PAYER_ID");
	
	String nextUrl = "";
	if(result.equals("success")){
		nextUrl = "https://www.baobab858.com/jsp/paySuccess.api";
	}else{
		nextUrl = "https://www.baobab858.com/jsp/payFail.api";
	}
%>
<script type="text/javascript">
	window.onload = function result(){
		document.getElementById("form").submit();
	}
</script>
</head>
<body>
	<form id="form" action="<%=nextUrl %>" method="post">
		<input type="hidden" id="tid" name="tid" value="<%=payerId%>" />
		<input type="hidden" id="msg" name="msg" value="<%=msg%>" />
	</form>
</body>
</body>
</html>
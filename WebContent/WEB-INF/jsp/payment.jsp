<%@page import="com.google.gson.Gson"%>
<%@page import="com.baobab.m.vo.PaymentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="https://www.baobab858.com/resources/webImages/favicon.ico">
	<%
		String userPhone = request.getParameter("userPhone");
		
		StringBuffer phone = new StringBuffer(userPhone);
		phone.insert(3, "-");
		phone.insert(8, "-");
		userPhone = phone.toString();
	%>
<script type="text/javascript">
	function emulAcceptCharset(form) {
		if (form.canHaveHTML) {
			document.charset = form.accept - charset;
		}
		return true;
	}

	window.onload = function cardPay() {
		document.getElementById("form").submit();
	}
</script>
<title>바오밥결제</title>
</head>
<body>
	<p>잠시만 기다려주세요..</p>
	<form id="form" action="https://mobile.inicis.com:8443/smart/wcard" accept-charset="euc-kr" 
		onsubmit="return validate(this) && emulAcceptCharset(this)" method="post">
		<input type="hidden" name="P_GOODS" value=<%=request.getParameter("goods")%> /> 
		<input type="hidden" name="P_MID" value="baobab858c" /> 
		<input type="hidden" name="P_AMT" value=<%=request.getParameter("totalDisPrice")%> /> 
		<input type="hidden" name="P_OID" value=<%=request.getParameter("orderNum")%> /> 
		<input type="hidden" name="P_MNAME" value=<%=request.getParameter("cpName")%>/>
		<input type="hidden" name="P_EMAIL" value=<%=request.getParameter("email")%> /> 
		<input type="hidden" name="P_MOBILE" value=<%=userPhone %>/>
		<input type="hidden" name="P_NEXT_URL" value="https://www.baobab858.com/jsp/payNext.api" /> 
		<input type="hidden" name="P_NOTI_URL" value="https://www.baobab858.com/jsp/payNext.api" /> 
		<input type="hidden" name="P_RETURN_URL" value="https://www.baobab858.com/jsp/payReturn.api" />
		<input type="hidden" name="P_RESERVED" id="reserved" value="twotrs_isp=Y&block_isp=Y&twotrs_isp_noti=N&apprun_check=Y&below1000=Y"> 
	</form>
</body>
</html>
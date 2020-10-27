<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.setCharacterEncoding("utf-8");

String nextUrl = "";
String tid = "";
String msg = request.getParameter("P_RMESG1");
String status = request.getParameter("P_STATUS");
if(status.equals("00")){
	nextUrl = "https://www.baobab858.com/jsp/paySuccess.api";
	tid = request.getParameter("P_TID");
}else{
	nextUrl = "https://www.baobab858.com/jsp/payFail.api";
}
%>
<link rel="shortcut icon" href="https://www.baobab858.com/resources/webImages/favicon.ico">
<title>바오밥 결제완료</title>
<script type="text/javascript">
	window.onload = function result(){
		document.getElementById("form").submit();
	}
</script>
</head>
<body>
	<form id="form" action="<%=nextUrl %>" method="post">
		<input type="hidden" id="tid" name="tid" value="<%=tid%>" />
		<input type="hidden" id="msg" name="msg" value="<%=msg%>" />
	</form>
</body>
</html>
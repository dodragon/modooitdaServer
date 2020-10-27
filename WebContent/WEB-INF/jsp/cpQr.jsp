<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>바오밥</title>
<style type="text/css">
	a{
		display : none;
	}
</style>
</head>
<script type="text/javascript">
	window.onload = function(){
		document.getElementById("aTag").click();
	}
</script>
<body>
<%
	String cpSeq = request.getParameter("cpSeq");
	String url = "https://baobab.page.link/?link=https://baobab858.com/jsp/cpQr.api?cpSeq=" + cpSeq + "&apn=com.baobab.user.baobabflyer&ibi=wedaehan.Baobab";
%>
	<a id="aTag" href="<%=url %>"></a>
</body>
</html>
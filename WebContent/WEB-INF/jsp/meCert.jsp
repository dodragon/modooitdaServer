<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma","no-cache");			// HTTP1.0 캐쉬 방지
	response.setDateHeader("Expires",0);				// proxy 서버의 캐쉬 방지
	response.setHeader("Pragma", "no-store");			// HTTP1.1 캐쉬 방지
	if(request.getProtocol().equals("HTTP/1.1"))
			response.setHeader("Cache-Control", "no-cache"); // HTTP1.1 캐쉬 방지
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	form{
		display: none;
	}
</style>
<title>바오밥 본인확인</title>
<%
	String cpId = "WDHM1001";
	String urlCode = "002002";
	String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	String certNum = "C" + date + request.getParameter("ranNum");
	String certMet = "M";
	String extandVar = "0000000000000000";
	
	String email = request.getParameter("email");
	String password = request.getParameter("pw");
	String pushAgree = request.getParameter("push");
	String kind = request.getParameter("kind");
	
	session.setAttribute("joinEmail", email);
	session.setAttribute("joinPw", password);
	session.setAttribute("joinPush", pushAgree);
	session.setAttribute("kind", kind);
	
	if(kind.equals("Mjoin") || kind.equals("join")){
		session.setAttribute("nickName", request.getParameter("nickName"));
	}else{
		session.setAttribute("nickName", request.getParameter("email"));
	}
	
	String query = cpId + "/" + urlCode + "/" + certNum + "/" + date + "/" + certMet + "///////" + 
		request.getParameter("email") + "/" + extandVar;
	
	com.icert.comm.secu.IcertSecuManager seed  = new com.icert.comm.secu.IcertSecuManager();
	String enc_tr_cert = seed.getEnc(query, "");
	String hmacMsg = seed.getMsg(enc_tr_cert);
	
	String tr_cert = seed.getEnc(enc_tr_cert + "/" + hmacMsg + "/" + extandVar, "");
%>
<script type="text/javascript">
window.onload = function() {
	document.getElementById('frm').submit();
}
</script>
</head>
<body>
	<form id="frm" name="frm" method="POST" target="KMCISWindow" action="https://www.kmcert.com/kmcis/web/kmcisReq.jsp">
		<input type = "hidden"  name="tr_cert"  value="<%=tr_cert%>" />
		<input type = "hidden"  name="tr_url"  value="https://baobab858.com/jsp/meCertResult.api" />
		<input type = "hidden"  name="tr_add"  value="N" />
	</form>
</body>
</html>
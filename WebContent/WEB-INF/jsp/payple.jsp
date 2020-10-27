<%@page import="com.google.gson.Gson"%>
<%@page import="com.baobab.m.vo.PaypleMCertVO"%>
<%@page import="com.baobab.m.service.payple.PaypleServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>바오밥 간편결제</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cpay.payple.kr/js/cpay.payple.1.0.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	var pay_work = "<%=request.getParameter("pay_work") %>";
    var payple_payer_id = "<%=request.getParameter("payer_id") %>";
    var buyer_hp = "<%=request.getParameter("buyer_hp")%>";
    var buyer_email = "<%=request.getParameter("buyer_email")%>";
    var buy_goods = "<%=request.getParameter("buy_goods")%>";
    var buy_total = "<%=request.getParameter("buy_total")%>";
    var order_num = "<%=request.getParameter("order_num")%>";
    var is_taxsave = "<%=request.getParameter("is_taxsave")%>";
    var simple_flag = "<%=request.getParameter("is_simple") %>";
	
    var obj = new Object();

	//#########################################################################################################################################################################
	/*
	 * DEFAULT SET 1
	 */
	 		
	//-- 소스상에 표시하지 마시고 반드시 Server Side Script 를 이용하여 불러오시기 바랍니다. --//
	obj.PCD_CST_ID = '<%="thegreat"%>';
	obj.PCD_CUST_KEY = '<%="671e687153f42d0b0bf44f003fbdaf684e0ba7cb8895d4fa0479c6d8accd5200"%>';
	obj.PCD_AUTH_URL = '<%="https://cpay.payple.kr/php/auth.php"%>';
	
	//#########################################################################################################################################################################

	obj.PCD_CPAY_VER = "1.0.1";    // (필수) 결제창 버전
	obj.PCD_PAY_TYPE = 'transfer'; // (필수) 결제 수단 

	//#########################################################################################################################################################################
	<%
		PaypleServiceImpl service = new PaypleServiceImpl();
	 	String data = service.marchantCert(0);
		System.out.println(data);
		PaypleMCertVO mCert = new Gson().fromJson(data, PaypleMCertVO.class);
	%>
	/*
	 * 1. 결제자 인증 
	 * PCD_PAY_WORK : AUTH
	 */
	 	if (pay_work == 'AUTH') {
	 		obj.PCD_PAY_WORK = 'AUTH';          // (필수) 결제요청 업무구분 (AUTH : 본인인증+계좌등록, CERT: 본인인증+계좌등록+결제요청등록(최종 결제승인요청 필요), PAY: 본인인증+계좌등록+결제완료)
			obj.PCD_PAYER_NO = simple_flag;        // (선택) 가맹점 회원 고유번호 (결과전송 시 입력값 그대로 RETURN)
			obj.PCD_PAYER_HP = buyer_hp;        // (선택) 결제자 휴대폰 번호
			obj.PCD_PAYER_EMAIL = buyer_email;  // (선택) 결제자 Email
			obj.PCD_SIMPLE_FLAG = simple_flag;  // (선택) 간편결제 여부 (Y|N)
	 	}
	
	/*
	 * 2. 결제자 인증 후 결제
	 * PCD_PAY_WORK : CERT | PAY
	 */

		//## 2.1 최초결제 및 단건(일반,비회원)결제
		if (pay_work != 'AUTH') {
			if (simple_flag != 'Y' || payple_payer_id == '') {
				obj.PCD_PAY_WORK = 'PAY';           // (필수) 결제요청 업무구분 (AUTH : 본인인증+계좌등록, CERT: 본인인증+계좌등록+결제요청등록(최종 결제승인요청 필요), PAY: 본인인증+계좌등록+결제완료)
				obj.PCD_PAYER_NO = simple_flag;        // (선택) 가맹점 회원 고유번호 (결과전송 시 입력값 그대로 RETURN)
				obj.PCD_PAYER_HP = buyer_hp;         // (선택) 결제자 휴대폰 번호
				obj.PCD_PAYER_EMAIL = buyer_email;   // (선택) 결제자 Email
				obj.PCD_PAY_GOODS = buy_goods;       // (필수) 결제 상품
				obj.PCD_PAY_TOTAL = buy_total;       // (필수) 결제 금액
				obj.PCD_PAY_OID = order_num;         // 주문번호 (미입력 시 임의 생성)
				obj.PCD_TAXSAVE_FLAG = is_taxsave;   // (선택) 현금영수증 발행 여부 (Y|N)
			}
			//## 2.2 간편결제 (재결제)
			if (simple_flag == 'Y' && payple_payer_id != '') {
				obj.PCD_PAY_WORK = 'PAY';            // (필수) 결제요청 업무구분 (AUTH : 본인인증+계좌등록, CERT: 본인인증+계좌등록+결제요청등록(최종 결제승인요청 필요), PAY: 본인인증+계좌등록+결제완료)				
				obj.PCD_SIMPLE_FLAG = 'Y';            // 간편결제 여부 (Y|N)
				//-- PCD_PAYER_ID 는 소스상에 표시하지 마시고 반드시 Server Side Script 를 이용하여 불러오시기 바랍니다. --//		
				obj.PCD_PAYER_ID = payple_payer_id;   // 결제자 고유ID (본인인증 된 결제회원 고유 KEY)
				//-------------------------------------------------------------------------------------//
				obj.PCD_PAYER_NO = simple_flag;        // (선택) 가맹점 회원 고유번호 (결과전송 시 입력값 그대로 RETURN)
				obj.PCD_PAY_GOODS = buy_goods;        // (필수) 결제 상품
				obj.PCD_PAY_TOTAL = buy_total;        // (필수) 결제 금액
				obj.PCD_PAY_OID = order_num;          // 주문번호 (미입력 시 임의 생성)
				obj.PCD_TAXSAVE_FLAG = is_taxsave;    // (선택) 현금영수증 발행 여부 (Y|N)
			}
		}
	//#########################################################################################################################################################################


	/*
	 * DEFAULT SET 2
	 */
	obj.PCD_PAYER_AUTHTYPE = 'pwd';                  // (선택) [간편결제/정기결제] 본인인증 방식
	obj.PCD_RST_URL = 'https://baobab858.com/jsp/paypleResult.api';          // (필수) 결제(요청)결과 RETURN URL

	PaypleCpayAuthCheck(obj);
});
</script>
</head>
<body>
	<p>잠시만 기다려주세요..</p>
</body>
</html>
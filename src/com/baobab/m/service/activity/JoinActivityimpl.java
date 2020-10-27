package com.baobab.m.service.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.dao.join.CPJoinDAO;
import com.baobab.m.service.license.LicenseUpload;
@Service
public class JoinActivityimpl implements JoinActivity {
	
	@Autowired
	CPJoinDAO cpJdao;
	@Autowired
	LicenseUpload licUpload;
	@Override
	public void joins(MultipartHttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phonNum = request.getParameter("phonNum");
		String cpName = request.getParameter("cpName");
		String cpLicenseNum = request.getParameter("cpLicenseNum");
		String cpPhon = request.getParameter("cpPhon");
		String cpZipcode = request.getParameter("cpZipcode");
		String cpAddress = request.getParameter("cpAddress");
		String cpAddrDetails = request.getParameter("cpAddrDetails");
		String cpKind = request.getParameter("cpKind");
		String cpType = request.getParameter("cpType");
		String cpTheme1 = request.getParameter("cpTheme1");
		String cpTheme2 = request.getParameter("cpTheme2");
		String parking = request.getParameter("parking");
		String closeDay = request.getParameter("closeDay");
		String closeEct = request.getParameter("close_ect");
		String businessStart = request.getParameter("businessStart");
		String businessEnd = request.getParameter("businessEnd");
		MultipartFile license = request.getFile("upload");
		String cpIntro = request.getParameter("cpIntro");
		String bank = request.getParameter("bank");
		String accountHolder = request.getParameter("accountHolder");
		String accountNumber = request.getParameter("accountNumber");
		String divCode = "c-01-01";
		String pushCheck = request.getParameter("pushCheck");
		String cpDiv = request.getParameter("cpDiv");
		
		System.out.println(password);
		
		cpJdao.cpUserAllJoin(email, password, phonNum, divCode, pushCheck);
		cpJdao.UserHistoryJoin(email, divCode);
		cpJdao.cpUserJoin(email, cpName, licUpload.licenseSaveToServer(license, email), cpLicenseNum, bank, accountHolder, accountNumber);
		cpJdao.cpJoin(cpName, cpPhon, cpZipcode, cpAddress, cpAddrDetails, cpKind, cpType, cpTheme1, cpTheme2, parking, closeDay, businessStart,
				businessEnd, cpIntro, cpDiv, closeEct, email, phonNum, accountHolder);
		cpJdao.cpHistoryJoin(cpName);
		System.out.println("이메일 : " + email + ", 업체명 : " + cpName + " : 회원가입 완료");
	}

	
	
}

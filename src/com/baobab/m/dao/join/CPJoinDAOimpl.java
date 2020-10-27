package com.baobab.m.dao.join;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.baobab.m.dao.cpfunction.CpStaffDAO;
import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.service.geo.NaverGeoCoding;
import com.baobab.m.service.license.LicenseUpload;
import com.baobab.m.vo.BasketVO;
import com.baobab.m.vo.CPHistoryVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.CPUseVO;
import com.baobab.m.vo.CPUserVO;
import com.baobab.m.vo.CpStaffVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.NaverGeocodingVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.PokeVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Repository
public class CPJoinDAOimpl implements CPJoinDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate join;
	@Autowired
	private LicenseUpload licenseUpload;
	@Autowired
	private CpStaffDAO staff;

	@Override
	public void cpUserAllJoin(String email, String password, String phonNum, String divCode, String pushCheck) {		
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setUser_password(password);
		vo.setPhon_num(phonNum);
		vo.setDiv_code(divCode);
		vo.setPush_agree(pushCheck);
		join.update("com.baobab.m.dao.CPJoinMapper.cpUserAllJoin", vo);
	}

	@Override
	public void UserHistoryJoin(String email, String divCode) {
		UserHistoryVO vo = new UserHistoryVO();
		vo.setEmail(email);
		vo.setDiv_code(divCode);
		join.update("com.baobab.m.dao.CPJoinMapper.userHistoryJoin", vo);
	}

	@Override
	public void cpUserJoin(String email, String cpName, String license, String cpLicenseNum, String bank, String accountHolder, 
			String accountNumber) throws FileNotFoundException, NullPointerException, IOException {		
		CPUserVO vo = new CPUserVO();
		vo.setEmail(email);
		vo.setCpName(cpName);
		vo.setLicense(license);
		vo.setCpLicenseNum(cpLicenseNum);
		vo.setBank(bank);
		vo.setAccount_holder(accountHolder);
		vo.setAccountNumber(accountNumber);
		join.update("com.baobab.m.dao.CPJoinMapper.cpUserJoin", vo);
	}

	@Override
	public void cpJoin(String cpName, String cpPhon, String cpZipcode, String cpAddress, String cpAddrDetails, String cpKind, String cpType, 
			String cpTheme1, String cpTheme2, String parking, String closeDay, String businessStart, String businessEnd, String cpIntro, String cpDiv, 
			String closeEct, String email, String phone, String name) {
		CPInfoVO vo = new CPInfoVO();
		NaverGeocodingVO ngvo = new NaverGeoCoding().trans(cpAddress + " " + cpAddrDetails);
		String x = "";
		String y = "";
		try {
			x = ngvo.getAddresses().get(0).getX();
			y = ngvo.getAddresses().get(0).getY();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("지오코딩 적용 안됨 주소 재확인 필요");
			x = "0";
			y = "0";
		}finally {
			System.out.println("1번 : " + x);
			System.out.println("2번 : " + y);
			vo.setCP_name(cpName);
			vo.setCP_phon(cpPhon);
			vo.setCP_zipcode(cpZipcode);
			vo.setCP_address(cpAddress);
			vo.setCP_addr_details(cpAddrDetails);
			vo.setCP_kind(cpKind);
			vo.setCP_type(cpType);
			vo.setCP_Theme1(cpTheme1);
			vo.setCP_Theme2(cpTheme2);
			vo.setParking(parking);
			vo.setClose_day(makeCloseDay2(makeCloseDay(closeDay)));
			vo.setClose_ect(closeEct);
			vo.setBusiness_start(businessStart);
			vo.setBusiness_end(businessEnd);
			vo.setCP_intro(cpIntro);
			vo.setCp_div(cpDiv);
			vo.setLongitude(Double.parseDouble(x));
			vo.setLatitude(Double.parseDouble(y));
			vo.setOwner_email(email);
			int result = join.update("com.baobab.m.dao.CPJoinMapper.cpJoin", vo);
			if(result > 0) {
				CpStaffVO cvo = new CpStaffVO();
				cvo.setEmail(email);
				cvo.setStaffPhone(phone);
				cvo.setStaffName(name);
				cvo.setDivCode("c-01-01");
				cvo.setCpSeq(staff.getMySeq(email));
				join.insert("com.baobab.m.dao.CpStaffMapper.staffInfoInsert", cvo);
			}
		}
	}

	@Override
	public void cpHistoryJoin(String cpName) {
		CPHistoryVO vo = new CPHistoryVO();
		vo.setCpName(cpName);
		System.out.println(vo.toString());
		join.update("com.baobab.m.dao.CPJoinMapper.cpHistoryJoin", vo);
	}

	@Override
	public void cpUpdate(HttpServletRequest request) {
		CPInfoVO vo = new CPInfoVO();
		FtpClient ftp = new FtpClient();
		NaverGeocodingVO ngvo = new NaverGeoCoding().trans(request.getParameter("addr") + " " + request.getParameter("addrDetail"));
		vo.setCP_name(request.getParameter("cpName"));
		vo.setCP_phon(request.getParameter("cpPhone"));
		vo.setCP_zipcode(request.getParameter("zipcode"));
		vo.setCP_address(request.getParameter("addr"));
		vo.setCP_addr_details(request.getParameter("addrDetail"));
		vo.setBusiness_start(request.getParameter("busyStart"));
		vo.setBusiness_end(request.getParameter("busyEnd"));
		vo.setParking(request.getParameter("parking"));
		vo.setCP_intro(request.getParameter("intro"));
		vo.setClose_day(makeCloseDay2(makeCloseDay(request.getParameter("closeDay"))));
		vo.setClose_ect(request.getParameter("close_ect"));
		vo.setCP_Theme1(request.getParameter("theme1"));
		vo.setCP_Theme2(request.getParameter("theme2"));
		vo.setCP_kind(request.getParameter("kind"));
		vo.setCP_type(request.getParameter("type"));
		vo.setSeq_num(Integer.parseInt(request.getParameter("num")));
		vo.setLongitude(Double.parseDouble(ngvo.getAddresses().get(0).getX()));
		vo.setLatitude(Double.parseDouble(ngvo.getAddresses().get(0).getY()));
		join.update("com.baobab.m.dao.CPJoinMapper.cpUpdate", vo);
		cpUserUpdate(request.getParameter("email"), request.getParameter("cpName"));
		List<MenuVO> menus = getMenu(Integer.parseInt(request.getParameter("num")));
		if(menus.size() != 0) {
			String beforeName = menus.get(0).getCp_name();
			for(int i=0;i<menus.size();i++) {
				if(menus.get(i).getMenu_img().startsWith("http")) {
					updateMenu(request.getParameter("cpName"), ftp.renameFile("/baobabMenus/", beforeName + "-" + menus.get(i).getMenu_name()
							+ ".png", request.getParameter("cpName") + "-" + menus.get(i).getMenu_name() + ".png"), menus.get(i).getMenu_name(), 
							Integer.parseInt(request.getParameter("num")));
				}
			}
		}
		cpHistoryJoin(request.getParameter("cpName"));
		updateBasket(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
		updatePayment(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
		updatePoke(request.getParameter("cpName"), Integer.parseInt(request.getParameter("num")));
	}
	
	public String minute(String endM) {
		if(endM.equals("0")) {
			return "00";
		}else {
			return endM;
		}
	}

	@Override
	public void divCodeChange(String email) {
		join.update("com.baobab.m.dao.CPJoinMapper.divCodeChange", email);
	}

	@Override
	public String dupName(String cpName) {
		List<String> result = join.selectList("com.baobab.m.dao.CPJoinMapper.dupName", cpName);
		if(result.size() == 0) {
			return "ok";
		}else {
			return "dup";
		}
	}

	@Override
	public void cpUserUpdate(String email, String cpName) {
		CPUserVO vo = new CPUserVO();
		vo.setEmail(email);
		vo.setCpName(cpName);
		join.update("com.baobab.m.dao.CPJoinMapper.cpUserUpdate", vo);
	}

	@Override
	public List<MenuVO> getMenu(int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_seq(cpSeq);
		return join.selectList("com.baobab.m.dao.CPJoinMapper.getMenu", vo);
	}

	@Override
	public void updateMenu(String cpName, String menuImg, String menuName, int cpSeq) {
		MenuVO vo = new MenuVO();
		vo.setCp_name(cpName);
		vo.setMenu_img(menuImg);
		vo.setMenu_name(menuName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updateMenu", vo);
	}
	
	public String renameRevImg(String cpName, String beforeName, String imgUrl) {
		if(imgUrl.startsWith("http")) {
			String imgName = imgUrl.split("/")[imgUrl.split("/").length - 1];
			String newName = cpName + imgName.substring(beforeName.length());
			FtpClient ftp = new FtpClient();
			return ftp.renameFile("/ourReviews/", imgName, newName);
		}else {
			return "이미지없음";
		}
	}

	@Override
	public CPInfoVO getCpInfo(int cpSeq) {
		CPInfoVO vo = new CPInfoVO();
		vo.setSeq_num(cpSeq);
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.getCpInfo", vo);
	}

	@Override
	public void updateBasket(String cpName, int cpSeq) {
		BasketVO vo = new BasketVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updateBasket", vo);
	}

	@Override
	public void updatePayment(String cpName, int cpSeq) {
		PaymentVO vo = new PaymentVO();
		vo.setCpName(cpName);
		vo.setCpSeq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updatePayment", vo);
	}

	@Override
	public void updatePoke(String cpName, int cpSeq) {
		PokeVO vo = new PokeVO();
		vo.setCp_name(cpName);
		vo.setCp_seq(cpSeq);
		join.update("com.baobab.m.dao.CPJoinMapper.updatePoke", vo);
	}
	
	public String makeCloseDay2(String str) {
		System.out.println("요일 결과 값 : " + str);
		if((str.equals("무"))) {
			return "~~~~~무";
		}else {
			return str;
		}
	}
	
	public String makeCloseDay(String str) {
		System.out.println("요일 결과 값 : " + str);
		if((str.lastIndexOf("~") + 1) == str.length()) {
			return str + "무";
		}else {
			return str;
		}
	}

	@Override
	public CPUserVO getCpUserInfo(String email) {
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.getCpUserInfo", email);
	}
	
	@Override
	public CPUseVO cpUserInfo(String email) {
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.cpUserInfo", email);
	}

	@Override
	public int changeCpUser(String email, String licenseNum, String accHolder, String bank, String accNum, MultipartFile license) throws Exception {
		CPUseVO vo = new CPUseVO();
		vo.setEmail(email);
		vo.setCP_license_num(licenseNum);
		vo.setCP_license(licenseUpload.licenseSaveToServer(license, email));
		vo.setBank(bank);
		vo.setAccount_holder(accHolder);
		vo.setAccount_number(accNum);

		return join.update("com.baobab.m.dao.CPJoinMapper.changeCpUser", vo);
		
	}

	@Override
	public List<CPInfoVO> getQRCode(String email) {
		return join.selectList("com.baobab.m.dao.CPJoinMapper.getQRCode", email);
	}

	@Override
	public int updateCpPw(HttpServletRequest request) {
		CPUseVO vo = new CPUseVO();
		vo.setCpPw(request.getParameter("pw"));
		vo.setEmail(request.getParameter("email"));
		return join.update("com.baobab.m.dao.QRCodeMapper.updateCpPw", vo);
	}

	@Override
	public int setOnOffCp(String ownerEmail, String cpName, String status) {
		CPInfoVO vo = new CPInfoVO();
		vo.setOwner_email(ownerEmail);
		vo.setCP_name(cpName);
		vo.setCpStatus(status);
		return join.update("com.baobab.m.dao.CPJoinMapper.setOnOffCp", vo);
	}

	@Override
	public String selectCpStatus(String ownerEmail, String cpName) {
		CPInfoVO vo = new CPInfoVO();
		vo.setOwner_email(ownerEmail);
		vo.setCP_name(cpName);
		return join.selectOne("com.baobab.m.dao.CPJoinMapper.selectCpStatus", vo);
	}
}

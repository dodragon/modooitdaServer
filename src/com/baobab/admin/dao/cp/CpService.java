package com.baobab.admin.dao.cp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.service.geo.NaverGeoCoding;
import com.baobab.m.vo.AdminCpDetailVO;
import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.EventCpOptionVO;
import com.baobab.m.vo.EventCpVO;
import com.baobab.m.vo.NaverGeocodingVO;
import com.baobab.m.vo.ReviewsVO;

@Service
public class CpService {
	
	@Autowired
	CpDAO dao;
	@Autowired
	CpDeleteDAO delDao;
	
	public AdminCpDetailVO getVo(int cpSeq) {
		AdminCpDetailVO vo = new AdminCpDetailVO();
		
		CPInfoVO infoVo = dao.defaultInfo(cpSeq);
		infoVo.setClose_day(closeDay(infoVo.getClose_day()));
		infoVo.setCP_phon(makePhoneNum(infoVo.getCP_phon()));
		System.out.println(infoVo.getBusiness_start());
		System.out.println(infoVo.getBusiness_end());
		vo.setDefaultVo(infoVo);
		vo.setStaffs(dao.staffInfo(cpSeq));
		vo.setHits(dao.hits(cpSeq));
		vo.setImgs(dao.mainImage(cpSeq));
		vo.setEvents(dao.events(cpSeq));
		vo.setMenus(dao.defaultMenu(cpSeq));
		vo.setSales(dao.sales(cpSeq));
		
		List<ReviewsVO> revList = dao.reivews(cpSeq);
		for(int i=0;i<revList.size();i++) {
			revList.get(i).setImgList(dao.revImages(revList.get(i).getRevCode()));
		}
		vo.setRevs(revList);
		
		return vo;
	}
	
	public EventCpVO getEvent(String serial) {
		EventCpVO vo = dao.oneEvent(serial);
		List<EventCpOptionVO> optionList = dao.options(serial);
		
		for(int i=0;i<optionList.size();i++) {
			List<EventCpMenuVO> menuList = dao.menus(optionList.get(i).getOptionSerial());
			optionList.get(i).setMenuList(menuList);
		}
		
		vo.setOptionList(optionList);
		return vo;
	}
	
	public EventCpOptionVO getOption(String serial) {
		EventCpOptionVO vo = dao.oneOption(serial);
		vo.setMenuList(dao.menus(vo.getOptionSerial()));
		return vo;
	}
	
	public int infoUpdate(HttpServletRequest request) {
		CPInfoVO vo = new CPInfoVO();
		vo.setSeq_num(Integer.parseInt(request.getParameter("cpSeq")));
		vo.setCP_name(request.getParameter("cpName"));
		vo.setCP_phon(request.getParameter("cpPhone"));
		vo.setCP_address(request.getParameter("cpAddr"));
		vo.setCP_addr_details(request.getParameter("cpAddrDetail"));
		vo.setCP_zipcode(request.getParameter("zipcode"));
		vo.setClose_day(makeCloseDay(request.getParameterValues("first_week"), request.getParameterValues("second_week"), request.getParameterValues("third_week")
				, request.getParameterValues("fourth_week"), request.getParameterValues("fifth_week")));
		vo.setBusiness_start(request.getParameter("bStartH") + ":" + request.getParameter("bStartM"));
		vo.setBusiness_end(request.getParameter("bEndH") + ":" + request.getParameter("bEndM"));
		vo.setClose_ect(request.getParameter("time_ect"));
		vo.setCP_Theme1(makeTheme(request.getParameterValues("theme1"), request.getParameter("theme1_ect")));
		vo.setCP_Theme2(makeTheme(request.getParameterValues("theme2"), request.getParameter("theme2_ect")));
		vo.setCP_kind(makeKindOrType(request.getParameter("kind"), request.getParameter("kind_ect")));
		vo.setCP_type(makeKindOrType(request.getParameter("type"), request.getParameter("type_ect")));
		vo.setCP_intro(request.getParameter("intro"));
		vo.setCpPercentage(Double.parseDouble(request.getParameter("free_percent")));
		vo.setCpStatus(request.getParameter("status"));
		
		NaverGeocodingVO ngvo = new NaverGeoCoding().trans(request.getParameter("cpAddr") + " " + request.getParameter("cpAddrDetail"));
		vo.setLongitude(Double.parseDouble(ngvo.getAddresses().get(0).getX()));
		vo.setLatitude(Double.parseDouble(ngvo.getAddresses().get(0).getY()));
		
		return dao.infoUpdate(vo);
	}
	
	private String makePhoneNum(String phoneNum) {
		StringBuffer sb = new StringBuffer(phoneNum);
		sb.insert(3, "-");
		sb.insert(sb.length() - 4, "-");
		return sb.toString();
	}
	
	private String closeDay(String close) {
		if(close.equals("~~~~~무")) {
			return "휴무없음";
		}else {
			String[] closeArr = close.split("~");
			String result = "";
			for(int i=0;i<closeArr.length-1;i++) {
				result += "(" + (i+1) + "째주 : " + closeArr[i] + ")";
				if(i<closeArr.length - 2) {
					result += ", ";
				}
			}
			return result;
		}
	}
	
	private String makeCloseDay(String[] first, String[] second, String[] third, String[] fourth, String[] fifth) {
		try {
			if(first.length == 0 && second.length == 0 && third.length == 0 && fourth.length == 0 && fifth.length == 0) {
				return "~~~~~무";
			}else {
				String closeStr = "";
				closeStr = arrToStr(first) + "~" + arrToStr(second) + "~" + arrToStr(third) + "~" + arrToStr(fourth) + "~" + arrToStr(fifth);
				return closeStr + lastCloseDay(first, second, third, fourth, fifth);
			}
		}catch(NullPointerException e) {
			return "~~~~~무";
		}
	}
	
	private String arrToStr(String[] arr) {
		String result = "";
		if(arr != null) {
			for(int i=0;i<arr.length;i++) {
				result += arr[i];
				if(i != arr.length - 1) {
					result += ",";
				}
			}
		}
		return result;
	}
	
	private String lastCloseDay(String[] first, String[] second, String[] third, String[] fourth, String[] fifth) {
		String allStr = "";
		if(first != null) {
			allStr += first.toString();
		}
		if(second != null) {
			allStr += second.toString();
		}
		if(third != null) {
			allStr += third.toString();
		}
		if(fourth != null) {
			allStr += fourth.toString();
		}
		if(fifth != null) {
			allStr += fifth.toString();
		}
		
		
		int monCount = StringUtils.countOccurrencesOf(allStr, "월");
		int tueCount = StringUtils.countOccurrencesOf(allStr, "화");
		int wedCount = StringUtils.countOccurrencesOf(allStr, "수");
		int thuCount = StringUtils.countOccurrencesOf(allStr, "목");
		int friCount = StringUtils.countOccurrencesOf(allStr, "금");
		int satCount = StringUtils.countOccurrencesOf(allStr, "토");
		int sunCount = StringUtils.countOccurrencesOf(allStr, "일");
		
		String result = "~";
		if(monCount == 5) {
			if(result.length() == 1) {
				result += "월";
			}else {
				result += ",월";
			}
		}
		if(tueCount == 5) {
			if(result.length() == 1) {
				result += "화";
			}else {
				result += ",화";
			}
		}
		if(wedCount == 5) {
			if(result.length() == 1) {
				result += "수";
			}else {
				result += ",수";
			}
		}
		if(thuCount == 5) {
			if(result.length() == 1) {
				result += "목";
			}else {
				result += ",목";
			}
		}
		if(friCount == 5) {
			if(result.length() == 1) {
				result += "금";
			}else {
				result += ",금";
			}
		}
		if(satCount == 5) {
			if(result.length() == 1) {
				result += "토";
			}else {
				result += ",토";
			}
		}
		if(sunCount == 5) {
			if(result.length() == 1) {
				result += "일";
			}else {
				result += ",일";
			}
		}
		
		if(result.equals("~")) {
			result += "무";
		}
		
		return result;
	}
	
	private String makeTheme(String[] themes, String ect) {
		String themeStr = "[";
		if(themes != null) {
			for(int i=0;i<themes.length;i++) {
				themeStr += themes[i];
				if(i != themes.length) {
					themeStr += ", ";
				}
			}
		}
		return themeStr + "]";
	}
	
	private String makeKindOrType(String str, String ect) {
		if(str.equals("기타(직접입력)")) {
			return ect;
		}else {
			return str;
		}
	}
	
	//delete
	public String deleteCp(HttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		
		int staffResult = delDao.delStaff(cpSeq);
		int hitsResult = delDao.delHits(cpSeq);
		int infoResult = delDao.delInfo(cpSeq);
		int userResult = delDao.delCpUser(email);
		
		for(int i=0;i<delDao.selMenuImg(cpSeq).size();i++) {
			System.out.println(delDao.selMenuImg(cpSeq).get(i));
		}
		int menuImgResult = imgDelete(delDao.selMenuImg(cpSeq), "/baobabMenus/");
		int menuResult = delDao.delMenu(cpSeq);
		
		int userCodeResult = delDao.upUserCode(email);
		
		List<String> revCodes = delDao.selRevCode(cpSeq);
		int revImgResult = 0;
		int revImgFileResult = 0;
		for(String revCode : revCodes) {
			revImgFileResult += imgDelete(delDao.selRevImgUrl(revCode), "/ourReviews/");
			revImgResult += delDao.delReviewImgs(revCode);
		}
		int revResult = delDao.delReview(cpSeq);
		
		int realImgResult = imgDelete(delDao.selMainImgUrl(cpSeq), "/baobabMainImg/");
		int mainImgResult = delDao.delMainImg(cpSeq);
		
		List<String> eventSerials = delDao.selEventSerial(cpSeq);
		int eventMenuResult = 0;
		int eventOptionResult = 0;
		for(String eventSerial : eventSerials) {
			List<String> optionSerials = delDao.selOptionSerial(eventSerial);
			for(String optionSerial : optionSerials) {
				eventMenuResult += delDao.delEventMenu(optionSerial);
			}
			eventOptionResult += delDao.delEventOption(eventSerial);
		}
		int eventResult = delDao.delEvent(cpSeq);
		
		if(userCodeResult == 1) {
			return "업체정보 : " + infoResult + "개%%" + "사장님정보 : " + userResult + "개%%" + "직원 :" + staffResult + "명%%" + "메인 이미지url : " + mainImgResult + 
					"개%%" + "메인 이미지file : " + realImgResult + "개%%" + "업체 조회수 : " + hitsResult + "회%%" + "일반메뉴 : " + menuResult + "개%%" + 
					"일반메뉴 이미지file : " + menuImgResult + "개%%" + "리뷰 : " + revResult + "개%%" + "리뷰 이미지url : " + revImgResult + "개%%" + "리뷰 이미지file : " + 
					revImgFileResult + "개%%" + "이벤트(대분류) : " + eventResult + "개%%" + "이벤트 옵션(중분류) : " + eventOptionResult + "개%%" + "이벤트 메뉴(소분류) : " + 
					eventMenuResult + "개%%" + "가 삭제 되었으며%%" + "(" + email + ") 회원이 일반회원으로 변경 되었습니다.";
		}else {
			return "업체정보 : " + infoResult + "개%%" + "사장님정보 : " + userResult + "개%%" + "직원 :" + staffResult + "명%%" + "메인 이미지url : " + mainImgResult + 
					"개%%" + "메인 이미지file : " + realImgResult + "개%%" + "업체 조회수 : " + hitsResult + "회%%" + "일반메뉴 : " + menuResult + "개%%" + 
					"일반메뉴 이미지file : " + menuImgResult + "개%%" + "리뷰 : " + revResult + "개%%" + "리뷰 이미지url : " + revImgResult + "개%%" + "리뷰 이미지file : " + 
					revImgFileResult + "개%%" + "이벤트(대분류) : " + eventResult + "개%%" + "이벤트 옵션(중분류) : " + eventOptionResult + "개%%" + "이벤트 메뉴(소분류) : " + 
					eventMenuResult + "개%%" + "가 삭제 되었으며%%" + "(" + email + ") 회원이 일반회원으로 변경에 실패 하였습니다. 해당 사항을 개발자에게 전달해 주십시오.";
		}
	}
	
	private int imgDelete(List<String> urls, String folder) throws Exception {
		FtpClient ftp = new FtpClient();
		int result = 0;
		
		for(String url : urls) {
			if(ftp.deleteFile(folder, url.split("/")[url.split("/").length - 1]) == 1) {
				result++;
			}
		}
		return result;
	}
}

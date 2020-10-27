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
		if(close.equals("~~~~~��")) {
			return "�޹�����";
		}else {
			String[] closeArr = close.split("~");
			String result = "";
			for(int i=0;i<closeArr.length-1;i++) {
				result += "(" + (i+1) + "°�� : " + closeArr[i] + ")";
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
				return "~~~~~��";
			}else {
				String closeStr = "";
				closeStr = arrToStr(first) + "~" + arrToStr(second) + "~" + arrToStr(third) + "~" + arrToStr(fourth) + "~" + arrToStr(fifth);
				return closeStr + lastCloseDay(first, second, third, fourth, fifth);
			}
		}catch(NullPointerException e) {
			return "~~~~~��";
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
		
		
		int monCount = StringUtils.countOccurrencesOf(allStr, "��");
		int tueCount = StringUtils.countOccurrencesOf(allStr, "ȭ");
		int wedCount = StringUtils.countOccurrencesOf(allStr, "��");
		int thuCount = StringUtils.countOccurrencesOf(allStr, "��");
		int friCount = StringUtils.countOccurrencesOf(allStr, "��");
		int satCount = StringUtils.countOccurrencesOf(allStr, "��");
		int sunCount = StringUtils.countOccurrencesOf(allStr, "��");
		
		String result = "~";
		if(monCount == 5) {
			if(result.length() == 1) {
				result += "��";
			}else {
				result += ",��";
			}
		}
		if(tueCount == 5) {
			if(result.length() == 1) {
				result += "ȭ";
			}else {
				result += ",ȭ";
			}
		}
		if(wedCount == 5) {
			if(result.length() == 1) {
				result += "��";
			}else {
				result += ",��";
			}
		}
		if(thuCount == 5) {
			if(result.length() == 1) {
				result += "��";
			}else {
				result += ",��";
			}
		}
		if(friCount == 5) {
			if(result.length() == 1) {
				result += "��";
			}else {
				result += ",��";
			}
		}
		if(satCount == 5) {
			if(result.length() == 1) {
				result += "��";
			}else {
				result += ",��";
			}
		}
		if(sunCount == 5) {
			if(result.length() == 1) {
				result += "��";
			}else {
				result += ",��";
			}
		}
		
		if(result.equals("~")) {
			result += "��";
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
		if(str.equals("��Ÿ(�����Է�)")) {
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
			return "��ü���� : " + infoResult + "��%%" + "��������� : " + userResult + "��%%" + "���� :" + staffResult + "��%%" + "���� �̹���url : " + mainImgResult + 
					"��%%" + "���� �̹���file : " + realImgResult + "��%%" + "��ü ��ȸ�� : " + hitsResult + "ȸ%%" + "�Ϲݸ޴� : " + menuResult + "��%%" + 
					"�Ϲݸ޴� �̹���file : " + menuImgResult + "��%%" + "���� : " + revResult + "��%%" + "���� �̹���url : " + revImgResult + "��%%" + "���� �̹���file : " + 
					revImgFileResult + "��%%" + "�̺�Ʈ(��з�) : " + eventResult + "��%%" + "�̺�Ʈ �ɼ�(�ߺз�) : " + eventOptionResult + "��%%" + "�̺�Ʈ �޴�(�Һз�) : " + 
					eventMenuResult + "��%%" + "�� ���� �Ǿ�����%%" + "(" + email + ") ȸ���� �Ϲ�ȸ������ ���� �Ǿ����ϴ�.";
		}else {
			return "��ü���� : " + infoResult + "��%%" + "��������� : " + userResult + "��%%" + "���� :" + staffResult + "��%%" + "���� �̹���url : " + mainImgResult + 
					"��%%" + "���� �̹���file : " + realImgResult + "��%%" + "��ü ��ȸ�� : " + hitsResult + "ȸ%%" + "�Ϲݸ޴� : " + menuResult + "��%%" + 
					"�Ϲݸ޴� �̹���file : " + menuImgResult + "��%%" + "���� : " + revResult + "��%%" + "���� �̹���url : " + revImgResult + "��%%" + "���� �̹���file : " + 
					revImgFileResult + "��%%" + "�̺�Ʈ(��з�) : " + eventResult + "��%%" + "�̺�Ʈ �ɼ�(�ߺз�) : " + eventOptionResult + "��%%" + "�̺�Ʈ �޴�(�Һз�) : " + 
					eventMenuResult + "��%%" + "�� ���� �Ǿ�����%%" + "(" + email + ") ȸ���� �Ϲ�ȸ������ ���濡 ���� �Ͽ����ϴ�. �ش� ������ �����ڿ��� ������ �ֽʽÿ�.";
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

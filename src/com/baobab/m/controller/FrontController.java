package com.baobab.m.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.admin.dao.adminfunction.AdminNoticeDAO;
import com.baobab.admin.dao.mainImg.MainImgDAO;
import com.baobab.m.dao.adminfunction.QRCodeDAO;
import com.baobab.m.dao.adminfunction.UserLocationDAO;
import com.baobab.m.dao.adminfunction.VersionDAO;
import com.baobab.m.dao.advertisement.AdImagesDAO;
import com.baobab.m.dao.coupon.CouCpDAO;
import com.baobab.m.dao.coupon.CouPaymentDAO;
import com.baobab.m.dao.coupon.CouRecommendDAO;
import com.baobab.m.dao.coupon.CouponHistoryDAO;
import com.baobab.m.dao.coupon.CouponListDAO;
import com.baobab.m.dao.coupon.CouponUserDAO;
import com.baobab.m.dao.cpfunction.CpStaffDAO;
import com.baobab.m.dao.cpfunction.CpStaffTestDAO;
import com.baobab.m.dao.cpfunction.GetMyMenuDAO;
import com.baobab.m.dao.cpfunction.MainImgUploadDAO;
import com.baobab.m.dao.cpfunction.MenuUploadDAO;
import com.baobab.m.dao.event.EventCpDAO;
import com.baobab.m.dao.hits.HitsDAO;
import com.baobab.m.dao.join.CPJoinDAO;
import com.baobab.m.dao.join.MarketHistoryDAO;
import com.baobab.m.dao.join.UserJoinDAO;
import com.baobab.m.dao.login.LoginDAO;
import com.baobab.m.dao.login.PersonalInfoDAO;
import com.baobab.m.dao.payment.PaymentDAO;
import com.baobab.m.dao.review.ReviewsDAO;
import com.baobab.m.dao.selectcp.GetOurCPDAO;
import com.baobab.m.dao.selectcp.StoreMenuDAO;
import com.baobab.m.dao.servefunction.BasketDAO;
import com.baobab.m.dao.servefunction.CallHistoryDAO;
import com.baobab.m.dao.servefunction.PokeDAO;
import com.baobab.m.dao.servefunction.PushDAO;
import com.baobab.m.dao.ticket.UserTicketDAO;
import com.baobab.m.service.activity.AnterMain;
import com.baobab.m.service.activity.CPMenuActivity;
import com.baobab.m.service.activity.CouponManagement;
import com.baobab.m.service.activity.JoinActivity;
import com.baobab.m.service.activity.MenuActivity;
import com.baobab.m.service.activity.PageActivity;
import com.baobab.m.service.adminservice.HashMap1;
import com.baobab.m.service.adminservice.VersionCheck;
import com.baobab.m.service.event.EventCpDataBind;
import com.baobab.m.service.event.EventDataInsert;
import com.baobab.m.service.fcm.FCMDiv;
import com.baobab.m.service.fcm.SendFCM;
import com.baobab.m.service.ftp.MenuImgModify;
import com.baobab.m.service.geo.NaverGeoCoding;
import com.baobab.m.service.iamport.ImportServiceInterface;
import com.baobab.m.service.inicis.PaidHistoryService;
import com.baobab.m.service.inicis.PaycancelAPI;
import com.baobab.m.service.inicis.PaymentService;
import com.baobab.m.service.join.JoinService;
import com.baobab.m.service.license.Certification;
import com.baobab.m.service.license.LicenseUpload;
import com.baobab.m.service.payple.PaypleService;
import com.baobab.m.service.qrcode.QrcodeFile;
import com.baobab.m.service.rsa.KmcDecryptUtil;
import com.baobab.m.service.statistics.StatisticsService;
import com.baobab.m.service.ticket.UserTicketService;
import com.baobab.m.vo.AnterMainVO;
import com.baobab.m.vo.EventCpMenuVO;
import com.baobab.m.vo.HitsVO;
import com.baobab.m.vo.MeCertVO;
import com.baobab.m.vo.MenuVO;
import com.baobab.m.vo.PageSearchVO;
import com.baobab.m.vo.PaymentVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserLocationVO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Controller
public class FrontController {
	
	@Autowired
	CpStaffTestDAO staffTest;
	@Autowired
	CPJoinDAO cpJdao;
	@Autowired
	LicenseUpload licUpload;
	@Autowired
	MenuUploadDAO menuUp;
	@Autowired
	MainImgUploadDAO mainUp;
	@Autowired
	LoginDAO login;
	@Autowired
	GetMyMenuDAO getMenu;
	@Autowired
	GetOurCPDAO getOurs;
	@Autowired
	StoreMenuDAO storeMenu;
	@Autowired
	CallHistoryDAO call;
	@Autowired
	PokeDAO poke;
	@Autowired
	NaverGeoCoding trans;
	@Autowired
	VersionCheck ver;
	@Autowired
	UserLocationDAO userLoc;
	@Autowired
	UserJoinDAO join;
	@Autowired
	JoinService joinService;
	@Autowired
	BasketDAO bas;
	@Autowired
	PaymentService pay;
	@Autowired
	MenuImgModify menuImg;
	@Autowired
	Certification cert;
	@Autowired
	PushDAO push;
	@Autowired
	SendFCM fcm;
	@Autowired
	AdminNoticeDAO noti;
	@Autowired
	VersionDAO status;
	@Autowired
	PersonalInfoDAO personal;
	@Autowired
	CouponUserDAO couUser;
	@Autowired
	CouCpDAO couCp;
	@Autowired
	CouponListDAO couList;
	@Autowired
	CouponHistoryDAO couHistory;
	@Autowired
	CouPaymentDAO couPayment;
	@Autowired
	CpStaffDAO cpStaff;
	@Autowired
	AnterMain anter;
	@Autowired
	PageActivity pageList;
	@Autowired
	MenuActivity menuAct;
	@Autowired
	CPMenuActivity cpMenuAct;
	@Autowired
	JoinActivity joinAct;
	@Autowired
	CouponManagement couManager;
	@Autowired
	MarketHistoryDAO mark;
	@Autowired
	QRCodeDAO qr;
	@Autowired
	AdImagesDAO adver;
	@Autowired
	EventCpDataBind eventCp;
	@Autowired
	EventDataInsert eventInsert;
	@Autowired
	EventCpDAO event;
	@Autowired
	UserTicketDAO ut;
	@Autowired
	CouRecommendDAO recommed;
	@Autowired
	FCMDiv fcmdiv;
	@Autowired
	UserTicketService uts;
	@Autowired
	PaymentDAO payment;
	@Autowired
	HitsDAO hit;
	@Autowired
	PaidHistoryService phs;
	@Autowired
	StatisticsService stat;
	@Autowired
	PaycancelAPI pcApi;
	@Autowired
	PaypleService payple;
	@Autowired
	KmcDecryptUtil kmc;
	@Autowired
	ReviewsDAO rev;
	@Autowired
	ImportServiceInterface iamp;
	@Autowired
	MainImgDAO mainImg;
	
	@RequestMapping("*/baobabTos.api")
	public String getTosForWeb() {
		return "baobabTos";
	}
	
	@RequestMapping("*/contract.api")
	public String contract() {
		return "contract";
	}
	
	@RequestMapping("*/cert.api")
	public String test(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cert.certResult(request)));
		return "cert";
	}
	
	@RequestMapping("*/payment.api")
	public String payment(Model model ,HttpServletRequest request) {
		return "payment";
	}
	
	@RequestMapping("*/payNext.api")
	public String payNext(HttpServletRequest request) {
		return "payNext";
	}
	
	@RequestMapping(value="*/payNoti.api", method=RequestMethod.POST)
	public String payNoti(HttpServletRequest request) {
		return "payNoti";
	}
	
	@RequestMapping("*/payReturn.api")
	public String payReturn() {
		return "payReturn";
	}
	
	@RequestMapping(value="*/paySuccess.api", method=RequestMethod.POST)
	public String paySuccess(Model model, HttpServletRequest request) {
		model.addAttribute("tid", request.getParameter("tid"));
		return "paySuccess";
	}
	
	@RequestMapping("*/payFail.api")
	public String payFail(Model model, HttpServletRequest request) {
		model.addAttribute("msg", request.getParameter("msg"));
		return "payFail";
	}
	
	@RequestMapping(value="*/eventPayInsert.api", method=RequestMethod.POST)
	public String eventPayInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		PaymentVO paymentVo = gson.fromJson(request.getParameter("payment"), PaymentVO.class);
		List<EventCpMenuVO> eventList = gson.fromJson(request.getParameter("event"), new TypeToken<List<EventCpMenuVO>>(){}.getType());
		model.addAttribute("json", gson.toJson(pay.paySuccess(paymentVo, eventList, paymentVo.getOrderNum(), 
				paymentVo.getEmail(), paymentVo.getCpSeq())));
		return "event";
	}
	
	@RequestMapping(value="*/payCancel.api", method=RequestMethod.POST)
	public String payCancel(Model model, HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pcApi.cancelDiv(request.getParameter("orderNum"))));
		return "paycancelAPI";
	}
	
	@RequestMapping(value="*/payCancelRs.api", method=RequestMethod.POST)
	public String payCancelRs() {
		return "payCancelRs";
	}
	
	@RequestMapping(value="*/payCancelSuccess.api", method=RequestMethod.POST)
	public String payCancelSuccess(HttpServletRequest request) {
		pay.payCancel(request.getParameter("oid"));
		return "payCancelSuccess";
	}
	
	@RequestMapping(value="*/payCancelFail.api", method=RequestMethod.POST)
	public String payCancelpayFail() {
		return "payCancelFail";
	}
	
	@RequestMapping(value="*/payResult.api", method=RequestMethod.POST)
	public String payResult(HttpServletRequest request) {
		return "payResult";
	}
	
	@RequestMapping(value="*/geoTest.api", method=RequestMethod.GET)
	public String geoTest(Model model, @RequestParam String addr) {
		model.addAttribute("longitude", trans.trans(addr).getAddresses().get(0).getX());
		model.addAttribute("latitude", trans.trans(addr).getAddresses().get(0).getY());
		return "admin/addrConversion";
	}
	
	/* 위쪽은 웹 아래쪽은 앱 */
	
	@RequestMapping(value="*/cpMenuJoin.api", method=RequestMethod.POST)
	public void menuJoin(MultipartHttpServletRequest request) throws FileNotFoundException, IOException {
		MenuVO mvo = new MenuVO();
		mvo.setCp_name(request.getParameter("cpName"));
		mvo.setMenu_div(request.getParameter("menuDiv"));
		mvo.setMenu_name(request.getParameter("menuName"));
		mvo.setMenu_option(request.getParameter("option"));
		mvo.setMenu_price(Integer.parseInt(request.getParameter("price")));
		MultipartFile menuImg = request.getFile(request.getParameter("menuName"));
		mvo.setMenu_intro(request.getParameter("menuIntro"));
		mvo.setCp_seq(Integer.parseInt(request.getParameter("cpSeq")));
		
		menuUp.menuUpload(mvo, menuImg);
	}

	@RequestMapping(value="*/mainImgUpload.api", method=RequestMethod.POST)
	public void mainImgUpload(MultipartHttpServletRequest request) throws Exception {
		mainUp.mainImg(request.getFile("mainImg"), request.getParameter("cpName"), Integer.parseInt(request.getParameter("cpSeq")));
		System.out.println("메인이미지 업로드 완료");
	}
	
	@RequestMapping(value="*/loginService.api", method=RequestMethod.POST)
	public String loginControll(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		String id = request.getParameter("email");
		String pw = request.getParameter("password");
		model.addAttribute("json", gson.toJson(login.loginConfirm(id, pw)));
		return "login";
	}
	
	@RequestMapping(value="*/getMymenu.api", method=RequestMethod.GET)
	public String getCpMyMenu(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getMenu.getMenu(cpSeq)));
		System.out.println(getMenu.getMenu(cpSeq));
		return "getMenu";
	}
	
	@RequestMapping(value="*/getMyCPInfo.api", method=RequestMethod.GET)
	public String getMyStoreInfo(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getMyInfo(cpSeq)));
		return "getMyStoreInfo";
	}
	
	@RequestMapping(value="*/hitsUp.api", method=RequestMethod.POST)
	public String hitsUp(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(hit.newHits(gson.fromJson(request.getParameter("vo"), HitsVO.class))));
		return "getMyStoreInfo";
	}
	
	@RequestMapping(value="*/getCallHistory.api", method=RequestMethod.POST)
	public void getCallHistory(HttpServletRequest request) {
		call.getHistory(request.getParameter("userPhone"), request.getParameter("cpPhone"), request.getParameter("cpName"), 
				request.getParameter("cpAddress"), request.getParameter("cpDiv"));
		System.out.println("CallHistory저장완료");
	}
	
	@RequestMapping(value="*/showCallHistory.api", method=RequestMethod.POST)
	public String showCallHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(call.showHistory(request.getParameter("userPhone"))));
		return "callHistory";
	}
	
	@RequestMapping(value="*/getPoke.api", method=RequestMethod.POST)
	public void getPoke(HttpServletRequest request) {
		poke.getPoke(request.getParameter("email"), request.getParameter("cpName"), request.getParameter("cpAddr"), 
				(int)Double.parseDouble(request.getParameter("score")), Integer.parseInt(request.getParameter("revNum")), request.getParameter("divCode"), 
				Integer.parseInt(request.getParameter("cpSeq")));
	}
	
	@RequestMapping(value="*/delPoke.api", method=RequestMethod.POST)
	public void delPoke(HttpServletRequest request) {
		poke.delPoke(request.getParameter("email"), request.getParameter("cpName"), request.getParameter("divCode"), 
				Integer.parseInt(request.getParameter("cpSeq")));
	}
	
	@RequestMapping(value="*/showPoke.api", method=RequestMethod.POST)
	public String showPoke(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(poke.showPoke(request)));
		return "poke";
	}
	
	@RequestMapping(value="*/setLocationOur.api", method=RequestMethod.POST)
	public void setOursLocationInfo(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int seqNum) {
	}
	
	@RequestMapping(value="*/getUpdateData.api", method=RequestMethod.GET)
	public String getUpdateData(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getMyInfo(cpSeq)));             
		return "cpUpdate";
	}
	
	@RequestMapping(value="*/updateCPInfo.api", method=RequestMethod.POST)
	public void updateCPinfo(HttpServletRequest request) {
		cpJdao.cpUpdate(request);
		System.out.println(request.getParameter("cpName") + "수정 완료");
	}
	
	@RequestMapping(value="*/pokeConfirm.api", method=RequestMethod.GET)
	public String pokeConfirm(Model model, @RequestParam String email, @RequestParam String cpName, @RequestParam String divCode, @RequestParam int cpSeq) {
		model.addAttribute("json", poke.pokeConfirm(email, cpName, divCode, cpSeq));
		return "pokeConfirm";
	}
	
	@RequestMapping(value="*/pageSearch.api", method=RequestMethod.GET)
	public void pageSearch(@RequestParam PageSearchVO vo) {
		System.out.println(String.valueOf(vo.getSearchWord()) + "받음");
	}
	
	@RequestMapping(value="*/userLocUpdate.api", method=RequestMethod.POST)
	public void userLocUpdate(HttpServletRequest request) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
	BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		UserLocationVO vo = new UserLocationVO();
		vo.setAddr(request.getParameter("addr"));
		vo.setLatitude(request.getParameter("latitude"));
		vo.setLongitude(request.getParameter("longitude"));
		vo.setUser(request.getParameter("user"));
		vo.setPush_token(request.getParameter("pushToken"));
		userLoc.updateLocation(vo);
	}
	
	@RequestMapping(value="*/selectUserLoc.api", method=RequestMethod.POST)
	public String selectUserLoc(Model model, HttpServletRequest request) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
	BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		UserLocationVO vo = new UserLocationVO();
		vo.setUser(request.getParameter("user"));
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.selectLocation(vo)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/getForPoke.api", method=RequestMethod.GET)
	public String getForPoke(Model model, @RequestParam String cpName, @RequestParam String addr) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.pokeSelect(cpName, addr)));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/menuDetail.api", method=RequestMethod.GET)
	public String menuDetail(Model model, @RequestParam String cpName, @RequestParam String menuName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(storeMenu.getOneMenu(cpName, menuName, cpSeq)));
		return "storeMenu";
	}
	
	@RequestMapping(value="*/duplicateCheck.api", method=RequestMethod.POST)
	public String duplicateCheck(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(joinService.duplicateCheck(request)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/getCpUserInfo.api", method=RequestMethod.POST)
	public String getCpUserInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.getCpUserInfo(request.getParameter("email"))));
		return "login";
	}
	
	@RequestMapping(value="*/loginHistory.api", method=RequestMethod.POST)
	public void loginHistory(HttpServletRequest request) {
		login.getHistory(request);
	}
	
	@RequestMapping(value="*/inBasket.api", method=RequestMethod.GET)
	public void inBasket(@RequestParam String email, @RequestParam String cpName, @RequestParam int cpSeq, @RequestParam String menuName, 
			@RequestParam String option, @RequestParam int ea, @RequestParam int price, @RequestParam int disPrice) {
		bas.confRepetition(email, cpName, cpSeq, menuName, option, ea, price, disPrice);
	}
	
	@RequestMapping(value="*/basketList.api", method=RequestMethod.GET)
	public String basketList(Model model, @RequestParam String email) {
		Gson gson = new Gson();
		String result = bas.basketList(email).toString();
		System.out.println(result);
		model.addAttribute("json", gson.toJson(bas.basketList(email)));
		return "basket";
	}
	
	@RequestMapping(value="*/delBasket.api", method=RequestMethod.GET)
	public void delBasket(@RequestParam String email, @RequestParam String cpName, @RequestParam int cpSeq) {
		bas.delBasket(email, cpName, cpSeq);
	}
	
	@RequestMapping(value="*/basCpInfo.api", method=RequestMethod.GET)
	public String basCpInfo(Model model, @RequestParam String cpName, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		String result = gson.toJson(bas.basCpInfo(cpName, cpSeq));
		System.out.println(result);
		model.addAttribute("json", result);
		return "basket";
	}
	
	@RequestMapping(value="*/basDetailInfo.api", method=RequestMethod.POST)
	public String basDetailInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		String result = gson.toJson(bas.basDetailInfo(request));
		System.out.println(result);
		model.addAttribute("json", result);
		return "basket";
	}
	
	@RequestMapping(value="*/payUsed.api", method=RequestMethod.GET)
	public void payUsed(@RequestParam String orderNum) {
		//pay.usedUpdate(orderNum);
	}
	
	@RequestMapping(value="*/getUserPhone.api", method=RequestMethod.POST)
	public String getUserPhone(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.getUserPhone(request.getParameter("email"))));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/receipt.api", method=RequestMethod.GET)
	public void receipt(@RequestParam String orderNum) {
		//pay.receiptChange(orderNum);
	}
	
	@RequestMapping(value="*/getCpPhone.api", method=RequestMethod.GET)
	public String getCpPhone(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.getCpPhone(cpSeq)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/deleteCallHis.api", method=RequestMethod.GET)
	public void deleteCallHis(@RequestParam int seqNum) {
		call.delHistory(seqNum);
	}
	
	@RequestMapping(value="*/beingMall.api", method=RequestMethod.POST)
	public void beingMall(MultipartHttpServletRequest request) throws FileNotFoundException, NullPointerException, IOException, Exception {
		String email = request.getParameter("email");
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
		MultipartFile license = null;
		try {
			license = request.getFile("upload");
		}catch(NullPointerException e) {
			e.printStackTrace();
			license = null;
		}
		String cpIntro = request.getParameter("cpIntro");
		String bank = request.getParameter("bank");
		String accountHolder = request.getParameter("accountHolder");
		String accountNumber = request.getParameter("accountNumber");
		String divCode = "c-01-01";
		String cpDiv = request.getParameter("cpDiv");		
		cpJdao.cpUserJoin(email, cpName, licUpload.licenseSaveToServer(license, cpName), cpLicenseNum, bank, accountHolder, accountNumber);
		cpJdao.divCodeChange(email);
		cpJdao.UserHistoryJoin(email, divCode);
		cpJdao.cpJoin(cpName, cpPhon, cpZipcode, cpAddress, cpAddrDetails, cpKind, cpType, cpTheme1, cpTheme2, parking, closeDay, businessStart, 
				businessEnd, cpIntro, cpDiv, closeEct, email, cpPhon, accountHolder);
		cpJdao.cpHistoryJoin(cpName);
		
		QrcodeFile.madeQR(cpJdao.getQRCode(request.getParameter("email")).get(0).getSeq_num());
	}

	@RequestMapping(value="*/cpUserJoin.api", method=RequestMethod.POST)
	public void cpJoin(MultipartHttpServletRequest request) throws Exception {
		joinAct.joins(request);
		QrcodeFile.madeQR(cpJdao.getQRCode(request.getParameter("email")).get(0).getSeq_num());
	}
	
	@RequestMapping(value="*/cpNameDup.api", method=RequestMethod.GET)
	public String cpNameDup(Model model, @RequestParam String cpName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.dupName(cpName)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/payCurDate.api", method=RequestMethod.POST)
	public String payCurDate(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(/*pay.payCurDate(request.getParameter("email"))*/null));
		return "pay";
	}
	
	@RequestMapping(value="*/showMetheFan.api", method=RequestMethod.POST)
	public String showMetheFan(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(poke.showMetheFan(request.getParameter("email"))));
		return "poke";
	}
	
	@RequestMapping(value="*/menuDel.api", method=RequestMethod.GET)
	public void menuDel(@RequestParam String cpName, @RequestParam String menuName, @RequestParam String option) throws Exception {
		menuUp.menuDel(cpName, menuName, option);
	}
	
	@RequestMapping(value="*/menuModi.api", method=RequestMethod.POST)
	public String menuModi(Model model, MultipartHttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(menuUp.menuModi(request)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/menuImgChange.api", method=RequestMethod.POST)
	public String menuImgChange(Model model, MultipartHttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(menuImg.imgModify(request)));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/userInfoCha.api", method=RequestMethod.POST)
	public void userInfoCha(HttpServletRequest request) {
		join.userInfoChange(request.getParameter("email"), request.getParameter("password"), request.getParameter("pushCheck"));
	}
	
	@RequestMapping(value="*/leaveUser.api", method=RequestMethod.POST)
	public void leaveUser(HttpServletRequest request) {
		join.leaveUserAll(request.getParameter("email"));
	}
	
	@RequestMapping(value="*/pushNormal.api", method=RequestMethod.POST)
	public String pushNormal(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.pushToNormal(request)));
		return "push";
	}
	
	@RequestMapping(value="*/pushFan.api", method=RequestMethod.POST)
	public String pushFan(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.pushToFan(request)));
		return "push";
	}
	
	@RequestMapping(value="*/sendPush.api", method=RequestMethod.POST)
	public String sendPush(Model model, HttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(fcm.send(request, push.sendToFan(request)) + fcm.send(request, push.sendToNormal(request))));
		push.savePush(request);
		return "push";
	}
	
	@RequestMapping(value="*/findUserLocation.api")
	public String findUserLocation(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.findUser(request.getParameter("pushToken"))));
		return "push";
	}
	
	@RequestMapping(value="*/findCP.api")
	public String findCP(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(push.findCp(request)));
		return "push";
	}
	
	@RequestMapping(value="*/getNoti.api", method=RequestMethod.POST)
	public String getNoti(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(noti.userSelect(request.getParameter("readDiv"))));
		return "notice";
	}
	
	@RequestMapping(value="*/changeUserCode.api", method=RequestMethod.POST)
	public String changeUserCode(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.userCodeUpdate(request)));
		return "login";
	}
	
	@RequestMapping(value="*/dupEmail.api", method=RequestMethod.POST)
	public String dubEmail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.dupEmail(request).size()));
		return "userLoc";
	}
	
	@RequestMapping(value="*/noticePush.api", method=RequestMethod.GET)
	public String noticePush(Model model, @RequestParam String title) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(noti.pushClick(title)));
		return "notice";
	}
	
	@RequestMapping(value="*/reSign.api", method=RequestMethod.POST)
	public String reSign(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.emailCheck(request)));
		return "login";
	}
	
	@RequestMapping(value="*/addrSearch.api")
	public String addrSearch() {
		return "addrSearch";
	}
	
	@RequestMapping(value="*/delMainImg.api", method=RequestMethod.GET)
	public String delMainImg(Model model, @RequestParam String url)throws Exception {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(mainUp.mainImgDel(url)));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/getThisMenu.api", method=RequestMethod.GET)
	public String getThisMenu(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getMenu.getThisMenu(cpSeq)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/getStatus.api", method=RequestMethod.POST)
	public String getStatus(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		String result = status.getStatus();
		System.out.println("앱 상태 : " + result);
		model.addAttribute("json", gson.toJson(result));
		return "version";
	}
	
	@RequestMapping(value="*/findEmail.api", method=RequestMethod.POST)
	public String findEmail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(personal.findEmail(request.getParameter("phoneNum"))));
		return "personal";
	}
	
	@RequestMapping(value="*/findPassword.api", method=RequestMethod.POST)
	public String findPassword(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(personal.findPassword(request)));
		return "personal";
	}
	
	@RequestMapping(value="*/updatePassword.api", method=RequestMethod.POST)
	public String updatePassword(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(personal.updatePassword(request)));
		return "personal";
	}
	
	@RequestMapping(value="*/menuImageUrl.api", method=RequestMethod.GET)
	public String menuImageUrl(Model model, @RequestParam String cpName, @RequestParam int cpSeq, @RequestParam String menuName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getMenu.menuImageUrl(cpName, cpSeq, menuName)));
		return "getMenu";
	}
	
	@RequestMapping(value="*/mainImgUpdate.api", method=RequestMethod.POST)
	public String mainImgUpdate(Model model, MultipartHttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("img", gson.toJson(mainUp.urlUpdate(mainUp.imgUpload(request.getFile("mainImg"),
				request.getParameter("url").split("/")[request.getParameter("url").split("/").length-1].replaceAll(".png", "").replaceAll(".jpg", "").replaceAll(".webp", "")))));
		return "imgLoad";
	}
	
	@RequestMapping(value="*/cpUserAllInfo.api", method=RequestMethod.POST)
	public String cpUserAllInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.getCpUserInfo(request.getParameter("email"))));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/pointUp.api", method=RequestMethod.POST)
	public String pointUp(Model model,HttpServletRequest request) {
	    Gson gson = new Gson();
	    model.addAttribute("json", gson.toJson(join.point(request.getParameter("email"))));
	    return "userLoc";
	      
	}
	
	@RequestMapping(value="*/nowPoint.api", method=RequestMethod.POST)
	public String nowPoint(Model model,HttpServletRequest request) {
		Gson gson = new Gson();
	    model.addAttribute("json", gson.toJson(join.nowPoint(request.getParameter("email"))));
	    return "userLoc";
	}
	
	@RequestMapping(value="*/pushPaySelect.api", method=RequestMethod.POST)
	public String pushPaySelect(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json",gson.toJson(push.pushPaymentSelect(request)) );
		return "push";
	}
	
	@RequestMapping(value="*/pushEaPlma.api", method=RequestMethod.POST)
	public void pushEaPlma(HttpServletRequest request) {
		push.pushEaPlma(request.getParameter("email"), Integer.parseInt(request.getParameter("pushEa")));
	}
	
	@RequestMapping(value="*/cpUserInfo.api", method=RequestMethod.POST)
	public String cpUserInfo(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.cpUserInfo(request.getParameter("email"))));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/changeCpUser.api", method=RequestMethod.POST)
	public String changeCpUser(Model model, MultipartHttpServletRequest request) throws Exception {
		String email = request.getParameter("email");
		String licenseNum = request.getParameter("licenseNum");
		String accHolder = request.getParameter("accHolder");
		String bank = request.getParameter("bank");
		String accNum = request.getParameter("accNum");
		MultipartFile license = request.getFile("license");
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.changeCpUser(email, licenseNum, accHolder, bank, accNum, license)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/insertCouponUser.api", method=RequestMethod.POST)
	public String insertcouponUser(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.insertCouponUser(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/userCouponEa.api", method=RequestMethod.POST)
	public String userCouponEa(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.userCouponEa(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponExpiry.api")
	public String couponExpiry(String serial_num) {
		couUser.userCouponExpiry();
//		couUser.periodOutList(serial_num);
		couCp.cpCouponExpiry();
		return "coupon";
	}
	
	@RequestMapping(value="*/usedCouponHistory.api", method=RequestMethod.POST)
	public String usedCouponHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.usedCouponHistory(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponCpPeriod.api", method=RequestMethod.POST)
	public String couponCpPeriod(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couponCpPeriod(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couPayDetail.api", method=RequestMethod.POST)
	public String couPayDetail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couPayDetail(request.getParameter("orderNum"))));
		return "coupon";
	}
	
	@RequestMapping(value="*/couCpInfoInsert.api", method=RequestMethod.POST)
	public String couCpInfoInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couCpInfoInsert(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponCpUse.api", method=RequestMethod.POST)
	public String couponCpUse(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couponCpUse(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponUpdate.api", method=RequestMethod.POST)
	public String couponUpdate(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.couponUpdate(request)));
		return "coupon";
	}
	
	//couponPayment
	@RequestMapping(value="*/couPaySelect.api", method=RequestMethod.POST)
	public String couPaySelect(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json",gson.toJson(couPayment.couPaySelect(request)) );
		return "coupon";
	}
	
	@RequestMapping(value="*/couponDayHistory.api", method=RequestMethod.POST)
	public String couponDayHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couHistory.couponDayHistory(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponMonthHistory.api", method=RequestMethod.POST)
	public String couponMonthHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couHistory.couponMonthHistory(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponHomeHistory.api", method=RequestMethod.POST)
	public String couponHomeHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couHistory.couponHomeHistory(request)));
		return "coupon";
	}
	
	//-----------cpStaff & Scan----------------
	@RequestMapping(value="*/staffSearch.api", method=RequestMethod.POST)
	public String staffSearch(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.staffSearch(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/getStaffs.api", method=RequestMethod.POST)
	public String getStaffs(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.getStaffs(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/cpStaffInfoInsert.api", method=RequestMethod.POST)
	public String cpStaffInfoInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.staffInfoInsert(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/updateStaff.api", method=RequestMethod.POST)
	public String updateStaff(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.updateStaff(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/scanCoupon.api", method=RequestMethod.POST)
	public String scanCoupon(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.scanCoupon(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/staffCancel.api", method=RequestMethod.POST)
	public String staffCancel(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.staffCancel(request)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/cpStaffTest.api", method=RequestMethod.GET)
	public String test() {
		staffTest.merge();
		return "test";
	}
	
	@RequestMapping(value="*/couponScanHistory.api", method=RequestMethod.POST)
	public String couponScanHistory(Model model, HttpServletRequest request) throws ParseException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.usedCoupon(request)));
		return "cpStaff";
	}	
	
	//Activity최적화
	@RequestMapping(value="*/anterMain.api", method=RequestMethod.POST)
	public String anterMain(Model model, HttpServletRequest request) throws ParseException{
		Gson gson = new Gson();
		AnterMainVO vo = anter.anterMain(request);
		System.out.println("앱 버전 : " + vo.getVersion());
		model.addAttribute("json", gson.toJson(vo));
		return "activity";
	}
	
	@RequestMapping(value="*/page.api", method=RequestMethod.POST)
	public String page(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pageList.Page(request)));
		return "activity";
	}
	
	@RequestMapping(value="*/menuAct.api", method=RequestMethod.POST)
	public String menuAct(Model model, HttpServletRequest request) throws ParseException{
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(menuAct.MenuAct(request)));
		return "activity";
	}
	
	@RequestMapping(value="*/cpMenu.api", method=RequestMethod.POST)
	public String cpMenu(Model model, HttpServletRequest request){
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpMenuAct.cpMenu(request)));
		return "activity";
	}
	
	@RequestMapping(value="*/couponManagement.api", method=RequestMethod.POST)
	public String couponActivity(Model model, HttpServletRequest request){
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couManager.couponActivity(request)));
		return "activity";
	}
	
	@RequestMapping(value="*/goMarket.api", method=RequestMethod.GET)
	public String insertMarket(@RequestParam String cp, @RequestParam String root){
		mark.insertMarket(cp,root);
		return "goMarket";
	}
	
	@RequestMapping(value="*/qrcode2.api")
	public String qrcode() {
		return "qrcode2";
	}
	
	@RequestMapping(value="*/searchQRCode.api", method=RequestMethod.POST, produces = "application/text; charset=utf8")
	public @ResponseBody String searchQRCode(@RequestBody String searchWord){
		HashMap1 hash = new HashMap1();
		return 	hash.addr( qr.searchQRCode(searchWord.replaceAll("\"", "")));
	}
	
	@RequestMapping(value="*/makeQRCode.api")
	public String makeQR() {
		return "makeQR";
	}
	
	@RequestMapping(value="*/goNext.api",method=RequestMethod.POST)
	public String goNext(Model model,HttpServletRequest request) {
		model.addAttribute("str", request.getParameter("str"));
		return "makeQRList";
	}
	
	@RequestMapping(value="*/qrcode3.api")
	public String qrcode3() {
		return "qrcode3";
	}
	
	@RequestMapping(value ="*/qrcodeFile.api")
	public void qrcodeFile(int cpSeq) throws Exception{
		QrcodeFile.madeQR(cpSeq);
	} 
	
	@RequestMapping(value="*/getQRCode.api",method=RequestMethod.POST)
	public String getQRCode(Model model, String email) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.getQRCode(email)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/delCpCoupon.api", method=RequestMethod.POST)
	public String delCpCoupon(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couCp.deleteCoupon(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/delUserCoupon.api", method=RequestMethod.POST)
	public String delUserCoupon(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couUser.deleteUserCoupon(request)));
		return "coupon";
	}
	
	@RequestMapping(value="*/couponType.api",method=RequestMethod.GET)
	public String couponSpecial(Model model) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(couList.couponSpecial()));
		return "coupon";
	}
	
	@RequestMapping(value="*/selectCPInfo.api", method=RequestMethod.GET)
	public String selectCPInfo(Model model) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getOurs.selectAllCp()));
		return "storeList";
	}
	
	@RequestMapping(value="*/cpEvent.api", method=RequestMethod.GET)
	public String cpEvent(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(eventCp.dataBinding(cpSeq)));
		return "event";
	}
	
	@RequestMapping(value="*/makeEvent.api", method=RequestMethod.POST)
	public String makeEvent(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(eventInsert.allInsert(request.getParameter("data"))));
		return "event";
	}
	
	@RequestMapping(value="*/updateEvent.api", method=RequestMethod.POST)
	public String updateEvent(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(eventInsert.eventUpdate(request.getParameter("data"), request.getParameter("isMain"))));
		return "event";
	}
	
	@RequestMapping(value="*/deleteEvent.api", method=RequestMethod.POST)
	public String deleteEvent(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(eventInsert.eventDelete(request.getParameter("data"))));
		return "event";
	}
	
	@RequestMapping(value="*/turnUpdateEvent.api", method=RequestMethod.POST)
	public String turnUpdateEvent(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(eventInsert.turnChange(request.getParameter("data"))));
		return "event";
	}
	
	@RequestMapping(value="*/optionNameSelect.api", method=RequestMethod.GET)
	public String optionNameSelect(Model model, @RequestParam String serial) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(event.optionNameSelect(serial)));
		return "event";
	}
	
	@RequestMapping(value="*/getUserTicket.api", method=RequestMethod.POST)
	public String getUserTicket(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ut.selectUserTicket(request.getParameter("email"))));
		return "ticket";
	}
	
	@RequestMapping(value="*/getPaidMenus.api", method=RequestMethod.POST)
	public String getPaidMenus(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ut.getPaidMenus(request.getParameter("orderNum"))));
		return "ticket";
	}
	
	@RequestMapping(value="*/recommendCP.api", method=RequestMethod.POST)
	public String recommendCP(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(recommed.couponRecommend(Integer.parseInt(request.getParameter("cpSeq")))));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/sendMessage.api", method=RequestMethod.POST)
	public String sendMessage(Model model, HttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(fcmdiv.send(request)));
		return "notice";
	}
	
	@RequestMapping(value="*/usedTicket.api", method=RequestMethod.POST)
	public String usedTicket(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(uts.ticketUsed(request)));
		return "ticket";
	}
	
	@RequestMapping(value="*/useTicketHistory.api", method=RequestMethod.POST)
	public String useTicketHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ut.useTicketHistory(request.getParameter("email"))));
		return "ticket";
	}
	
	@RequestMapping(value="*/useTicketHistoryDetail.api", method=RequestMethod.POST)
	public String useTicketHistoryDetail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ut.getPaidMenus(request.getParameter("orderNum"))));
		return "ticket";
	}
	
	@RequestMapping(value="*/getCpNotice.api", method=RequestMethod.GET)
	public String getCpNotice(Model model) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(noti.userSelect("C")));
		return "activity";
	}
	
	@RequestMapping(value="*/getPayment.api", method=RequestMethod.POST)
	public String getPayment(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(payment.selectPayment(request)));
		return "pay";
	}
	
	@RequestMapping(value="*/paidHistory.api", method=RequestMethod.POST)
	public String paidHistory(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(phs.gethistories(request.getParameter("orderNum"))));
		return "pay";
	}
	
	@RequestMapping(value="*/setMainEvent.api", method=RequestMethod.GET)
	public String setMainEvent(Model model, @RequestParam int cpSeq, @RequestParam int menuSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(event.changeMain(cpSeq, menuSeq)));
		return "event";
	}
	
	@RequestMapping(value="*/getMainEvent.api", method=RequestMethod.GET)
	public String getMainEvent(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(event.getMain(cpSeq)));
		return "event";
	}
	
	@RequestMapping(value="*/cpStat.api", method=RequestMethod.GET)
	public String cpStat(Model model, @RequestParam int cpSeq, @RequestParam String curDate, @RequestParam String statDiv) throws ParseException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(stat.makeVO(cpSeq, curDate, statDiv)));
		return "stat";
	}
	
	@RequestMapping(value="*/eventStatList.api", method=RequestMethod.GET)
	public String eventStatList(Model model, @RequestParam int cpSeq, @RequestParam String start, @RequestParam String end) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(event.selectSalesList(cpSeq, start, end)));
		return "event";
	}
	
	@RequestMapping(value="*/eventDetailStat.api", method=RequestMethod.POST)
	public String eventDetailStat(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(stat.eventDetailStat(request)));
		return "stat";
	}
	
	@RequestMapping(value="*/payCancelCheck.api", method=RequestMethod.POST)
	public String payCancelCheck(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(payment.cancelCheck(request.getParameter("oid"))));
		return "pay";
	}
	
	@RequestMapping(value="*/cpPwCheck.api", method=RequestMethod.POST)
	public String cpPwCheck(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ut.passwordCheck(request)));
		return "ticket";
	}
	
	@RequestMapping(value="*/changeCpPw.api", method=RequestMethod.POST)
	public String changeCpPw(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.updateCpPw(request)));
		return "ticket";
	}
	
	@RequestMapping(value="*/getStaffSeq.api", method=RequestMethod.GET)
	public String getStaffSeq(Model model, @RequestParam String email) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpStaff.getMySeq(email)));
		return "cpStaff";
	}
	
	@RequestMapping(value="*/getAllMenu.api", method=RequestMethod.GET)
	public String getAllMenu(Model model, @RequestParam int cpSeq, @RequestParam String menuName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(storeMenu.getAllMenus(cpSeq, menuName)));
		return "storeMenu";
	}
	
	@RequestMapping(value="*/pushPayment.api", method=RequestMethod.POST)
	public String pushPayment(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(pay.pushPaySuccess(gson.fromJson(request.getParameter("data"), PaymentVO.class))));
		return "push";
	}
	
	@RequestMapping(value="*/loclog.api", method=RequestMethod.POST)
	public String loclog(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(userLoc.locationLog(request)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/cpQr.api", method=RequestMethod.GET)
	public String cpQr(@RequestParam String cpSeq) {
		return "cpQr";
	}
	
	@RequestMapping(value="*/app.api", method=RequestMethod.GET)
	public String appHome() {
		return "appHome";
	}
	
	@RequestMapping(value="*/payple.api", method=RequestMethod.POST)
	public String payple(Model model, HttpServletRequest request) {
		return "payple";
	}
	
	@RequestMapping(value="*/paypleResult.api", method=RequestMethod.POST)
	public String paypleResult(HttpServletRequest request) {
		return "paypleResult";
	}
	
	@RequestMapping(value="*/accountCheck.api", method=RequestMethod.POST)
	public String accountCheck(Model model, HttpServletRequest request) throws IOException {
		String email = request.getParameter("email");
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(payple.regAccountSelect(email, payment.selectPayerIds(email))));
		return "userLoc";
	}
	
	@RequestMapping(value="*/accountDelete.api", method=RequestMethod.POST)
	public String accountDelete(Model model, HttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(payple.regAccountDelete(request)));
		return "userLoc";
	}
	
	//------------------ 본인확인서비스 -----------------
	@RequestMapping(value="*/meCert.api", method=RequestMethod.POST)
	public String meCert() {
		return "meCert";
	}
	
	@RequestMapping(value="*/meCertResult.api", method=RequestMethod.GET)
	public String meCertResult(Model model, HttpServletRequest request, HttpSession session) throws ParseException, UnsupportedEncodingException {
		MeCertVO vo = kmc.decrypt(request);
		vo.setName(URLDecoder.decode(vo.getName(), "UTF-8"));
		vo.setM_name(URLDecoder.decode(vo.getM_name(), "UTF-8"));
		
		if(session.getAttribute("kind").toString().equals("join")) {
			join.userAllJoin(vo, session.getAttribute("joinEmail").toString(), session.getAttribute("joinPw").toString(), 
					session.getAttribute("joinPush").toString(), session.getAttribute("joinEmail").toString());
			
			session.invalidate();
			model.addAttribute("result", vo.getResult() + "/" + vo.getPhoneNo());
			return "meCertResult";
		}else if(session.getAttribute("kind").toString().equals("Mjoin")){
			join.insertUserMarketing(join.getUserDataForMarketing(vo, session.getAttribute("joinEmail").toString(), session.getAttribute("joinPw").toString(), 
					session.getAttribute("joinPush").toString(), session.getAttribute("nickName").toString()));
			
			session.removeAttribute("kind");
			session.removeAttribute("joinEmail");
			session.removeAttribute("joinPw");
			session.removeAttribute("joinPush");
			session.removeAttribute("nickName");
			
			model.addAttribute("result", vo.getResult());
			return "admin/userJoinRs";
		}else {
			join.userDataAdd(vo, session.getAttribute("joinEmail").toString());
			
			session.invalidate();
			model.addAttribute("result", vo.getResult() + "/" + vo.getPhoneNo());
			return "meCertResult";
		}
	}
	//----------------------------------------------
	
	@RequestMapping(value="*/accountInsert.api", method=RequestMethod.GET)
	public String accountInsert(Model model, @RequestParam String email, @RequestParam String payerId) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(payment.justInsert(email, payerId)));
		return "personal";
	}
	
	@RequestMapping(value="*/eventOnOff.api", method=RequestMethod.GET)
	public String eventOnOff(Model model, @RequestParam String eventSerial, @RequestParam String onOff, @RequestParam int mainSeq, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(event.setOnOff(eventSerial, onOff, mainSeq, cpSeq)));
		return "event";
	}
	
	@RequestMapping(value="*/cpOnOff.api", method=RequestMethod.GET)
	public String cpOnOff(Model model, @RequestParam String ownerEmail, @RequestParam String cpName, @RequestParam String status) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.setOnOffCp(ownerEmail, cpName, status)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/getCpStatus.api", method=RequestMethod.GET)
	public String getCpStatus(Model model, @RequestParam String ownerEmail, @RequestParam String cpName) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(cpJdao.selectCpStatus(ownerEmail, cpName)));
		return "cpJoin";
	}
	
	//profile
	@RequestMapping(value="*/profileDelete.api", method=RequestMethod.POST)
	public String profileDelete(Model model, HttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.profileDelete(request)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/setProfile.api", method=RequestMethod.POST)
	public String setProfile(Model model, MultipartHttpServletRequest request) throws Exception {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.setProfile(request)));
		return "userLoc";
	}
	
	@RequestMapping(value="*/payDetail.api", method=RequestMethod.POST)
	public String payDetail(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(payment.payDetail(request.getParameter("orderNum"))));
		return "pay";
	}
	
	@RequestMapping(value="*/revInsert.api", method=RequestMethod.POST)
	public String revInsert(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.reviewInsert(request)));
		return "review";
	}
	
	@RequestMapping(value="*/revImgInsert.api", method=RequestMethod.POST)
	public String revImgInsert(Model model, MultipartHttpServletRequest request) throws IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(rev.reviewImgInsert(request)));
		return "review";
	}
	
	@RequestMapping(value="*/checkUserData.api", method=RequestMethod.POST)
	public String checkUserData(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		UserAllVO vo = join.userDataCheck(request.getParameter("email"));
		model.addAttribute("json", gson.toJson(vo));
		return "userLoc";
	}
	
	@RequestMapping(value="*/accountCert.api", method=RequestMethod.POST)
	public String accountCert(Model model, HttpServletRequest request) throws JsonSyntaxException, IOException {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(iamp.accountCert(request)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/accountBack.api", method=RequestMethod.GET)
	public String accountBank(Model model, @RequestParam String email) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(login.socialAccountBackup(email)));
		return "login";
	}
	
	@RequestMapping(value="*/cpAllEvent.api", method=RequestMethod.GET)
	public String cpAllEvent(Model model, @RequestParam int cpSeq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(eventCp.infoDataBinding(cpSeq)));
		return "event";
	}
	
	@RequestMapping(value="*/transUserJoin.api", method=RequestMethod.GET)
	public String transUserJoin(Model model, @RequestParam String email) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(join.emailDup(email)));
		return "login";
	}
	
	@RequestMapping(value="*/getMainImg.api", method=RequestMethod.GET)
	public String getMainImg(Model model, @RequestParam int seq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(mainImg.getImgs(seq)));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/selectAddrGroup.api", method=RequestMethod.GET)
	public String selectAddrGroup(Model model) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getOurs.selectAddrGroup()));
		return "cpJoin";
	}
	
	@RequestMapping(value="*/bottomSafeDetail.api", method=RequestMethod.GET)
	public String bottomSafeDetail(Model model, @RequestParam int safeNo) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getOurs.bottomSafeDetail(safeNo)));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/bottomCpDetail.api", method=RequestMethod.GET)
	public String topAndPlistDetail(Model model, @RequestParam int seq) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(getOurs.bottomCpDetail(seq)));
		return "getStoreInfo";
	}
	
	@RequestMapping(value="*/freeTicket.api", method=RequestMethod.POST)
	public String freeTicket(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(ut.freeTicketInsert(request)));
		return "pay";
	}
}
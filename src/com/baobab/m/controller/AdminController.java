package com.baobab.m.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.admin.dao.AdminMainDAO;
import com.baobab.admin.dao.adminfunction.AdminCodeChangeDAO;
import com.baobab.admin.dao.adminfunction.AdminLoginDAO;
import com.baobab.admin.dao.adminfunction.AdminNoticeDAO;
import com.baobab.admin.dao.adminfunction.AdminSearchWordDAO;
import com.baobab.admin.dao.adminfunction.AdminVersionDAO;
import com.baobab.admin.dao.adminfunction.AlmightyDAO;
import com.baobab.admin.dao.app.AppDAO;
import com.baobab.admin.dao.cp.CpDAO;
import com.baobab.admin.dao.cp.CpService;
import com.baobab.admin.dao.dailyReport.DailyReportDAO;
import com.baobab.admin.dao.dailyReport.DailyReportService;
import com.baobab.admin.dao.event.AdminEventService;
import com.baobab.admin.dao.mainImg.MainImgDAO;
import com.baobab.admin.dao.mainImg.MainImgService;
import com.baobab.admin.dao.mainList.MainListDAO;
import com.baobab.admin.dao.mainList.MainListService;
import com.baobab.admin.dao.mainpage.MainpageService;
import com.baobab.admin.dao.meetinglog.MeetLogSevice;
import com.baobab.admin.dao.meetinglog.MeetingLogDAO;
import com.baobab.admin.dao.notice.NoticeDAO;
import com.baobab.admin.dao.notice.NoticeService;
import com.baobab.admin.dao.owner.OwnerDAO;
import com.baobab.admin.dao.owner.OwnerService;
import com.baobab.admin.dao.payment.AdminPaymentDAO;
import com.baobab.admin.dao.payment.AdminPaymentService;
import com.baobab.admin.dao.push.AdminPushDAO;
import com.baobab.admin.dao.push.AdminPushService;
import com.baobab.admin.dao.user.AdminUserDAO;
import com.baobab.admin.dao.user.AdminUserService;
import com.baobab.admin.service.geo.AdminGeocodingService;
import com.baobab.m.service.iamport.ImportServiceInterface;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Controller
public class AdminController {
	
	@Autowired
	AdminLoginDAO login;
	@Autowired
	AdminMainDAO main;
	@Autowired
	AdminNoticeDAO noti;
	@Autowired
	AdminVersionDAO ver;
	@Autowired
	AdminCodeChangeDAO cc;
	@Autowired
	AdminSearchWordDAO rank;
	@Autowired
	AlmightyDAO alm;
	
	/* v2 */
	@Autowired
	MainpageService mainpage;
	@Autowired
	NoticeDAO notice;
	@Autowired
	NoticeService notiService;
	@Autowired
	AdminPushDAO adPush;
	@Autowired 
	AdminPushService adPushService;
	@Autowired
	AdminUserDAO user;
	@Autowired
	AdminUserService userService;
	@Autowired
	OwnerDAO owner;
	@Autowired
	OwnerService ownerService;
	@Autowired
	CpDAO cp;
	@Autowired
	CpService cpService;
	@Autowired
	MainImgDAO mainImg;
	@Autowired
	MainImgService miService;
	@Autowired
	AdminPaymentDAO pay;
	@Autowired
	AdminPaymentService payService;
	@Autowired
	AppDAO app;
	@Autowired
	AdminGeocodingService geo;
	@Autowired
	ImportServiceInterface bankCheck;
	@Autowired
	DailyReportDAO dailyR;
	@Autowired
	DailyReportService dailyService;
	@Autowired
	AdminEventService eventService;
	@Autowired
	MeetingLogDAO meet;
	@Autowired
	MeetLogSevice meetS;
	@Autowired
	MainListDAO mList;
	@Autowired
	MainListService mListService;
	
	@RequestMapping("*/admin/home.api")
	public String admin(HttpSession session) {
		session.setAttribute("id", null);
		session.setAttribute("pw", null);
		return "admin/home";
	}
	
	@RequestMapping("*/error/error.api")
	public String error() {
		return "admin/error";
	}
	
	@RequestMapping("*/admin/main.api")
	public String main(Model model, HttpSession session) {
		return main.makeMainPage(model, session);
	}
	
	@RequestMapping("*/admin/noticeInput.api")
	public String noticeInput(Model model, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		return "admin/noticeInput";
	}
	
	@RequestMapping(value="*/admin/noticeList.api", method=RequestMethod.POST)
	public String noticeList(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("loginHistory", main.loginHistory(session));
		model.addAttribute("noticeList", noti.adminSelect(request));
		return "admin/noticeList";
	}
	
	@RequestMapping(value="*/admin/pushDetail.api", method=RequestMethod.POST)
	public String pushDetail() {
		return "admin/pushDetail";
	}
	
	@RequestMapping(value="*/admin/version.api")
	public String version(Model model) {
		model.addAttribute("curVersion", String.valueOf(ver.getVersion()));
		return "admin/versionUp";
	}
	
	@RequestMapping(value="*/admin/versionUp.api", method=RequestMethod.POST)
	public String versionUp(Model model, HttpServletRequest request) {
		model.addAttribute("version", ver.upVersion(request));
		return "admin/versionCheck";
	}
	
	@RequestMapping(value="*/admin/account.api")
	public String account() {
		return "admin/account";
	}
	
	@RequestMapping(value="*/admin/accountInsert.api", method=RequestMethod.POST)
	public String accountInsert(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("result", login.accountInsert(request, session));
		return "admin/accountCheck";
	}
	
	@RequestMapping(value="*/admin/codeChange.api")
	public String codeChange() {
		return "admin/codeChange";
	}
	
	@RequestMapping(value="*/admin/codeChangeInit.api", method=RequestMethod.POST)
	public String codeChangeInit(Model model, HttpServletRequest request) {
		model.addAttribute("result", cc.codeChange(request));
		return "admin/codeChangeInit";
	}
	
	@RequestMapping(value="*/admin/searchWord.api", method=RequestMethod.POST)
	public String searchWord(Model model) {
		model.addAttribute("kindList", rank.kindRank());
		model.addAttribute("wordList", rank.wordRank());
		return "admin/searchWord";
	}
	
	@RequestMapping(value="*/admin/checkServer.api")
	public String getCheckServer(Model model) {
		model.addAttribute("curServer",ver.getCheckServer());
		return "admin/checkServerUp";
	}
	
	@RequestMapping(value="*/admin/checkServerUp.api", method=RequestMethod.POST)
	public String checkServer(Model model, HttpServletRequest request) {
		model.addAttribute("server", ver.checkServer(request));
		return "admin/checkingServer";
	}
	
	@RequestMapping(value="*/admin/almightySearch.api", method=RequestMethod.POST)
	public String almightySearch(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(alm.cpSearch(request.getParameter("searchWord"))));
		return "getMyStoreInfo";
	}
	
	@RequestMapping(value="*/admin/almightyLogin.api", method=RequestMethod.POST)
	public String almightyLogin(Model model, HttpServletRequest request) {
		Gson gson = new Gson();
		model.addAttribute("json", gson.toJson(alm.almightyLogin(request)));
		return "getMyStoreInfo";	
	}
	
	@RequestMapping(value="*/admin/inputReview.api", method=RequestMethod.GET)
	public String inputReview(Model model) {
		return "admin/makeReview";
	}
	
	@RequestMapping(value="*/admin/cpSearch.api", method=RequestMethod.GET)
	public String cpSearch(Model model) {
		return "admin/cpSearchPopup";
	}
	
	//v2
	
	@RequestMapping(value="*/admin/mainpage.api", method=RequestMethod.GET)
	public String mainpage(Model model) {
		model.addAttribute("vo", mainpage.getMainPageVO());
		return "admin/mainpage";
	}
	
	@RequestMapping(value="*/admin.api")
	public String wellcomeAdmin(HttpSession session) {
		session.invalidate();
		return "admin";
	}
	
	@RequestMapping(value="*/admin/loginConfirm.api", method=RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("logResult", login.login(request.getParameter("id"), request.getParameter("password"), session));
		model.addAttribute("email", request.getParameter("id"));
		return "admin/loginConfirm";
	}
	
	@RequestMapping(value="*/admin/adminSign.api", method=RequestMethod.GET)
	public String adminSign(Model model, @RequestParam String email) {
		model.addAttribute("vo", user.defaultInfo(email));
		return "admin/adminSign";
	}
	
	@RequestMapping(value="*/admin/adminSignConfirm.api", method=RequestMethod.POST)
	public String adminSignConfirm(Model model, HttpServletRequest request) {
		model.addAttribute("result", user.insertAdmin(request));
		model.addAttribute("url", "관리자등록");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/noticepage.api", method=RequestMethod.GET)
	public String noticepage(Model model, @RequestParam int result) {
		model.addAttribute("result", result);
		model.addAttribute("vo", notice.selectNotice());
		return "admin/adminNotice";
	}
	
	@RequestMapping(value="*/admin/noticeDetail.api", method=RequestMethod.GET)
	public String noticeDetail(Model model, @RequestParam int seq, @RequestParam int result) {
		model.addAttribute("vo", notice.detail(seq));
		model.addAttribute("result", result);
		return "admin/notiDetail";
	}
	
	@RequestMapping(value="*/admin/noticeInsert.api")
	public String noticeInsert() {
		return "admin/noticeInsert";
	}
	
	@RequestMapping(value="*/admin/notiInput.api", method=RequestMethod.POST)
	public String notiInput(HttpServletRequest request, HttpSession session, Model model) throws IOException {
		model.addAttribute("result", notiService.noticeInit(request, session));
		model.addAttribute("url", "./noticepage.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/notipush.api", method=RequestMethod.POST)
	public String notiInput(HttpServletRequest request, Model model) throws IOException {
		model.addAttribute("result", notiService.sendNotice(request));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("seq_num")));
		model.addAttribute("url", "./noticeDetail.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/eventPush.api", method=RequestMethod.GET)
	public String eventPush(Model model, @RequestParam int result) {
		model.addAttribute("vo", adPush.selectList());
		model.addAttribute("result", result);
		return "admin/eventPushList";
	}
	
	@RequestMapping(value="*/admin/pushDetail.api", method=RequestMethod.GET)
	public String pushDetail(Model model, @RequestParam int seq, @RequestParam int result) {
		model.addAttribute("vo", adPush.detail(seq));
		model.addAttribute("result", result);
		return "admin/pushDetail";
	}
	
	@RequestMapping(value="*/admin/adpush.api", method=RequestMethod.POST)
	public String adpush(HttpServletRequest request, HttpSession session, Model model) throws IOException {
		model.addAttribute("result", adPushService.adminPushInit(request, session));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("seq_num")));
		model.addAttribute("url", "./pushDetail.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/pushInsert.api")
	public String pushInsert() {
		return "admin/pushInsert";
	}
	
	@RequestMapping(value="*/admin/adpushFirst.api", method=RequestMethod.POST)
	public String adpushFirst(HttpServletRequest request, HttpSession session, Model model) throws IOException{
		model.addAttribute("result", adPushService.adminPushInit(request, session));
		model.addAttribute("url", "./eventPushList.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/userList.api")
	public String userList(Model model) {
		model.addAttribute("vo", user.selectUser());
		return "admin/userList";
	}
	
	@RequestMapping(value="*/admin/userDetail.api", method=RequestMethod.GET)
	public String userDetail(Model model, @RequestParam String email) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, DecoderException {
		model.addAttribute("vo", userService.userInfo(email));
		return "admin/userDetail";
	}
	
	@RequestMapping(value="*/admin/ownerList.api")
	public String ownerList(Model model) {
		model.addAttribute("vo", owner.cpUserListSelect());
		return "admin/ownerList";
	}
	
	@RequestMapping(value="*/admin/ownerDetail.api", method=RequestMethod.GET)
	public String ownerDetail(Model model, @RequestParam String email) {
		model.addAttribute("vo", ownerService.getVo(email));
		return "admin/ownerDetail";
	}
	
	@RequestMapping(value="*/admin/cpList.api")
	public String cpList(Model model) {
		model.addAttribute("vo", cp.cpList());
		return "admin/cpList";
	}
	
	@RequestMapping(value="*/admin/cpDetail.api", method=RequestMethod.GET)
	public String cpDetail(Model model, @RequestParam int cpSeq, @RequestParam int result) {
		model.addAttribute("vo", cpService.getVo(cpSeq));
		return "admin/cpDetail";
	}
	
	@RequestMapping(value="*/admin/cpInfoUpdate.api")
	public String cpInfoUpdate(Model model, @RequestParam int cpSeq) {
		model.addAttribute("vo", cp.defaultInfo(cpSeq));
		return "admin/cpInfoUpdate";
	}
	
	@RequestMapping(value="*/admin/infoUpdate.api", method=RequestMethod.POST)
	public String cpInfoUpdate(Model model, HttpServletRequest request) {
		model.addAttribute("result", cpService.infoUpdate(request));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("cpSeq")));
		model.addAttribute("url", "./cpDetail.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/mainImgInfo.api", method=RequestMethod.GET)
	public String mainImgInfo(Model model, @RequestParam int cpSeq, @RequestParam String cpName) {
		model.addAttribute("vo", mainImg.getImgs(cpSeq));
		model.addAttribute("cpName", cpName);
		model.addAttribute("cpSeq", cpSeq);
		return "admin/mainImgInfo";
	}
	
	@RequestMapping(value="*/admin/uploadImg.api", method=RequestMethod.POST)
	public String uploadImg(Model model, MultipartHttpServletRequest request) throws IOException {
		String cpName = request.getParameter("cpName");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		miService.imgUpload(cpName, cpSeq, request.getFiles("imgs"));
		model.addAttribute("cpSeq", cpSeq);
		model.addAttribute("vo", mainImg.getImgs(cpSeq));
		model.addAttribute("cpName", cpName);
		return "admin/mainImgInfo";
	}
	
	@RequestMapping(value="*/admin/deleteMainImg.api", method=RequestMethod.POST)
	public String deleteMainImg(Model model, HttpServletRequest request) throws Exception {
		String cpName = request.getParameter("cpName");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		mainImg.deleteImg(cpSeq, request.getParameter("url"));
		model.addAttribute("cpSeq", cpSeq);
		model.addAttribute("vo", mainImg.getImgs(cpSeq));
		model.addAttribute("cpName", cpName);
		return "admin/mainImgInfo";
	}
	
	@RequestMapping(value="*/admin/updateImg.api", method=RequestMethod.POST)
	public String updateImg(Model model, MultipartHttpServletRequest request) throws IOException {
		miService.imgUpdate(request.getFile("img"), request.getParameter("url"));
		String cpName = request.getParameter("cpName");
		int cpSeq = Integer.parseInt(request.getParameter("cpSeq"));
		model.addAttribute("cpSeq", cpSeq);
		model.addAttribute("vo", mainImg.getImgs(cpSeq));
		model.addAttribute("cpName", cpName);
		return "admin/mainImgInfo";
	}
	
	@RequestMapping(value="*/admin/payHistory.api")
	public String payHistory(Model model) {
		model.addAttribute("vo", pay.selectPayList());
		return "admin/payHistory";
	}
	
	@RequestMapping(value="*/admin/payDetail.api", method=RequestMethod.GET)
	public String payDetail(Model model, @RequestParam String orderNum) {
		model.addAttribute("vo", payService.getData(orderNum));
		return "admin/payDetail";
	}
	
	@RequestMapping(value="*/admin/appInfo.api")
	public String appInfo(Model model) {
		model.addAttribute("vo", app.dataSelect());
		return "admin/appInfo";
	}
	
	@RequestMapping(value="*/admin/updateAppInfo.api", method=RequestMethod.POST)
	public String updateAppInfo(Model model, HttpServletRequest request) {
		model.addAttribute("vo", app.dataSelect());
		return "admin/appInfo";
	}
	
	@RequestMapping(value="*/admin/addrConversion.api")
	public String addrConversion() {
		return "admin/addrConversion";
	}
	
	@RequestMapping(value="*/admin/adminGeo.api", method=RequestMethod.POST)
	public String adminGeo(Model model, HttpServletRequest request) {
		model.addAttribute("lonlat", geo.geo(request.getParameter("addr")));
		return "admin/addrConversion";
	}
	
	@RequestMapping(value="*/admin/bankAccount.api")
	public String bankAccount() {
		return "admin/bankAccount";
	}
	
	@RequestMapping(value="*/admin/adminBAC.api", method=RequestMethod.POST)
	public String adminBAC(Model model, HttpServletRequest request) throws JsonSyntaxException, IOException {
		model.addAttribute("holder", bankCheck.accountCert(request));
		model.addAttribute("bank", request.getParameter("bank"));
		model.addAttribute("account", request.getParameter("account"));
		return "admin/bankAccount";
	}
	
	@RequestMapping(value="*/admin/dailyReport.api")
	public String dailyReport(Model model) {
		model.addAttribute("vo", dailyR.selectAll());
		return "admin/dailyReport";
	}
	
	@RequestMapping(value="*/admin/reportInsert.api")
	public String reportInsert(Model model, HttpSession session) {
		model.addAttribute("bj", dailyR.getBeforeJob(session.getAttribute("id").toString()));
		return "admin/reportInsert";
	}
	
	@RequestMapping(value="*/admin/reportInsertSuccess.api", method=RequestMethod.POST)
	public String reportInsertSuccess(Model model, HttpServletRequest request) {
		dailyR.insertReport(request);
		model.addAttribute("url", "./dailyReport.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/reportDetail.api", method=RequestMethod.GET)
	public String reportDetail(Model model, HttpSession session, @RequestParam int seq, @RequestParam String email) {
		model.addAttribute("seq", seq);
		model.addAttribute("result", dailyService.checkDivCode(session, email));
		return "admin/dailyDivCheck";
	}
	
	@RequestMapping(value="*/admin/dailyDetail.api", method=RequestMethod.GET)
	public String dailyDetail(Model model, @RequestParam int seq) {
		model.addAttribute("vo", dailyR.selectOne(seq));
		return "admin/dailyDetail";
	}
	
	@RequestMapping(value="*/admin/updateReport.api", method=RequestMethod.POST)
	public String updateReport() {
		return "admin/reportUpdate";
	}
	
	@RequestMapping(value="*/admin/updateReportSuccess.api", method=RequestMethod.POST)
	public String updateReportSuccess(Model model, HttpServletRequest request) {
		dailyR.updateReport(request);
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("seq")));
		model.addAttribute("url", "./dailyDetail.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/eventDetail.api", method=RequestMethod.GET)
	public String eventDetail(Model model, @RequestParam String serial) {
		model.addAttribute("vo", cpService.getEvent(serial));
		return "admin/eventDetail";
	}
	
	@RequestMapping(value="*/admin/updateEvent.api", method=RequestMethod.POST)
	public String updateEvent(Model model, HttpServletRequest request) {
		model.addAttribute("result", eventService.eventUpdate(request));
		model.addAttribute("url", "./eventDetail.api");
		model.addAttribute("serial", request.getParameter("serial"));
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/deleteEvent.api", method=RequestMethod.POST)
	public String deleteEvent(Model model, HttpServletRequest request) {
		return eventService.eventDelete(model, request);
	}
	
	@RequestMapping(value="*/admin/optionDetail.api", method=RequestMethod.GET)
	public String optionDetail(Model model, @RequestParam String serial, @RequestParam int cpSeq) {
		model.addAttribute("vo", cpService.getOption(serial));
		model.addAttribute("serials", cp.selectEventSerials(cpSeq));
		model.addAttribute("cpSeq", cpSeq);
		return "admin/optionDetail";
	}
	
	@RequestMapping(value="*/admin/updateOption.api", method=RequestMethod.POST)
	public String updateOption(Model model, HttpServletRequest request) {
		model.addAttribute("result", eventService.optionUpdate(request));
		model.addAttribute("url", "./optionDetail.api");
		model.addAttribute("serial", request.getParameter("optionSerial"));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("cpSeq")));
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/deleteOption.api", method=RequestMethod.POST)
	public String deleteOption(Model model, HttpServletRequest request) {
		return eventService.optionDelete(model, request);
	}
	
	@RequestMapping(value="*/admin/eventMenuDetail.api", method=RequestMethod.GET)
	public String eventMenuDetail(Model model, @RequestParam int seq, @RequestParam int cpSeq) {
		model.addAttribute("serials", cp.selectOptionSerials(cpSeq));
		model.addAttribute("vo", cp.oneMenu(seq));
		model.addAttribute("cpSeq", cpSeq);
		return "admin/eventMenuDetail";
	}
	
	@RequestMapping(value="*/admin/updateEventMenu.api", method=RequestMethod.POST)
	public String updateEventMenu(Model model, HttpServletRequest request) {
		model.addAttribute("result", eventService.menuUpdate(request));
		model.addAttribute("url", "./eventMenuDetail.api");
		model.addAttribute("seq", Integer.parseInt(request.getParameter("seqNum")));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("cpSeq")));
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/deleteEventMenu.api", method=RequestMethod.POST)
	public String deleteEventMenu(Model model, HttpServletRequest request) {
		return eventService.menuDelete(model, request);
	}
	
	@RequestMapping(value="*/admin/eventAdd.api", method=RequestMethod.GET)
	public String eventAdd(Model model, @RequestParam int cpSeq) {
		model.addAttribute("cpSeq", cpSeq);
		return "admin/eventAdd";
	}
	
	@RequestMapping(value="*/admin/eventaddSuccess.api", method=RequestMethod.POST)
	public String eventaddSuccess(Model model, HttpServletRequest request ) {
		return eventService.insertAllEventInfo(model, request);
	}
	
	@RequestMapping(value="*/admin/eventOptionAdd.api", method=RequestMethod.GET)
	public String eventOptionAdd(Model model, @RequestParam String es, @RequestParam int cpSeq) {
		model.addAttribute("eventSerial", es);
		model.addAttribute("cpSeq", cpSeq);
		return "admin/eventOptionAdd";
	}
	
	@RequestMapping(value="*/admin/optionaddSuccess.api", method=RequestMethod.POST)
	public String optionaddSuccess(Model model, HttpServletRequest request) {
		return eventService.optionInsert(model, request);
	}
	
	@RequestMapping(value="*/admin/eventMenuAdd.api", method=RequestMethod.GET)
	public String eventMenuAdd(Model model, @RequestParam String os, @RequestParam int cpSeq) {
		model.addAttribute("optionSerial", os);
		model.addAttribute("cpSeq", cpSeq);
		return "admin/eventMenuAdd";
	}
	
	@RequestMapping(value="*/admin/menuaddSuccess.api", method=RequestMethod.POST)
	public String menuaddSuccess(Model model, HttpServletRequest request) {
		return eventService.menuInsert(model, request);
	}
	
	@RequestMapping(value="*/admin/cpDelete.api", method=RequestMethod.POST)
	public String cpDelete(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("result", cpService.deleteCp(request));
		model.addAttribute("url", "업체삭제");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/meetingLog.api", method=RequestMethod.GET)
	public String meetingLog(Model model) {
		model.addAttribute("vo", meet.selectAll());
		return "admin/meetingLog";
	}
	
	@RequestMapping(value="*/admin/meetLogInsert.api")
	public String meetLogInsert(Model model) {
		model.addAttribute("adminList", meet.selectAdminInfo());
		return "admin/meetingLogInsert";
	}
	
	@RequestMapping(value="*/admin/meetLogInsertSuccess.api", method=RequestMethod.POST)
	public String meetLogInsertSuccess(Model model, HttpServletRequest request) throws ParseException {
		meetS.insertML(request);
		model.addAttribute("vo", meet.selectAll());
		return "admin/meetingLog";
	}
	
	@RequestMapping(value="*/admin/mlDetail.api", method=RequestMethod.GET)
	public String mlDetail(Model model, @RequestParam int seq) {
		model.addAttribute("vo", meet.selectDetail(seq));
		return "admin/meetLogDetail";
	}
	
	@RequestMapping(value="*/admin/mlUpdate.api", method=RequestMethod.GET)
	public String mlUpdate(Model model, @RequestParam int seq) {
		model.addAttribute("vo", meet.selectDetail(seq));
		model.addAttribute("adminList", meet.selectAdminInfo());
		return "admin/meetLogUpdate";
	}
	
	@RequestMapping(value="*/admin/meetLogUpdate.api", method=RequestMethod.POST)
	public String meetLogUpdate(Model model, HttpServletRequest request) throws ParseException {
		model.addAttribute("result", meetS.updateML(request));
		model.addAttribute("url", "./mlDetail.api?seq=" + request.getParameter("seqNum"));
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/listUpdate.api", method=RequestMethod.GET)
	public String listUpdate(Model model) {
		return mListService.selectTitlts(model);
	}
	
	@RequestMapping(value="*/admin/mainListTitleUpdate.api", method=RequestMethod.POST)
	public String mainListTitleUpdate(Model model, HttpServletRequest request) {
		model.addAttribute("result", mListService.updateTitlts(request));
		model.addAttribute("url", "./listUpdate.api");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/mainListCp.api", method=RequestMethod.GET)
	public String mainListCp(Model model) {
		return mListService.cpListSelect(model);
	}
	
	@RequestMapping(value="*/admin/selectMain.api", method=RequestMethod.GET)
	public String selectMain(Model model, @RequestParam int cpSeq) {
		model.addAttribute("cpSeq", cpSeq);
		model.addAttribute("titleList", mList.selectTitle());
		model.addAttribute("menuList", mList.selectMenus(cpSeq));
		model.addAttribute("imgList", mList.selectImgs(cpSeq));
		return "admin/mainCpSelect";
	}
	
	@RequestMapping(value="*/admin/insertMainList.api", method=RequestMethod.POST)
	public String insertMainList(Model model, HttpServletRequest request) {
		model.addAttribute("result", mListService.insertCp(request));
		model.addAttribute("url", "메인리스트 업체 저장");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/mainListDetail.api", method=RequestMethod.GET)
	public String mainListDetail(Model model, @RequestParam int cpSeq) {
		mListService.cpOneSelect(model, cpSeq);
		return "admin/mainCpDetail";
	}
	
	@RequestMapping(value="*/admin/mainListDelete.api", method=RequestMethod.GET)
	public String mainListDelete(Model model, @RequestParam int seq) {
		model.addAttribute("result", mList.deleteCp(seq));
		model.addAttribute("url", "메인리스트 업체 삭제");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/mainListUpdate.api", method=RequestMethod.GET)
	public String mainListUpdate(Model model, @RequestParam int cpSeq) {
		mListService.cpOneSelect(model, cpSeq);
		model.addAttribute("cpSeq", cpSeq);
		model.addAttribute("titleList", mList.selectTitle());
		model.addAttribute("menuList", mList.selectMenus(cpSeq));
		model.addAttribute("imgList", mList.selectImgs(cpSeq));
		return "admin/mainCpUpdate";
	}
	
	@RequestMapping(value="*/admin/updateMainList.api", method=RequestMethod.POST)
	public String updateMainList(Model model, HttpServletRequest request) {
		model.addAttribute("result", mListService.updateMainCp(request));
		model.addAttribute("url", "메인리스트 업체 수정");
		return "admin/adminRedirect";
	}
	
	@RequestMapping(value="*/admin/logoUpdate.api", method=RequestMethod.POST)
	public String logoUpdate(Model model, MultipartHttpServletRequest request) throws IOException {
		model.addAttribute("result", miService.logoUpdate(request));
		model.addAttribute("cpSeq", Integer.parseInt(request.getParameter("cpSeq")));
		model.addAttribute("url", "./cpDetail.api");
		return "admin/adminRedirect";
	}
}
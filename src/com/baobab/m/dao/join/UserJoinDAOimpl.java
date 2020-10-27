package com.baobab.m.dao.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.baobab.m.service.ftp.FtpClient;
import com.baobab.m.service.rsa.Sha256;
import com.baobab.m.vo.MeCertVO;
import com.baobab.m.vo.UserAllVO;
import com.baobab.m.vo.UserHistoryVO;

@Repository
public class UserJoinDAOimpl implements UserJoinDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate join;

	@Override
	public int userAllJoin(MeCertVO mvo, String email, String pw, String pushAgree, String nickName) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setUser_password(pw);
		vo.setPhon_num(mvo.getPhoneNo());
		vo.setPush_agree(pushAgree);
		if(mvo.getName().equals("") || mvo.getName() == null) {
			vo.setUserName(mvo.getM_name());
			vo.setGender(Integer.parseInt(mvo.getM_Gender()));
		}else {
			vo.setUserName(mvo.getName());
			vo.setGender(Integer.parseInt(mvo.getGender()));
		}
		vo.setPhone_corp(mvo.getPhoneCorp());
		vo.setDiv_code("u-01-01");
		vo.setBirth(mvo.getBirthDay());
		vo.setNation(Integer.parseInt(mvo.getNation()));
		vo.setNickName(nickName);
		int result = join.insert("com.baobab.m.dao.UserJoinMapper.userAllJoin", vo);
		userHistoryJoin(email);
		//insertUserMarketing(vo);
		return result;
	}

	@Override
	public void userHistoryJoin(String email) {
		UserHistoryVO vo = new UserHistoryVO();
		vo.setEmail(email);
		join.update("com.baobab.m.dao.UserJoinMapper.userHistoryJoin", vo);
	}

	@Override
	public String getUserPhone(String email) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.getUserPhone", email);
	}

	@Override
	public String getCpPhone(int cpSeq) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.getCpPhone", cpSeq);
	}

	@Override
	public void userInfoChange(String email, String password, String pushCheck) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setUser_password(password);
		vo.setPush_agree(pushCheck);
		join.update("com.baobab.m.dao.UserJoinMapper.userInfoChange", vo);
	}

	@Override
	public void leaveUserAll(String email) {
		join.update("com.baobab.m.dao.UserJoinMapper.leaveUserAll", email);
		leaveUserHistory(email);
	}

	@Override
	public void leaveUserHistory(String email) {
		join.update("com.baobab.m.dao.UserJoinMapper.leaveUserHistory", email);
	}

	@Override
	public int userCodeUpdate(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(request.getParameter("email"));
		vo.setDiv_code(request.getParameter("divCode"));
		return join.update("com.baobab.m.dao.UserJoinMapper.userCodeUpdate", vo);
	}

	@Override
	public List<UserAllVO> dupEmail(HttpServletRequest request) {
		return join.selectList("com.baobab.m.dao.UserJoinMapper.dupEmail", request.getParameter("email"));
	}

	@Override
	public int emailCheck(HttpServletRequest request) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(request.getParameter("email"));
		vo.setPhon_num(request.getParameter("phone"));
		return join.selectList("com.baobab.m.dao.UserJoinMapper.emailCheck", vo).size();
	}
	
	@Override
	   public int point(String email) {
	      UserAllVO vo = new UserAllVO();
	      vo.setEmail(email);
	      return join.update("com.baobab.m.dao.UserJoinMapper.userPointUp",email);
	}

	@Override
	public int nowPoint(String email) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.userNowPoint",email);
	}

	@Override
	public int profileDelete(HttpServletRequest request) throws Exception {
		FtpClient ftp = new FtpClient();
		String url = request.getParameter("url");
		String fileName = url.split("/")[url.split("/").length - 1];
		return join.update("com.baobab.m.dao.UserJoinMapper.profileDelete", request.getParameter("email")) + ftp.deleteFile("/profileImg/", fileName);
	}

	@Override
	public String setProfile(MultipartHttpServletRequest request) throws Exception {
		List<UserAllVO> checkList = nickNameCheck(request.getParameter("nickName"));
		if(checkList.size() == 0) {
			UserAllVO vo = new UserAllVO();
			FtpClient ftp = new FtpClient();
			
			String beforeUrl = selectProfileImg(request.getParameter("email"));
			if(!beforeUrl.equals("이미지없음") && beforeUrl.startsWith("http")) {
				String fileName = beforeUrl.split("/")[beforeUrl.split("/").length - 1];
				ftp.deleteFile("/profileImg/", fileName);
			}
			
			vo.setEmail(request.getParameter("email"));
			vo.setNickName(request.getParameter("nickName"));
			
			String url;
			if(request.getFile("profileImg") == null) {
				url = "이미지없음";
			}else {
				url = ftp.ftp(ftp.convert(request.getFile("profileImg")), setImgName(vo.getEmail()), "/profileImg/");
			}
			
			vo.setProfileImg(url);
			join.update("com.baobab.m.dao.UserJoinMapper.setProfile", vo);
			return url;
		}else {
			return "dup";
		}
	}

	private String setImgName(String email) {
		return email.split("@")[0] + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public List<UserAllVO> nickNameCheck(String nickName) {
		return join.selectList("com.baobab.m.dao.UserJoinMapper.nickNameCheck", nickName);
	}

	@Override
	public String selectProfileImg(String email) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.selectProfileImg", email);
	}

	@Override
	public UserAllVO userDataCheck(String email) {
		return join.selectOne("com.baobab.m.dao.UserJoinMapper.userDataCheck", email);
	}

	@Override
	public int userDataAdd(MeCertVO mvo, String email) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		vo.setBirth(mvo.getBirthDay());
		if(mvo.getName().equals("") || mvo.getName() == null) {
			vo.setUserName(mvo.getM_name());
			vo.setGender(Integer.parseInt(mvo.getM_Gender()));
		}else {
			vo.setUserName(mvo.getName());
			vo.setGender(Integer.parseInt(mvo.getGender()));
		}
		vo.setNation(Integer.parseInt(mvo.getNation()));
		vo.setPhone_corp(mvo.getPhoneCorp());
		return join.update("com.baobab.m.dao.UserJoinMapper.userDataAdd", vo);
	}

	@Override
	public UserAllVO getUserDataForMarketing(MeCertVO mvo, String email, String pw, String pushAgree, String nickName) {
		UserAllVO vo = new UserAllVO();
		vo.setEmail(email);
		Sha256 sha = new Sha256();
		vo.setUser_password(sha.sha256(pw));
		vo.setPhon_num(mvo.getPhoneNo());
		vo.setPush_agree(pushAgree);
		if(mvo.getName().equals("") || mvo.getName() == null) {
			vo.setUserName(mvo.getM_name());
			vo.setGender(Integer.parseInt(mvo.getM_Gender()));
		}else {
			vo.setUserName(mvo.getName());
			vo.setGender(Integer.parseInt(mvo.getGender()));
		}
		vo.setPhone_corp(mvo.getPhoneCorp());
		vo.setDiv_code("u-01-01");
		vo.setBirth(mvo.getBirthDay());
		vo.setNation(Integer.parseInt(mvo.getNation()));
		vo.setNickName(nickName);
		return vo;
	}

	@Override
	public void insertUserMarketing(UserAllVO vo) {
		Connection con = null;
		PreparedStatement st = null;
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://baobabtestserver.cafe24.com:3306/baobabtestserver?autoReconnect=true",
					"baobabtestserver", "baobab858!@");
			
			String sql = "insert into userData (email, pw, userName, phoneNum, phoneCorp, divCode, birth, gender, nation, marketingAgree, nickName, joinDate)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate())";
			st = con.prepareStatement(sql);
			st.setString(1, vo.getEmail());
			st.setString(2, vo.getUser_password());
			st.setString(3, vo.getUserName());
			st.setString(4, vo.getPhon_num());
			st.setString(5, vo.getPhone_corp());
			st.setString(6, vo.getDiv_code());
			st.setString(7, vo.getBirth());
			st.setInt(8, vo.getGender());
			st.setInt(9, vo.getNation());
			st.setString(10, vo.getPush_agree());
			st.setString(11, vo.getNickName());
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(st!=null)try {st.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}
	}

	@Override
	public int emailDup(String email) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://baobab858.com:3306/baobab858?autoReconnect=true",
					"baobab858", "baobab858!@");
			
			String sql = "select count(*) as num from user_all where email = '" + email + "'";
			st = con.prepareStatement(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				result = rs.getInt("num");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(st!=null)try {st.close();}catch(SQLException e) {}
			if(con!=null)try {con.close();}catch(SQLException e) {}
		}
		return result;
	}
}

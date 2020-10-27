package com.baobab.m.service.join;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobab.m.dao.join.UserJoinDAO;
import com.baobab.m.vo.UserAllVO;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	UserJoinDAO user;
	
	@Override
	public int duplicateCheck(HttpServletRequest request) {
		List<UserAllVO> dupList = user.dupEmail(request);
		if(dupList.isEmpty()) {
			return 1;
		}else if(dupList.get(0).getDiv_code().equals("u-01-02")){
			return 10;
		}else {
			return 0;
		}
	}

	@Override
	public int cpJoining(HttpServletRequest request) {
		return 0;
	}

}

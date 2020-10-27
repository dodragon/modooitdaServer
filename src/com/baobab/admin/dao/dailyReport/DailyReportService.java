package com.baobab.admin.dao.dailyReport;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyReportService {
	
	@Autowired
	DailyReportDAO dao;
	
	public int checkDivCode(HttpSession session, String email) {
		String readerCode = session.getAttribute("divCode").toString();
		String writerCode = dao.divCodeCheck(email);
		
		int rTeamNumber = Integer.parseInt(readerCode.split("-")[1]);
		int wTeamNumber = Integer.parseInt(writerCode.split("-")[1]);
		
		int rClassNumber = Integer.parseInt(readerCode.split("-")[2]);
		int wClassNumber = Integer.parseInt(writerCode.split("-")[2]);
		
		if(rTeamNumber == 1) {
			//대표 및 이사 == 승인 허가
			return 0;
		}else if(rTeamNumber != wTeamNumber) {
			//팀 넘버가 다른 경우
			if(rClassNumber == 1) {
				//부장
				if(wTeamNumber != 1) {
					//부장일 시  대표 및 이사진 제외 == 승인 허가
					return 0;
				}else {
					//부장일 시  대표 및 이사진  == 승인 취소
					return 1;
				}
			}else {
				//부장이 아닐 시 == 승인 취소
				return 1;
			}
		}else {
			//팀 넘버가 같은 경우
			if(rClassNumber >= wClassNumber) {
				//동일직급 및 그 이상인 경우 == 승인 허가
				return 0;
			}else {
				//하위 직급인 경우 == 승인 취소
				return 1;
			}
		}
	}
}

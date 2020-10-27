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
			//��ǥ �� �̻� == ���� �㰡
			return 0;
		}else if(rTeamNumber != wTeamNumber) {
			//�� �ѹ��� �ٸ� ���
			if(rClassNumber == 1) {
				//����
				if(wTeamNumber != 1) {
					//������ ��  ��ǥ �� �̻��� ���� == ���� �㰡
					return 0;
				}else {
					//������ ��  ��ǥ �� �̻���  == ���� ���
					return 1;
				}
			}else {
				//������ �ƴ� �� == ���� ���
				return 1;
			}
		}else {
			//�� �ѹ��� ���� ���
			if(rClassNumber >= wClassNumber) {
				//�������� �� �� �̻��� ��� == ���� �㰡
				return 0;
			}else {
				//���� ������ ��� == ���� ���
				return 1;
			}
		}
	}
}

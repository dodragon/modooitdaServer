package com.baobab.m.service.rsa;

import java.util.Random;

public class RandomNumber {
	
	private int length;
	private int dupCode;
	
	
	
	public RandomNumber(int length, int dupCode) {
		super();
		this.length = length;
		this.dupCode = dupCode;
	}

	public String numberGen() {
        Random rand = new Random();
        String numStr = ""; //������ ����� ����

        for(int i=0;i<length;i++) {

            //0~9 ���� ���� ����
            String ran = Integer.toString(rand.nextInt(10));

            if(dupCode==1) {
                //�ߺ� ���� numStr�� append
                numStr += ran;
            }else if(dupCode==2) {
                //�ߺ��� ������� ������ �ߺ��� ���� �ִ��� �˻��Ѵ�
                if(!numStr.contains(ran)) {
                    //�ߺ��� ���� ������ numStr�� append
                    numStr += ran;
                }else {
                    //������ ������ �ߺ��Ǹ� ��ƾ�� �ٽ� �����Ѵ�
                    i-=1;
                }
            }
        }
        return numStr;
    }
}

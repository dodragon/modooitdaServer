package com.baobab.m.service;

import java.util.Random;

import java.util.Scanner;
//2019-09-05 ���ǹ���...
public class RandomL {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int[] intArr = new int[7];
		Random r = new Random();
		for (int i = 0; i < 7; i++) {
			intArr[i] = r.nextInt(45) + 1;
			for (int j = i - 1; j >= 0; j--) {
				if (intArr[i] == intArr[j]) {
					// intArr[i] = (int)(Math.random()*45)+1;
					//random �Լ��� ���� �ʰ� �̿� ���� ����� ����
					intArr[i] = r.nextInt(45) + 1;
				}
			}
		}
		System.out.println("ID : ����������");
		System.out.println("Fucking Lotto �� ���Ű� ȯ���մϴ�!!");
		System.out.println("�ζ� ��ȣ�� �Է����ּ���(,��������) 6�� : ");
		String lottoStr = scan.nextLine();
		System.out.println("�Է��Ͻ� �ζ� ��ȣ��  " + lottoStr + "  �Դϴ�.");
		String[] lottoArr = lottoStr.split(",");
		int count = 0;
		for (int i = 0; i < 6; i++) {
			int lotto = Integer.parseInt(String.valueOf(lottoArr[i]));
			for (int j = 0; j < 6; j++) {
				if (intArr[j] == lotto) {
					count++;
					System.out.println("���� ���� " + lotto);
				}
			}
		}
		System.out.println("���� ���� �ζ� ��ȣ�� " + count + " �� �Դϴ١�");
		if (count == 7) {
			System.out.println("��÷�Ǿ����ϴ�.");
		}
		System.out.println();
		System.out.println("�̹� �� �ζ� ��ȣ�� ");
		for (int i = 0; i < 7; i++) {
			System.out.print(intArr[i]);
			if (i < 5)
				System.out.print(", ");
			
			if(i==5)
				System.out.println(" + ���ʽ� ����  "+intArr[6]);
		}
		System.out.println(" ��(��) �ǰڽ��ϴ�!");
	}
}

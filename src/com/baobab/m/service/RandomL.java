package com.baobab.m.service;

import java.util.Random;

import java.util.Scanner;
//2019-09-05 무의미한...
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
					//random 함수를 쓰지 않고 이와 같은 방법도 가능
					intArr[i] = r.nextInt(45) + 1;
				}
			}
		}
		System.out.println("ID : 보곱소히♥");
		System.out.println("Fucking Lotto 에 오신걸 환영합니다!!");
		System.out.println("로또 번호를 입력해주세요(,기준으로) 6개 : ");
		String lottoStr = scan.nextLine();
		System.out.println("입력하신 로또 번호는  " + lottoStr + "  입니다.");
		String[] lottoArr = lottoStr.split(",");
		int count = 0;
		for (int i = 0; i < 6; i++) {
			int lotto = Integer.parseInt(String.valueOf(lottoArr[i]));
			for (int j = 0; j < 6; j++) {
				if (intArr[j] == lotto) {
					count++;
					System.out.println("맞은 수는 " + lotto);
				}
			}
		}
		System.out.println("★총 맞은 로또 번호는 " + count + " 개 입니다★");
		if (count == 7) {
			System.out.println("당첨되었습니다.");
		}
		System.out.println();
		System.out.println("이번 주 로또 번호는 ");
		for (int i = 0; i < 7; i++) {
			System.out.print(intArr[i]);
			if (i < 5)
				System.out.print(", ");
			
			if(i==5)
				System.out.println(" + 보너스 숫자  "+intArr[6]);
		}
		System.out.println(" 이(가) 되겠습니다!");
	}
}

package com.baobab.m.service.qrcode;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.baobab.m.service.ftp.FtpClient;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QrcodeFile {

	public static void madeQR(int cpSeq) throws Exception {

		String url = "http://www.naver.com";
		int nCheck = 0;
		String savedFileName = String.valueOf(cpSeq);

		// url 확인
		if (url == null || url.equals("") || !url.startsWith("http")) {
			nCheck = 0;
		} else {
			// 파일 설정
			// 실서버 : tomcat/webapps/ROOT/resources/qrcode/
			File path = new File(
					"tomcat/webapps/ROOT/resources/qrcode/");
			if (!path.exists()) {
				path.mkdirs();
			}

			// QRCode 생성
			QRCodeWriter writer = new QRCodeWriter();
			BitMatrix qrCode = writer.encode(url, BarcodeFormat.QR_CODE, 350, 350);
			BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);

			File qrCodeFile = new File(path, savedFileName + ".png");
			ImageIO.write(qrImage, "PNG", qrCodeFile);

			FtpClient ftp = new FtpClient();
			ftp.ftp(qrCodeFile, savedFileName + ".png", "/cpQRcode/");

			File folder = new File(
					"tomcat/webapps/ROOT/resources/qrcode/");
			if (folder.exists()) {
				File[] folder_list = folder.listFiles(); // 파일리스트 얻어오기

				for (int j = 0; j < folder_list.length; j++) {
					folder_list[j].delete(); // 파일 삭제
					System.out.println("파일이 삭제되었습니다.");
				}	
			}
		}
	}

}

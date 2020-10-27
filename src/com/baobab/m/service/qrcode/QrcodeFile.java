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

		// url Ȯ��
		if (url == null || url.equals("") || !url.startsWith("http")) {
			nCheck = 0;
		} else {
			// ���� ����
			// �Ǽ��� : tomcat/webapps/ROOT/resources/qrcode/
			File path = new File(
					"tomcat/webapps/ROOT/resources/qrcode/");
			if (!path.exists()) {
				path.mkdirs();
			}

			// QRCode ����
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
				File[] folder_list = folder.listFiles(); // ���ϸ���Ʈ ������

				for (int j = 0; j < folder_list.length; j++) {
					folder_list[j].delete(); // ���� ����
					System.out.println("������ �����Ǿ����ϴ�.");
				}	
			}
		}
	}

}

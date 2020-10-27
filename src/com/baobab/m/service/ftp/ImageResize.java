package com.baobab.m.service.ftp;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageResize {
	public File resizeImg(MultipartFile file, String originalFileName, int width, int height) throws IOException {
		try {
			BufferedImage resizeImage = resize(file.getInputStream(), width, height);
			return toFile(toByteArray(toBufferedImage(resizeImage)), originalFileName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static BufferedImage resize(InputStream inputStream, int width, int height)
            throws IOException {
        BufferedImage inputImage = ImageIO.read(inputStream);

        BufferedImage outputImage =
                new BufferedImage(width, height, inputImage.getType());

        Graphics2D graphics2D = outputImage.createGraphics();
        graphics2D.drawImage(inputImage, 0, 0, width, height, null);
        graphics2D.dispose();

        return outputImage;
    }

	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	public static byte[] toByteArray(BufferedImage img) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(img, "png", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();

			return imageInByte;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static File toFile(byte[] img, String fileName) {
		try {
			File outFile = new File(fileName);
			FileOutputStream fileOutputStream = new FileOutputStream(outFile);
			fileOutputStream.write(img);
			fileOutputStream.close();

			return outFile;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getFileName(String url) {
		return url.split("/")[url.split("/").length - 1];
	}
}

package com.baobab.m.service.ftp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class ImageCompress {
	
	public File compress(File file) throws IOException {
		File input = file;
	    BufferedImage image = ImageIO.read(input);

	    File compressedImageFile = new File("compressed_image.webp");
	    OutputStream os = new FileOutputStream(compressedImageFile);

	    Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("webp");
	    ImageWriter writer = (ImageWriter) writers.next();

	    ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	    writer.setOutput(ios);

	    ImageWriteParam param = writer.getDefaultWriteParam();

	    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	    param.setCompressionQuality(0.05f);  // Change the quality value you prefer
	    writer.write(null, new IIOImage(image, null, null), param);

	    os.close();
	    ios.close();
	    writer.dispose();
	    
	    return compressedImageFile;
	}
}

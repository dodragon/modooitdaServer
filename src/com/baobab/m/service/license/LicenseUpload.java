package com.baobab.m.service.license;

import org.springframework.web.multipart.MultipartFile;

public interface LicenseUpload {
	String licenseSaveToServer(MultipartFile cpLicense, String cpName) throws Exception;
}

package com.baobab.admin.service.geo;

import org.springframework.stereotype.Service;

import com.baobab.m.service.geo.NaverGeoCoding;
import com.baobab.m.vo.NaverGeocodingVO;

@Service
public class AdminGeocodingService {
	
	public String geo(String addr) {
		NaverGeoCoding geo = new NaverGeoCoding();
		NaverGeocodingVO vo = geo.trans(addr);
		return vo.getAddresses().get(0).getX() + ", " + vo.getAddresses().get(0).getY();
	}
}

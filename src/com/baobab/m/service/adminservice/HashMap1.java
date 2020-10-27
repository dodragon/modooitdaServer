package com.baobab.m.service.adminservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baobab.m.vo.CPInfoVO;
@Service
public class HashMap1 {

	public String addr(List<CPInfoVO> li) {
		
		List<HashMap> list = new ArrayList<>();
		for(int i=0; i < li.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			CPInfoVO vo = li.get(i);
			
			map.put("cpName", vo.getCP_name());
			map.put("cpAddr", vo.getCP_address()+" "+vo.getCP_addr_details());
			map.put("cpSeq", String.valueOf(vo.getSeq_num()));
			
			list.add(map);
		}
			
		return list.toString();
	}
		

}

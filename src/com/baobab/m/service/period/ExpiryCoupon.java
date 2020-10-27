package com.baobab.m.service.period;

import java.util.ArrayList;
import java.util.List;

import com.baobab.m.vo.CouponUserVO;

public class ExpiryCoupon {
	public ArrayList<String> expiredCoupon(List<CouponUserVO> list){
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
                 arrayList.add(list.get(i).getSerial_num());
        }
        return arrayList;
        
    }
}

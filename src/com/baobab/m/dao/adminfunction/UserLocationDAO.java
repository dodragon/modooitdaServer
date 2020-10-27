package com.baobab.m.dao.adminfunction;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.DecoderException;

import com.baobab.m.vo.CPInfoVO;
import com.baobab.m.vo.UserLocationVO;

public interface UserLocationDAO {
	void firstLocation(UserLocationVO vo);
	UserLocationVO selectLocation(UserLocationVO vo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException,
	IllegalBlockSizeException, UnsupportedEncodingException, DecoderException;
	void updateLocation(UserLocationVO vo) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException,
	IllegalBlockSizeException, UnsupportedEncodingException, DecoderException;
	CPInfoVO pokeSelect(String cpName, String addr);
	int locationLog(HttpServletRequest request);
}

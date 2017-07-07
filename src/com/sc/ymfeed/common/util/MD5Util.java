package com.sc.ymfeed.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private MD5Util() {
	}

	public static String GetMD5Code(String source) {
		String secret = source;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			secret = byteToString(md.digest(source.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return secret;
	}

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param bByte
	 * @return
	 */
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	/**
	 * 返回形式为数字跟字符串
	 * 
	 * @param bByte
	 * @return
	 */
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	/**
	 * 返回形式只为数字
	 * 
	 * @param bByte
	 * @return
	 */
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

}

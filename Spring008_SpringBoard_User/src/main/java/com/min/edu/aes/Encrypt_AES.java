package com.min.edu.aes;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt_AES {
	public String transformaion="AES/CBC/PKCS5PADDING";
	private String key="01234567890123456789012345678901";
	private String iv=key.substring(0,16);
	
	//비밀번호 암호화 AES
	public String encrypt(String txt) throws Exception{
		Cipher cipher = Cipher.getInstance(transformaion);
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec,ivParameterSpec);
		
		byte[] encrypted = cipher.doFinal(txt.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	//비밀번호 복호화 AES
	public String decrypt(String txt) throws Exception{
		Cipher cipher = Cipher.getInstance(transformaion);
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec,ivParameterSpec);
		
		
		byte[] decrypted = Base64.getDecoder().decode(txt);
		byte[] decrypteded = cipher.doFinal(decrypted);
		return new String(decrypteded,"UTF-8");
	}
}

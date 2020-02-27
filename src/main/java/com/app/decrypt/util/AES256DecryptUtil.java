package com.app.decrypt.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256DecryptUtil {

	public static byte[] key = null;

	public static byte[] generateIV = null;

	public static String decrypt(String response) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		String encryptedText = null;
		
		String[] split = response.split(",");
		
		List<String> asList = Arrays.asList(split);
		
		encryptedText = asList.get(0);
		key = Base64.getDecoder().decode(asList.get(1));
		
		generateIV = Base64.getDecoder().decode(asList.get(2));
		
		System.out.println(generateIV);
		System.out.println(key);
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

		IvParameterSpec ivSpec = new IvParameterSpec(generateIV);

		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		byte[] decode = Base64.getDecoder().decode(encryptedText);

		byte[] decryptedByte = cipher.doFinal(decode);

		return new String(decryptedByte);
	}
}

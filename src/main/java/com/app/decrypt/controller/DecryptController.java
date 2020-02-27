package com.app.decrypt.controller;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.decrypt.util.AES256DecryptUtil;

@RestController
public class DecryptController {

	@GetMapping("/decrypt")
	public String decrypt(@RequestParam("encryptedText") String encryptedText) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		System.out.println(encryptedText);
		return AES256DecryptUtil.decrypt(encryptedText);
	}
}
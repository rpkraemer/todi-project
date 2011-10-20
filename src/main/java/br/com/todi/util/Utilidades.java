package br.com.todi.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilidades {

	public static String md5(String senha) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
			sen = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sen;
	}
}

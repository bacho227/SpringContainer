package ge.emis.teachers.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Bacho on 3/9/15.
 */
public class Utils {
	private static MessageDigest md;

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String getMD5(String input) {
		byte[] source;
		try {
			source = input.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			source = input.getBytes();
		}
		byte[] messageDigest = md.digest(source);
		BigInteger number = new BigInteger(1, messageDigest);
		String hashText = number.toString(16);
		while (hashText.length() < 32) {
			hashText = "0" + hashText;
		}
		return hashText;
	}


}
package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypter {

	public String crypto(String hashingString) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] array = digest.digest(hashingString.getBytes());
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				buffer.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}

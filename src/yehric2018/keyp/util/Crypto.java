package yehric2018.keyp.util;

public class Crypto {

	public static String encrypt(String plaintext) {
		String ciphertext = "";
		for (int i = 0; i < plaintext.length(); i++) {
			if (plaintext.charAt(i) % 2 == 0) {
				ciphertext += (char)(plaintext.charAt(i) - 5);
			} else {
				ciphertext += (char)(plaintext.charAt(i) + 5);
			}
		}
		return ciphertext;
	}
	
	public static String decrypt(String ciphertext) {
		String plaintext = "";
		for (int i = 0; i < ciphertext.length(); i++) {
			if (ciphertext.charAt(i) % 2 == 0) {
				plaintext += (char)(ciphertext.charAt(i) - 5);
			} else {
				plaintext += (char)(ciphertext.charAt(i) + 5);
			}
		}
		return plaintext;
	}
}

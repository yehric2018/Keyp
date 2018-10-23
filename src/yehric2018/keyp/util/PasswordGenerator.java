package yehric2018.keyp.util;

import java.util.Random;

// ASCII characters 33-126 can be used in passwords

public class PasswordGenerator {
	
	public static final int LOWEST_ASCII = 33;
	public static final int HIGHEST_ASCII = 126;

	
	public static String generatePass(int length) {
		String password = "";
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			char letter = (char)(33 + r.nextInt(HIGHEST_ASCII - LOWEST_ASCII));
			password += letter;
		}
		return password;
	}
}

package yehric2018.keyp.util;

public class CryptoTester {
	public static void main(String[] args) {
		String test = "plaintext.org";
		System.out.println("Original: " + test);
		test = Crypto.encrypt(test);
		System.out.println("Encrypted: " + test);
		test = Crypto.decrypt(test);
		System.out.println("Decrypted: " + test);
	}
}

package yehric2018.stickypass.data;

public class Password {
	//Remove this soon
	private String plaintext;
	
	private String ciphertext;
	private String key;
	
	public Password(String plaintext) {
		this.plaintext = plaintext;
	}
	
	public String getPlainText() {
		return plaintext;
	}
}

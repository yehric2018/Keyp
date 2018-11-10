package yehric2018.keyp.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class UITextField extends UIElement {
	public static final int MIN_ASCII = 32;
	public static final int MAX_ASCII = 122;
	
	private String text;
	private Font font;
	private boolean hidden;
	
	public UITextField(float x, float y, int width, int height, boolean hidden) {
		super(x, y, width, height);
		text = "";
		this.hidden = hidden;
		if (hidden) {
			font = new Font("Arial", Font.BOLD, 20);
		} else {
			font = new Font("Arial", 0, 20);
		}
	}

	@Override
	public void update(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect((int) x, (int) y, width, height);
		
		g.setFont(font);
		String inputText = "";
		for (int i = 0; i < text.length(); i++) {
			if (hidden) {
				inputText += "*";
			} else {
				inputText +=  text.charAt(i);
			}
		}
		g.drawString(inputText, (int) x + 10, (int) y + 23);
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}
	
	public void keyTyped(KeyEvent e) {
		if (text.length() != 0 && e.getKeyChar() == '\b') {
			text = text.substring(0, text.length() - 1);
		} else if (e.getKeyChar() >= MIN_ASCII && e.getKeyChar() <= MAX_ASCII) {
			text += e.getKeyChar();
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void reset() {
		super.reset();
		text = "";
	}
}

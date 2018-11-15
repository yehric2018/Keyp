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
	
	private long blinkTimer;
	private boolean showCursor;
	private int cursorPosition;
	
	public UITextField(float x, float y, int width, int height, boolean hidden) {
		super(x, y, width, height);
		text = "";
		this.hidden = hidden;
		if (hidden) {
			font = new Font("Arial", Font.BOLD, 20);
		} else {
			font = new Font("Arial", 0, 20);
		}
		
		blinkTimer = System.currentTimeMillis();
		cursorPosition = 0;
	}

	@Override
	public void update(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) x, (int) y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect((int) x, (int) y, width, height);
		
		g.setFont(font);
		String inputText = "";
		for (int i = 0; i < cursorPosition; i++) {
			if (hidden) {
				inputText += "*";
			} else {
				inputText +=  text.charAt(i);
			}
		}
		g.drawString(inputText, (int) x + 10, (int) y + 23);
		
		long now = System.currentTimeMillis();
		if (now - blinkTimer > 500) {
			showCursor = !showCursor;
			blinkTimer = now;
		}
		
		if (showCursor) {
			g.drawLine((int) (g.getFontMetrics().stringWidth(inputText) + x + 10), (int) y + 25,
					(int) (g.getFontMetrics().stringWidth(inputText) + x + 10), (int) y + 5);
		}
		String postText = "";
		for (int i = cursorPosition; i < text.length(); i++) {
			if (hidden) {
				postText += "*";
			} else {
				postText +=  text.charAt(i);
			}
		}
		g.drawString(postText, (int) (g.getFontMetrics().stringWidth(inputText) + x + 10),
									(int) y + 23);
	}

	@Override
	public void onClick() {
	}
	
	public void keyTyped(KeyEvent e) {
		if (cursorPosition != 0 && e.getKeyChar() == '\b') {
			String inputText = text.substring(0, cursorPosition - 1);
			inputText += text.substring(cursorPosition);
			text = inputText;
			cursorPosition--;
			showCursor = true;
			blinkTimer = System.currentTimeMillis();
		} else if (e.getKeyChar() >= MIN_ASCII && e.getKeyChar() <= MAX_ASCII) {
			String pretext = text.substring(0, cursorPosition);
			String posttext = text.substring(cursorPosition);
			text = pretext + e.getKeyChar() + posttext;;
			cursorPosition++;
			showCursor = true;
			blinkTimer = System.currentTimeMillis();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (cursorPosition != 0 && e.getKeyCode() == KeyEvent.VK_LEFT) {
			cursorPosition--;
			showCursor = true;
			blinkTimer = System.currentTimeMillis();
		} else if (cursorPosition != text.length() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cursorPosition++;
			showCursor = true;
			blinkTimer = System.currentTimeMillis();
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void reset() {
		super.reset();
		text = "";
		cursorPosition = 0;
	}
}

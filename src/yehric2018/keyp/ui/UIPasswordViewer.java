package yehric2018.keyp.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIPasswordViewer extends UIElement {
	private Font font;
	private boolean view;
	private String text;
	
	public UIPasswordViewer(float x, float y, int width, int height) {
		super(x, y, width, height);
		
		font = new Font("Arial", Font.BOLD, 20);
		view = false;
		this.text = "";
	}

	@Override
	public void update(Graphics g) {
		if (view) {
			g.setColor(Color.WHITE);
			g.fillRect((int) x, (int) y, width, height);
			g.setColor(Color.BLACK);
			g.drawRect((int) x, (int) y, width, height);
			
			g.setFont(font);
			g.drawString(text, (int) x + 10, (int) y + 23);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect((int) x, (int) y, width, height);
		}
	}

	@Override
	public void onClick() {
	}
	
	public boolean isViewable() {
		return view;
	}
	
	public void sendPassword(String text) {
		this.text = text;
	}
	
	public void toggleVisible() {
		this.view = !this.view;
	}
}

package yehric2018.keyp.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class UIElement {
	protected float x, y;
	protected int width, height;
	protected boolean hovering;
	
	private Rectangle bounds;
	
	public UIElement(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	public abstract void update(Graphics g);
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY())) {
			hovering = true;
		} else {
			hovering = false;
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		if (hovering) {
			onClick();
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean isHovering() {
		return false;
	}
	
	public void reset() {
		hovering = false;
	}

	public void keyPressed(KeyEvent e) {
	}
}

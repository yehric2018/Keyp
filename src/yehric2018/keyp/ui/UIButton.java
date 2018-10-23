package yehric2018.keyp.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIButton extends UIElement {

	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	@Override
	public void update(Graphics g) {
		if (hovering) {
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		} else {
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}
	
	public boolean isHovering() {
		return hovering;
	}

}

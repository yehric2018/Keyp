package yehric2018.keyp.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage logotext;
	
	public static BufferedImage[] addsite;
	public static BufferedImage[] login;
	public static BufferedImage[] settings;
	
	public static void init() {
		addsite = new BufferedImage[2];
		login = new BufferedImage[2];
		settings = new BufferedImage[2];
		
		addsite[0] = ImageLoader.loadImage("/buttons/addsitebutton1.png");
		addsite[1] = ImageLoader.loadImage("/buttons/addsitebutton2.png");
		login[0] = ImageLoader.loadImage("/buttons/accessinfobutton1.png");
		login[1] = ImageLoader.loadImage("/buttons/accessinfobutton2.png");
		settings[0] = ImageLoader.loadImage("/buttons/settingsbutton1.png");
		settings[1] = ImageLoader.loadImage("/buttons/settingsbutton2.png");
		
		logotext = ImageLoader.loadImage("/concepts/logotext.png");
	}
}

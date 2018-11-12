package yehric2018.keyp.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage logo;
	public static BufferedImage logotext;
	public static BufferedImage sitefield;
	public static BufferedImage pwordfield;
	public static BufferedImage successfuladd;
	public static BufferedImage pwordcopied;
	
	public static BufferedImage[] addsite;
	public static BufferedImage[] login;
	public static BufferedImage[] settings;
	public static BufferedImage[] exit;
	public static BufferedImage[] submit;
	public static BufferedImage[] back;
	public static BufferedImage[] randomPassword;
	public static BufferedImage[] view;
	public static BufferedImage[] unview;
	
	public static void init() {
		addsite = new BufferedImage[2];
		login = new BufferedImage[2];
		settings = new BufferedImage[2];
		submit = new BufferedImage[2];
		back = new BufferedImage[2];
		randomPassword = new BufferedImage[2];
		view = new BufferedImage[2];
		unview = new BufferedImage[2];
		exit = new BufferedImage[2];
		
		addsite[0] = ImageLoader.loadImage("/buttons/addsitebutton1.png");
		addsite[1] = ImageLoader.loadImage("/buttons/addsitebutton2.png");
		login[0] = ImageLoader.loadImage("/buttons/accessinfobutton1.png");
		login[1] = ImageLoader.loadImage("/buttons/accessinfobutton2.png");
		settings[0] = ImageLoader.loadImage("/buttons/settingsbutton1.png");
		settings[1] = ImageLoader.loadImage("/buttons/settingsbutton2.png");
		submit[0] = ImageLoader.loadImage("/buttons/submitbutton1.png");
		submit[1] = ImageLoader.loadImage("/buttons/submitbutton2.png");
		back[0] = ImageLoader.loadImage("/buttons/backbutton1.png");
		back[1] = ImageLoader.loadImage("/buttons/backbutton2.png");
		randomPassword[0] = ImageLoader.loadImage("/buttons/generaterandom1.png");
		randomPassword[1] = ImageLoader.loadImage("/buttons/generaterandom2.png");
		view[0] = ImageLoader.loadImage("/buttons/view1.png");
		view[1] = ImageLoader.loadImage("/buttons/view2.png");
		unview[0] = ImageLoader.loadImage("/buttons/unview1.png");
		unview[1] = ImageLoader.loadImage("/buttons/unview2.png");
		exit[0] = ImageLoader.loadImage("/buttons/exit1.png");
		exit[1] = ImageLoader.loadImage("/buttons/exit2.png");
		
		logo = ImageLoader.loadImage("/concepts/logo.png");
		logotext = ImageLoader.loadImage("/concepts/logotext.png");
		sitefield = ImageLoader.loadImage("/prompts/siteentryfield.png");
		pwordfield = ImageLoader.loadImage("/prompts/pwordentryfield.png");
		successfuladd = ImageLoader.loadImage("/prompts/successfuladd.png");
		pwordcopied = ImageLoader.loadImage("/prompts/pwordaccess.png");
	}
}

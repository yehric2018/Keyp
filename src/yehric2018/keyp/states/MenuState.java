package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.ClickListener;
import yehric2018.keyp.ui.UIButton;

public class MenuState extends State {
	
	public MenuState(Program program) {
		super(program);
		
		init();
		
		program.getMouseManager().setUIManager(uiManager);
	}
	
	public void update(Graphics g) {
		uiManager.update(g);
	}
	
	private void init() {
		uiManager.addElement(new UIButton(10, 150, 150, 150, Assets.login, new ClickListener() {
			// Access a password
			public void onClick() {
				System.out.println("Accessing password...");
			}
		}));
		uiManager.addElement(new UIButton(170, 150, 150, 150, Assets.addsite, new ClickListener() {
			public void onClick() {
				System.out.println("Adding login to database...");
			}
		}));
		
		uiManager.addElement(new UIButton(330, 150, 150, 150, Assets.settings, new ClickListener() {
			// Change the settings
			public void onClick() {
				System.out.println("Changing settings...");
			}
		}));
	}
}

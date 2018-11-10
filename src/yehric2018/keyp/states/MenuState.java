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
	}
	
	public void update(Graphics g) {
		uiManager.update(g);
	}
	
	private void init() {
		uiManager.addElement(new UIButton(20, 150, 150, 150, Assets.login, new ClickListener() {
			// Access a password
			public void onClick() {
				System.out.println("Accessing password...");
			}
		}));
		uiManager.addElement(new UIButton(180, 150, 150, 150, Assets.addsite, new ClickListener() {
			public void onClick() {
				uiManager.reset();
				program.setState(State.SITE_ENTRY_STATE);
			}
		}));
		
		uiManager.addElement(new UIButton(340, 150, 150, 150, Assets.settings, new ClickListener() {
			// Change the settings
			public void onClick() {
				System.out.println("Changing settings...");
			}
		}));
	}
}

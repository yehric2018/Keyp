package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.ClickListener;
import yehric2018.keyp.ui.UIButton;
import yehric2018.keyp.ui.UITextField;

public class SiteEntryState extends State {

	public SiteEntryState(Program program) {
		super(program);
		
		init();
	}
	
	private void init() {
		uiManager.addElement(new UITextField(80, 170, 340, 30, false));
		
		uiManager.addElement(new UIButton(300, 220, 100, 60, Assets.submit, new ClickListener() {
			public void onClick() {
				String siteName = ((UITextField) uiManager.getElements().get(0)).getText();
				if (!siteName.equals("")) {
					program.getDatabase().setCurrentSite(siteName);
					uiManager.reset();
					program.setState(State.PASSWORD_ENTRY_STATE);
				}
			}
		}));
		
		uiManager.addElement(new UIButton(100, 220, 100, 60, Assets.back, new ClickListener() {
			// Access a password
			public void onClick() {
				uiManager.reset();
				program.setState(State.MENU_STATE);
			}
		}));
	}
	
	@Override
	public void update(Graphics g) {
		g.drawImage(Assets.sitefield, 50, 100, 400, 150, null);
		uiManager.update(g);
		//textField.update(g);
	}

}

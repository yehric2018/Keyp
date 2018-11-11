package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.ClickListener;
import yehric2018.keyp.ui.UIButton;
import yehric2018.keyp.ui.UITextField;
import yehric2018.keyp.util.ClipboardManager;

public class SiteAccessState extends State {

	public SiteAccessState(Program program) {
		super(program);

		init();
	}
	
	private void init() {
		uiManager.addElement(new UITextField(80, 170, 340, 30, false));
		
		uiManager.addElement(new UIButton(300, 220, 100, 60, Assets.submit, new ClickListener() {
			public void onClick() {
				String siteName = ((UITextField) uiManager.getElements().get(0)).getText();
				if (program.getDatabase().containsSite(siteName)) {
					program.getDatabase().setCurrentSite(siteName);
					ClipboardManager.copyText(program.getDatabase().getPassword());
					program.setState(State.PASSWORD_ACCESS_STATE);
				}
			}
		}));
		
		uiManager.addElement(new UIButton(100, 220, 100, 60, Assets.back, new ClickListener() {
			public void onClick() {
				program.setState(State.MENU_STATE);
			}
		}));
	}

	@Override
	public void update(Graphics g) {
		g.drawImage(Assets.sitefield, 50, 100, 400, 150, null);
		uiManager.update(g);
	}

}

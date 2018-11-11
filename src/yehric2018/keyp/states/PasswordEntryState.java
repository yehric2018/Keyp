package yehric2018.keyp.states;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.ClickListener;
import yehric2018.keyp.ui.UIButton;
import yehric2018.keyp.ui.UITextField;
import yehric2018.keyp.util.PasswordGenerator;

public class PasswordEntryState extends State {

	public PasswordEntryState(Program program) {
		super(program);

		init();
	}

	private void init() {
		uiManager.addElement(new UITextField(80, 170, 340, 30, true));
		
		uiManager.addElement(new UIButton(300, 220, 100, 60, Assets.submit, new ClickListener() {
			public void onClick() {
				program.getDatabase().addSite(
						((UITextField) uiManager.getElements().get(0)).getText());
				program.getDatabase().saveData();
				program.setState(State.ADD_SUCCESS_STATE);
			}
		}));
		
		uiManager.addElement(new UIButton(100, 220, 100, 60, Assets.back, new ClickListener() {
			public void onClick() {
				program.setState(State.SITE_ENTRY_STATE);
			}
		}));
		
		uiManager.addElement(new UIButton(100, 300, 300, 50, Assets.randomPassword, new ClickListener() {
			public void onClick() {
				program.getDatabase().addSite(PasswordGenerator.generatePass(16));
				program.getDatabase().saveData();
				program.setState(State.ADD_SUCCESS_STATE);
			}
		}));
	}
	
	@Override
	public void update(Graphics g) {
		g.drawImage(Assets.pwordfield, 50, 100, 400, 150, null);
		
		uiManager.update(g);
	}

}

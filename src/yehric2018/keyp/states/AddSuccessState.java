package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.ClickListener;
import yehric2018.keyp.ui.UIButton;

public class AddSuccessState extends State {

	public AddSuccessState(Program program) {
		super(program);
		
		init();
	}
	
	private void init() {
		uiManager.addElement(new UIButton(200, 200, 100, 60, Assets.submit, new ClickListener() {
			public void onClick() {
				uiManager.reset();
				program.setState(State.MENU_STATE);
			}
		}));
	}

	@Override
	public void update(Graphics g) {
		g.drawImage(Assets.successfuladd, 100, 100, 300, 150, null);
		uiManager.update(g);
	}

}

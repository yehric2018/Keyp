package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.ClickListener;
import yehric2018.keyp.ui.UIButton;
import yehric2018.keyp.ui.UIPasswordViewer;
import yehric2018.keyp.util.ClipboardManager;

public class PasswordAccessState extends State {

	private UIPasswordViewer passwordViewer;
	private UIButton button;
	
	public PasswordAccessState(Program program) {
		super(program);
		
		init();
	}
	
	private void init() {
		passwordViewer = new UIPasswordViewer(80, 170, 290, 30);
		uiManager.addElement(passwordViewer);
		
		button = new UIButton(80 + 290, 165, 60, 40,
								Assets.unview, new ClickListener() {
			public void onClick() {
				passwordViewer.sendPassword(program.getDatabase().getPassword());
				if (!passwordViewer.isViewable()) {
					button.setImages(Assets.view);
				} else {
					button.setImages(Assets.unview);
				}
				passwordViewer.toggleVisible();
			}
		});
		uiManager.addElement(button);
		
		uiManager.addElement(new UIButton(200, 230, 100, 60, Assets.submit, new ClickListener() {
			public void onClick() {
				ClipboardManager.clearClipBoard();
				program.setState(State.MENU_STATE);
			}
		}));
	}

	@Override
	public void update(Graphics g) {
		g.drawImage(Assets.pwordcopied, 50, 100, 400, 150, null);
		
		uiManager.update(g);
	}

}

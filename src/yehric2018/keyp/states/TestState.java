package yehric2018.keyp.states;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;

import yehric2018.keyp.Program;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.ui.UITextField;

public class TestState extends State {
	private UITextField textField;

	public TestState(Program program) {
		super(program);
		
		program.getMouseManager().setUIManager(uiManager);
		//textField = new UITextField(80, 170, 340, 30);
	}
	
	@Override
	public void update(Graphics g) {
		
		g.fillRect(100, 100, 300, 150);
//		g.drawRect(50, 100, 400, 150);
//		g.drawRect(170, 150, 150, 150);
//		g.drawRect(330, 150, 150, 150);
//		g.drawRect(10, 310, 470, 50);
	}

}

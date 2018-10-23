package yehric2018.keyp.states;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.keyp.Program;

public class TestState extends State {

	public TestState(Program program) {
		super(program);
		
		program.getMouseManager().setUIManager(uiManager);
	}
	
	@Override
	public void update(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(10, 150, 150, 150);
		g.drawRect(170, 150, 150, 150);
		g.drawRect(330, 150, 150, 150);
		g.drawRect(10, 310, 470, 50);
	}

}

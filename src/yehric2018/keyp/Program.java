package yehric2018.keyp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.gfx.Display;
import yehric2018.keyp.input.MouseManager;
import yehric2018.keyp.states.MenuState;
import yehric2018.keyp.states.State;
import yehric2018.keyp.states.TestState;

public class Program {
	private int width, height;
	
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
	private MouseManager mouseManager;
	
	private State menuState;
	
	public Program(int width, int height) {
		this.width = width;
		this.height = height;
		display = new Display(width, height);
	}
	
	// Updates the program
	public void update() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if (State.getState() != null) {
			State.getState().update(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void start() {
		init();
		State.setState(menuState);
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	private void init() {
		mouseManager = new MouseManager();
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		menuState = new MenuState(this);
	}
}

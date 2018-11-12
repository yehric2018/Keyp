package yehric2018.keyp;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import yehric2018.keyp.data.Database;
import yehric2018.keyp.gfx.Assets;
import yehric2018.keyp.gfx.Display;
import yehric2018.keyp.input.KeyManager;
import yehric2018.keyp.input.MouseManager;
import yehric2018.keyp.states.*;

public class Program {
	
	private int width, height;
	
	private Database database;
	
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
	private MouseManager mouseManager;
	private KeyManager keyManager;
	
	private State[] states;
	
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
		setState(State.MENU_STATE);
	}
	
	public void setState(int n) {
		if (State.getState() != null) {
			State.getState().getUIManager().reset();
		}
		State.setState(states[n]);
		mouseManager.setUIManager(states[n].getUIManager());
		keyManager.setUIManager(states[n].getUIManager());
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public Database getDatabase() {
		return database;
	}
	
	private void init() {
		mouseManager = new MouseManager();
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		keyManager = new KeyManager();
		display.getFrame().addKeyListener(keyManager);
		
		Assets.init();
		display.getFrame().setIconImage(Assets.logo);
		
		states = new State[State.NUM_OF_STATES];
		states[0] = new MenuState(this);
		states[1] = new SiteEntryState(this);
		states[2] = new PasswordEntryState(this);
		states[3] = new AddSuccessState(this);
		states[4] = new SiteAccessState(this);
		states[5] = new PasswordAccessState(this);
		states[19] = new TestState(this);
		
		database = new Database();
	}
}

package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.ui.UIManager;

public abstract class State {
	public static final int NUM_OF_STATES = 20;
	public static final int MENU_STATE = 0;
	public static final int SITE_ENTRY_STATE = 1;
	public static final int PASSWORD_ENTRY_STATE = 2;
	public static final int ADD_SUCCESS_STATE = 3;
	public static final int TEST_STATE = 19;
	
	private static State currentState = null;
	
	public static State getState() {
		return currentState;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	protected Program program;
	protected UIManager uiManager;
	
	public State(Program program) {
		this.program = program;
		this.uiManager = new UIManager(program);
	}
	
	public abstract void update(Graphics g);
	
	public UIManager getUIManager() {
		return uiManager;
	}
}

package yehric2018.keyp.states;

import java.awt.Graphics;

import yehric2018.keyp.Program;
import yehric2018.keyp.ui.UIManager;

public abstract class State {
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
}

package yehric2018.keyp.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import yehric2018.keyp.ui.UIManager;

public class KeyManager implements KeyListener {
	private UIManager uiManager;
	
	public KeyManager() {
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		uiManager.keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

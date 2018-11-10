package yehric2018.keyp.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import yehric2018.keyp.Program;

public class UIManager {
	private Program program;
	private List<UIElement> elements;
	
	public UIManager(Program program) {
		this.program = program;
		elements = new ArrayList<UIElement>();
	}
	
	public void addElement(UIElement e) {
		elements.add(e);
	}
	public void removeElement(UIElement e) {
		elements.remove(e);
	}
	
	public void update(Graphics g) {
		for (UIElement o : elements) {
			o.update(g);
		}
	}
	public void onMouseMove(MouseEvent e) {
		for (UIElement o: elements)
			o.onMouseMove(e);
	}
	public void onMouseRelease(MouseEvent e) {
		for (UIElement o: elements)
			o.onMouseRelease(e);
	}
	
	public void keyTyped(KeyEvent e) {
		for (UIElement o : elements)
			o.keyTyped(e);
	}
	
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<UIElement> getElements() {
		return elements;
	}

	public void setelements(ArrayList<UIElement> elements) {
		this.elements = elements;
	}
	
	public void reset() {
		for (UIElement o : elements)
			o.reset();
	}
}

package yehric2018.keyp.gfx;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	public static final String PROGRAM_TITLE = "Memopass";
	public static int WIDTH_OFFSET = 16, HEIGHT_OFFSET = 39;
	
	private int width, height;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		
		init();
	}
	
	// Initialize the program's user interface, set to state 0
	private void init() {
		frame = new JFrame(PROGRAM_TITLE);
		frame.setSize(width + WIDTH_OFFSET, height + HEIGHT_OFFSET);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setBackground(Color.GRAY);
		canvas.setFocusable(false);
		
		frame.add(canvas);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}

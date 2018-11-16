package UI;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {
	
	public ApplicationWindow(Dimension size, Point location) {
		this.setSize(size);
		this.setLocation(location);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.setVisible(true);
	}
	
	//Ìí¼Ó×é¼þ
	public void init() {
		
	}
}

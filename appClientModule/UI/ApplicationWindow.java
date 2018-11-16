package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import gizmo.RectangleCollisionBody;

public class ApplicationWindow extends JFrame {
	
	private AnimationWindow animationWindow;
	
	public ApplicationWindow(Dimension size, Point location) {
		this.setSize(size);
		this.setLocation(location);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.setVisible(true);
	}
	
	//Ìí¼Ó×é¼þ
	public void init() {
		animationWindow = new AnimationWindow();
		animationWindow.addShape(new RectangleCollisionBody(new Point(100, 100), new Dimension(50, 50), Color.BLUE));
		this.add(animationWindow);
	}
}

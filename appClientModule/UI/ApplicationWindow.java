package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.Timer;


public class ApplicationWindow extends JFrame {
	
	private AnimationWindow animationWindow;
	private ManageWindow manageWindow;
	//private ScoreWindow scoreWindow;
	
	public ApplicationWindow(Dimension size, Point location) {
		this.setSize(size);
		this.setLocation(location);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.setVisible(true);
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		
	}
	
	//Ìí¼Ó×é¼þ
	public void init() {
		animationWindow = AnimationWindow.getInstance();
		manageWindow = new ManageWindow();
		//scoreWindow = new ScoreWindow();
		//scoreWindow.setMessage("hello");

		/*
		 * JSplitPane jsp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, manageWindow, scoreWindow);
		jsp3.setDividerLocation(650);
		*/
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationWindow, manageWindow);
		jsp.setDividerLocation(500);
		JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new MyMenu(this), jsp);
		jsp2.setDividerLocation(40);
		
		this.add(jsp2);
	
	}
}

package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import config.Config;


public class ApplicationWindow extends JFrame {
	
	private AnimationWindow animationWindow;
	private ManageWindow manageWindow;
	
	public ApplicationWindow() {
		this.setSize(Config.WINSIZE);
		this.setLocation(Config.WINLOCATION);
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
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationWindow, manageWindow);
		jsp.setDividerLocation(500);
		JSplitPane jsp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new MyMenu(this), jsp);
		jsp2.setDividerLocation(40);
		
		this.add(jsp2);
	
	}
}

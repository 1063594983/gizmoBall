package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import gizmo.RectangleCollisionBody;

public class ApplicationWindow extends JFrame {
	
	private AnimationWindow animationWindow;
	private ManageWindow manageWindow;
	
	public ApplicationWindow(Dimension size, Point location) {
		this.setSize(size);
		this.setLocation(location);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.setVisible(true);
	}
	
	//Ìí¼Ó×é¼þ
	public void init() {
		
		/*     WRONG BGL
		 * 
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {600, 266, 100};
		gridBagLayout.rowHeights = new int[] {700, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		this.setLayout(gridBagLayout);
		
		animationWindow = new AnimationWindow();
		animationWindow.setBackground(Color.BLACK);
		FlowLayout flowLayout = (FlowLayout) animationWindow.getLayout();
		flowLayout.setVgap(400);
		flowLayout.setHgap(400);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		this.add(animationWindow, gbc_panel);
		
		manageWindow = new ManageWindow();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		this.add(manageWindow, gbc_panel_1);
		*/
		
		animationWindow = new AnimationWindow();
		manageWindow = new ManageWindow();
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationWindow, manageWindow);
		jsp.setDividerLocation(500);
		this.add(jsp);
	
	}
}

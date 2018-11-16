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

		/*
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {600, 266, 100};
		gridBagLayout.rowHeights = new int[] {700, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		AnimationWindow animationwindow = new AnimationWindow();
		animationwindow.setBackground(Color.BLACK);
		FlowLayout flowLayout = (FlowLayout) animationwindow.getLayout();
		//flowLayout.setVgap(400);
		//animationwindow.setHgap(400);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		animationwindow.addShape(new RectangleCollisionBody(new Point(100, 100), new Dimension(50, 50), Color.BLUE));
		getContentPane().add(animationwindow, gbc_panel);
		//getContentPane().add
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {140};
		gbl_panel_1.rowHeights = new int[] {50, 50, 50, 50, 50};
		gbl_panel_1.columnWeights = new double[]{0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel_1);
		
		ShapeBtn btnNewButton = new ShapeBtn("Play");
		btnNewButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		ShapeBtn btnNewButton_1 = new ShapeBtn("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("D:\\OOAD\\lab\\paintDemo\\src\\Circle.png"));
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		ShapeBtn btnNewButton_2 = new ShapeBtn("New button");
		btnNewButton_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		* */
		animationWindow = new AnimationWindow();
		animationWindow.addShape(new RectangleCollisionBody(new Point(100, 100), Color.BLUE));
		manageWindow = new ManageWindow();
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, animationWindow, manageWindow);
		jsp.setDividerLocation(500);
		this.add(jsp);
	
	}
}

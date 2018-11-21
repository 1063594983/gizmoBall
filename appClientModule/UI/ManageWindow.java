package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import gizmo.AbstractShape;
import gizmo.CircleCollisionBody;
import gizmo.EchelonCollisionBody;
import control.AddShapeCommand;
import control.ChangeSizeCommand;
import control.DeleteCommand;
import control.DragCommand;
import control.MainControl;
import control.RunCommand;
import gizmo.RectangleCollisionBody;
import gizmo.TriangleCollisionBody;

public class ManageWindow extends JPanel {
	public ManageWindow() {

		ShapeBtn rectangle = new ShapeBtn("", new RectangleCollisionBody(), new AddShapeCommand());
		ShapeBtn triangle = new ShapeBtn("",  new TriangleCollisionBody(), new AddShapeCommand());
		ShapeBtn circle = new ShapeBtn("",  new CircleCollisionBody(), new AddShapeCommand());
		ShapeBtn echelon = new ShapeBtn("",  new EchelonCollisionBody(), new AddShapeCommand());
		ShapeBtn play = new ShapeBtn("Play",  new RectangleCollisionBody(), new RunCommand(0));
		ShapeBtn pause = new ShapeBtn("Pause",  new RectangleCollisionBody(), new RunCommand(1));
		ShapeBtn smaller = new ShapeBtn("Delete",  new RectangleCollisionBody(), new DeleteCommand());
		ShapeBtn bigger = new ShapeBtn("Bigger", new RectangleCollisionBody(), new ChangeSizeCommand(0));
		ShapeBtn drag = new ShapeBtn("Drag",  new RectangleCollisionBody(), new DragCommand());
		rectangle.setIcon(new ImageIcon("Rectangle.png"));
		triangle.setIcon(new ImageIcon("Triangle.png"));
		echelon.setIcon(new ImageIcon("Echelon.png"));
		circle.setIcon(new ImageIcon("Circle.png"));
		
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainControl.setCommand(play.command);
				MainControl.action();
			}
		});
		
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainControl.setCommand(pause.command);
				MainControl.action();
			}
		});

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {140};
		int thisHeight = 600;
		int evetyHeight = thisHeight / 9 - 5;
		gbl_panel.rowHeights = new int[] {evetyHeight, evetyHeight, evetyHeight,
				evetyHeight, evetyHeight, evetyHeight, evetyHeight, evetyHeight, evetyHeight};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		GridBagConstraints gbc_Play = new GridBagConstraints();
		gbc_Play.anchor = GridBagConstraints.SOUTHWEST;
		gbc_Play.insets = new Insets(0, 0, 5, 5);
		gbc_Play.gridx = 0;
		gbc_Play.gridy = 0;
		GridBagConstraints gbc_Pause = new GridBagConstraints();
		gbc_Pause.anchor = GridBagConstraints.WEST;
		gbc_Pause.insets = new Insets(0, 0, 5, 5);
		gbc_Pause.gridx = 0;
		gbc_Pause.gridy = 1;
		GridBagConstraints gbc_Rectangle = new GridBagConstraints();
		gbc_Rectangle.anchor = GridBagConstraints.WEST;
		gbc_Rectangle.insets = new Insets(0, 0, 5, 5);
		gbc_Rectangle.gridx = 0;
		gbc_Rectangle.gridy = 2;
		GridBagConstraints gbc_Circle = new GridBagConstraints();
		gbc_Circle.anchor = GridBagConstraints.WEST;
		gbc_Circle.insets = new Insets(0, 0, 5, 5);
		gbc_Circle.gridx = 0;
		gbc_Circle.gridy = 3;
		GridBagConstraints gbc_Echelon = new GridBagConstraints();
		gbc_Echelon.anchor = GridBagConstraints.WEST;
		gbc_Echelon.insets = new Insets(0, 0, 5, 5);
		gbc_Echelon.gridx = 0;
		gbc_Echelon.gridy = 4;
		GridBagConstraints gbc_Triangle = new GridBagConstraints();
		gbc_Triangle.anchor = GridBagConstraints.WEST;
		gbc_Triangle.insets = new Insets(0, 0, 5, 5);
		gbc_Triangle.gridx = 0;
		gbc_Triangle.gridy = 5;
		GridBagConstraints gbc_Smaller = new GridBagConstraints();
		gbc_Smaller.anchor = GridBagConstraints.WEST;
		gbc_Smaller.insets = new Insets(0, 0, 5, 5);
		gbc_Smaller.gridx = 0;
		gbc_Smaller.gridy = 6;
		GridBagConstraints gbc_Bigger = new GridBagConstraints();
		gbc_Bigger.anchor = GridBagConstraints.NORTHWEST;
		gbc_Bigger.insets = new Insets(0, 0, 5, 5);
		gbc_Bigger.gridx = 0;
		gbc_Bigger.gridy = 7;
		GridBagConstraints gbc_Drag = new GridBagConstraints();
		gbc_Drag.anchor = GridBagConstraints.NORTHWEST;
		gbc_Drag.insets = new Insets(0, 0, 5, 5);
		gbc_Drag.gridx = 0;
		gbc_Drag.gridy = 8;
		
		this.add(play, gbc_Play);
		this.add(pause, gbc_Pause);
		this.add(triangle, gbc_Triangle);
		this.add(circle, gbc_Circle);
		this.add(echelon, gbc_Echelon);
		this.add(rectangle, gbc_Rectangle);
		this.add(smaller, gbc_Smaller);
		this.add(bigger, gbc_Bigger);
		this.add(drag, gbc_Drag);
		
	}
}

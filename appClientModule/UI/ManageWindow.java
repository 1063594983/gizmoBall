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
import gizmo.DarkholeCollisionBody;
import gizmo.EchelonCollisionBody;
import control.AddBallCommand;
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
		ShapeBtn triangle = new ShapeBtn("", new TriangleCollisionBody(), new AddShapeCommand());
		ShapeBtn circle = new ShapeBtn("", new CircleCollisionBody(), new AddShapeCommand());
		ShapeBtn echelon = new ShapeBtn("", new EchelonCollisionBody(), new AddShapeCommand());
		ShapeBtn pipe1 = new ShapeBtn("", new EchelonCollisionBody(), new AddShapeCommand());
		ShapeBtn pipe2 = new ShapeBtn("", new EchelonCollisionBody(), new AddShapeCommand());
		ShapeBtn darkhole = new ShapeBtn("ÎüÊÕÆ÷",  new DarkholeCollisionBody(), new AddShapeCommand());
		ShapeBtn baffle = new ShapeBtn("", new EchelonCollisionBody(), new AddShapeCommand());
		ShapeBtn play = new ShapeBtn("Play", new RectangleCollisionBody(), new RunCommand(0));
		ShapeBtn pause = new ShapeBtn("Pause", new RectangleCollisionBody(), new RunCommand(1));
		ShapeBtn delete = new ShapeBtn("Delete", new RectangleCollisionBody(), new DeleteCommand());
		ShapeBtn rotate = new ShapeBtn("Rotate", new RectangleCollisionBody(), new DeleteCommand());
		ShapeBtn setBall = new ShapeBtn("SetBall", new RectangleCollisionBody(), new AddBallCommand());
		ShapeBtn resize = new ShapeBtn("Resize", new RectangleCollisionBody(), new ChangeSizeCommand(0));
		ShapeBtn drag = new ShapeBtn("Drag", new RectangleCollisionBody(), new DragCommand());
		rectangle.setIcon(new ImageIcon("Rectangle.png"));
		triangle.setIcon(new ImageIcon("Triangle.png"));
		echelon.setIcon(new ImageIcon("Echelon.png"));
		circle.setIcon(new ImageIcon("Circle.png"));
		pipe1.setIcon(new ImageIcon("Pipe1.png"));
		pipe2.setIcon(new ImageIcon("Pipe2.png"));
		darkhole.setIcon(new ImageIcon("Darkhole.png"));
		baffle.setIcon(new ImageIcon("Baffle.png"));
		
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
		int thisHeight = 500;
		int evetyHeight = thisHeight / 15;
		gbl_panel.rowHeights = new int[] {evetyHeight, evetyHeight, evetyHeight,
				evetyHeight, evetyHeight, evetyHeight, evetyHeight, evetyHeight, evetyHeight,
				evetyHeight, evetyHeight, evetyHeight, evetyHeight, evetyHeight, evetyHeight};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		GridBagConstraints gbc_Play = new GridBagConstraints();
		gbc_Play.anchor = GridBagConstraints.WEST;
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
		GridBagConstraints gbc_Pipe1 = new GridBagConstraints();
		gbc_Pipe1.anchor = GridBagConstraints.WEST;
		gbc_Pipe1.insets = new Insets(0, 0, 5, 5);
		gbc_Pipe1.gridx = 0;
		gbc_Pipe1.gridy = 6;
		GridBagConstraints gbc_Pipe2 = new GridBagConstraints();
		gbc_Pipe2.anchor = GridBagConstraints.WEST;
		gbc_Pipe2.insets = new Insets(0, 0, 5, 5);
		gbc_Pipe2.gridx = 0;
		gbc_Pipe2.gridy = 7;
		GridBagConstraints gbc_Darkhole = new GridBagConstraints();
		gbc_Darkhole.anchor = GridBagConstraints.WEST;
		gbc_Darkhole.insets = new Insets(0, 0, 5, 5);
		gbc_Darkhole.gridx = 0;
		gbc_Darkhole.gridy = 8;
		GridBagConstraints gbc_Baffle = new GridBagConstraints();
		gbc_Baffle.anchor = GridBagConstraints.WEST;
		gbc_Baffle.insets = new Insets(0, 0, 5, 5);
		gbc_Baffle.gridx = 0;
		gbc_Baffle.gridy = 9;
		GridBagConstraints gbc_Delete = new GridBagConstraints();
		gbc_Delete.anchor = GridBagConstraints.WEST;
		gbc_Delete.insets = new Insets(0, 0, 5, 5);
		gbc_Delete.gridx = 0;
		gbc_Delete.gridy = 10;
		GridBagConstraints gbc_Rotate = new GridBagConstraints();
		gbc_Rotate.anchor = GridBagConstraints.WEST;
		gbc_Rotate.insets = new Insets(0, 0, 5, 5);
		gbc_Rotate.gridx = 0;
		gbc_Rotate.gridy = 11;
		GridBagConstraints gbc_Setball = new GridBagConstraints();
		gbc_Setball.anchor = GridBagConstraints.WEST;
		gbc_Setball.insets = new Insets(0, 0, 5, 5);
		gbc_Setball.gridx = 0;
		gbc_Setball.gridy = 12;
		GridBagConstraints gbc_Resize = new GridBagConstraints();
		gbc_Resize.anchor = GridBagConstraints.WEST;
		gbc_Resize.insets = new Insets(0, 0, 5, 5);
		gbc_Resize.gridx = 0;
		gbc_Resize.gridy = 13;
		GridBagConstraints gbc_Drag = new GridBagConstraints();
		gbc_Drag.anchor = GridBagConstraints.WEST;
		gbc_Drag.insets = new Insets(0, 0, 5, 5);
		gbc_Drag.gridx = 0;
		gbc_Drag.gridy = 14;
		
		this.add(play, gbc_Play);
		this.add(pause, gbc_Pause);
		this.add(triangle, gbc_Triangle);
		this.add(circle, gbc_Circle);
		this.add(echelon, gbc_Echelon);
		this.add(rectangle, gbc_Rectangle);
		this.add(pipe1, gbc_Pipe1);
		this.add(pipe2, gbc_Pipe2);
		this.add(baffle, gbc_Baffle);
		this.add(darkhole, gbc_Darkhole);
		this.add(rotate, gbc_Rotate);
		this.add(delete, gbc_Delete);
		this.add(resize, gbc_Resize);
		this.add(drag, gbc_Drag);
		this.add(setBall, gbc_Setball);
		
	}
}

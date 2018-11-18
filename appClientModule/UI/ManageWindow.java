package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import gizmo.AbstractShape;
import gizmo.CircleCollisionBody;
import gizmo.EchelonCollisionBody;
import control.AddShapeCommand;
import control.ChangeSizeCommand;
import control.DragCommand;
import gizmo.RectangleCollisionBody;
import gizmo.TriangleCollisionBody;

public class ManageWindow extends JPanel {
	public ManageWindow() {

		ShapeBtn square = new ShapeBtn("", new RectangleCollisionBody(), new AddShapeCommand());
		ShapeBtn triange = new ShapeBtn("",  new TriangleCollisionBody(), new AddShapeCommand());
		ShapeBtn circle = new ShapeBtn("",  new CircleCollisionBody(), new AddShapeCommand());
		ShapeBtn echelon = new ShapeBtn("",  new EchelonCollisionBody(), new AddShapeCommand());
		ShapeBtn play = new ShapeBtn("Play",  new RectangleCollisionBody(), new DragCommand());
		ShapeBtn pause = new ShapeBtn("Pause",  new RectangleCollisionBody(), new DragCommand());
		ShapeBtn smaller = new ShapeBtn("Smaller",  new RectangleCollisionBody(), new DragCommand());
		ShapeBtn bigger = new ShapeBtn("Bigger", new RectangleCollisionBody(), new ChangeSizeCommand());
		square.setIcon(new ImageIcon("D:\\OOAD\\lab\\gizmoBall\\Square.png"));
		triange.setIcon(new ImageIcon("D:\\OOAD\\lab\\gizmoBall\\Triange.png"));
		echelon.setIcon(new ImageIcon("D:\\OOAD\\lab\\gizmoBall\\Echelon.png"));
		circle.setIcon(new ImageIcon("D:\\OOAD\\lab\\gizmoBall\\Circle.png"));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {140};
		int thisHeight = 600;
		int evertyHeight = thisHeight / 6;
		gbl_panel.rowHeights = new int[] {evertyHeight, evertyHeight, evertyHeight,
				evertyHeight, evertyHeight, evertyHeight};
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
		GridBagConstraints gbc_Square = new GridBagConstraints();
		gbc_Square.anchor = GridBagConstraints.WEST;
		gbc_Square.insets = new Insets(0, 0, 5, 5);
		gbc_Square.gridx = 0;
		gbc_Square.gridy = 2;
		GridBagConstraints gbc_Circle = new GridBagConstraints();
		gbc_Circle.anchor = GridBagConstraints.WEST;
		gbc_Circle.insets = new Insets(0, 0, 5, 5);
		gbc_Circle.gridx = 0;
		gbc_Circle.gridy = 3;
		GridBagConstraints gbc_Smaller = new GridBagConstraints();
		gbc_Smaller.anchor = GridBagConstraints.WEST;
		gbc_Smaller.insets = new Insets(0, 0, 5, 5);
		gbc_Smaller.gridx = 0;
		gbc_Smaller.gridy = 4;
		GridBagConstraints gbc_Bigger = new GridBagConstraints();
		gbc_Bigger.anchor = GridBagConstraints.NORTHWEST;
		gbc_Bigger.insets = new Insets(0, 0, 5, 5);
		gbc_Bigger.gridx = 0;
		gbc_Bigger.gridy = 5;
		
		this.add(play, gbc_Play);
		this.add(pause, gbc_Pause);
		this.add(smaller, gbc_Smaller);
		this.add(bigger, gbc_Bigger);
		this.add(square, gbc_Square);
		this.add(circle, gbc_Circle);
	}
}

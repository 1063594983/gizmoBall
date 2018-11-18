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
import gizmo.RectangleCollisionBody;

public class ManageWindow extends JPanel {
	public ManageWindow() {
		ShapeBtn square = new ShapeBtn("", new RectangleCollisionBody(new Point(500, 500), Color.RED));
		ShapeBtn circle = new ShapeBtn("", new RectangleCollisionBody(new Point(500, 500), Color.RED));
		ShapeBtn play = new ShapeBtn("Play", null);
		ShapeBtn pause = new ShapeBtn("Pause", null);
		ShapeBtn move = new ShapeBtn("Move", null);
		ShapeBtn bigger = new ShapeBtn("Bigger", null);
		square.setIcon(new ImageIcon("D:\\OOAD\\lab\\gizmoBall\\Square.png"));
		circle.setIcon(new ImageIcon("D:\\OOAD\\lab\\gizmoBall\\Circle.png"));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {140};
		gbl_panel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30};
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
		GridBagConstraints gbc_Move = new GridBagConstraints();
		gbc_Move.anchor = GridBagConstraints.WEST;
		gbc_Move.insets = new Insets(0, 0, 5, 5);
		gbc_Move.gridx = 0;
		gbc_Move.gridy = 4;
		GridBagConstraints gbc_Bigger = new GridBagConstraints();
		gbc_Bigger.anchor = GridBagConstraints.WEST;
		gbc_Bigger.insets = new Insets(0, 0, 5, 5);
		gbc_Bigger.gridx = 0;
		gbc_Bigger.gridy = 5;
		
		this.add(play, gbc_Play);
		this.add(pause, gbc_Pause);
		this.add(move, gbc_Move);
		this.add(bigger, gbc_Bigger);
		this.add(square, gbc_Square);
		this.add(circle, gbc_Circle);
	}
}

package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import gizmo.RectangleCollisionBody;

public class ManageWindow extends JPanel {
	public ManageWindow() {
		ShapeBtn sb = new ShapeBtn("sb", new RectangleCollisionBody(new Point(100, 100), Color.black));
		this.add(sb);
	}
}

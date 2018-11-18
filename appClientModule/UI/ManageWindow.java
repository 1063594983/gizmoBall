package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

import control.AddShapeCommand;
import control.ChangeSizeCommand;
import control.DragCommand;
import gizmo.RectangleCollisionBody;
import gizmo.TriangleCollisionBody;

public class ManageWindow extends JPanel {
	public ManageWindow() {
		ShapeBtn sb = new ShapeBtn("sb", new RectangleCollisionBody(), new AddShapeCommand());
		ShapeBtn tri = new ShapeBtn("tri", new TriangleCollisionBody(), new AddShapeCommand());
		ShapeBtn add = new ShapeBtn("changeSize", new RectangleCollisionBody(), new ChangeSizeCommand());
		ShapeBtn drag = new ShapeBtn("drag", new RectangleCollisionBody(), new DragCommand());
		this.add(sb);
		this.add(tri);
		this.add(add);
		this.add(drag);
	}
}

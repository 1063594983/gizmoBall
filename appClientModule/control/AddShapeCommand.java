package control;

import java.awt.Color;

import UI.AnimationWindow;
import gizmo.AbstractShape;
import gizmo.RectangleCollisionBody;
import gizmo.TriangleCollisionBody;

public class AddShapeCommand extends Command {	
	
	public AddShapeCommand() {
		this.name = "add";
	}
	
	public void execute() {
		AbstractShape newShape;
		newShape = this.shape.getNewInstance();
		newShape.setPosition(this.shape.getPosition());
		AnimationWindow.getInstance().addShape(newShape);
	}
	
}

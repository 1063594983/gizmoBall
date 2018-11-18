package control;

import java.awt.Color;

import UI.AnimationWindow;
import gizmo.AbstractShape;
import gizmo.RectangleCollisionBody;
import gizmo.TriangleCollisionBody;

public class AddShapeCommand extends Command {	
	
	public void execute() {
		AbstractShape newShape;
		/*
		switch(this.shape.name) {
		case "rectangle": {
			newShape = new RectangleCollisionBody(this.shape.getPosition(), Color.RED);
			break;
		}
		case "triangle": {
			newShape = new TriangleCollisionBody(this.shape.getPosition(), Color.RED);
			System.out.println("添加一个三角形");
			break;
		}
		default : {
			newShape = new RectangleCollisionBody(this.shape.getPosition(), Color.RED);
			break;
		}
		}
		*/
		newShape = this.shape.getNewInstance();
		newShape.setPosition(this.shape.getPosition());
		AnimationWindow.getInstance().addShape(newShape);
	}
	
}

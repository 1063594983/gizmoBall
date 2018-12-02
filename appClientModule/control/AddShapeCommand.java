package control;

import UI.AnimationWindow;
import gizmo.AbstractShape;

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

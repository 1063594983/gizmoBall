package control;

import java.util.ArrayList;

import UI.AnimationWindow;
import gizmo.AbstractShape;

public class ChangeSizeCommand extends Command {
	
	private int step = 10;
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public void setShape(AbstractShape shape) {
		this.shape = shape;
	}
	
	public boolean isChosen() {
		return this.shape != null;
	}
	
	public void execute() {	
		ArrayList <AbstractShape> shapes = AnimationWindow.getInstance().getShapes();
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).contains(this.shape.getPosition())) {
				shapes.get(i).changeSize(step);
				break;
			}
		}
	}

}

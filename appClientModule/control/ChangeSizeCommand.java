package control;

import java.util.ArrayList;

import UI.AnimationWindow;
import gizmo.AbstractShape;

public class ChangeSizeCommand extends Command {
	
	private int step = 10;
	class ChangeMode {
		static final int BIGGER = 0;
		static final int SMALLER = 1;
	}
	private int mode;
	public ChangeSizeCommand(int mode) {
		// TODO Auto-generated constructor stub
		this.mode = mode;
		this.name = "size";
	}
	
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
				if(mode == ChangeMode.BIGGER) shapes.get(i).beBigger(step);
				else shapes.get(i).beSmaller(step);
				break;
			}
		}
	}

}

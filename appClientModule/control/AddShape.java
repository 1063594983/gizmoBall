package control;

import UI.AnimationWindow;
import gizmo.AbstractShape;

//µ¥ÀýÄ£Ê½
public class AddShape {
	static private AbstractShape shape;
	
	static private AnimationWindow animationwindow;
	
	public static void setShape(AbstractShape shape) {
		AddShape.shape = shape;
	}
	
	public static void setAnimationWindow(AnimationWindow win) {
		AddShape.animationwindow = win;
	}
	
	public static void execute() {
		AddShape.animationwindow.addShape(AddShape.shape);
		AddShape.shape = null;
	}
}

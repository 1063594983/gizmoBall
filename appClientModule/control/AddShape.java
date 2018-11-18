package control;

import java.awt.Color;
import java.awt.Point;

import UI.AnimationWindow;
import gizmo.AbstractShape;
import gizmo.RectangleCollisionBody;

//µ¥ÀýÄ£Ê½
public class AddShape {
	static public AbstractShape shape;
	static public String shapename;
	static private AnimationWindow animationwindow;
	
	public static void setShape(AbstractShape shape) {
		AddShape.shape = shape;
	}
	
	public static void setAnimationWindow(AnimationWindow win) {
		AddShape.animationwindow = win;
	}
	
	public static void execute() {
		AbstractShape newshape;
		switch(shapename) {
		case "square": 
			newshape = new RectangleCollisionBody(new Point(500, 500), Color.red);
			newshape.setPosition(shape.getPosition());
		default: 
			newshape = new RectangleCollisionBody(new Point(500, 500), Color.red);
			newshape.setPosition(shape.getPosition());
		}
		//System.out.print(newshape.getPosition().getX());
		AddShape.animationwindow.addShape(newshape);
		
		//AddShape.shape = null;
	}
}

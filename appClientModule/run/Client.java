package run;

import java.awt.Dimension;
import java.awt.Point;

import UI.ApplicationWindow;
import gizmo.Line;

public class Client {
	public static void main(String[] args) {
		ApplicationWindow win = new ApplicationWindow(new Dimension(800, 600), new Point(100, 100));
		
		/*
		Line line1 = new Line(new Point(2, 0), new Point(2, 10));
		Line line2 = new Line(new Point(0, 0), new Point());
		Point p = line1.getIntersectPointVertical(line2);
		
		System.out.println(line1.isIntersectVertical(line2));
		*/
		
	}
}

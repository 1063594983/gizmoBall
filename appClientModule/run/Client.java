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
		Line line2 = new Line(new Point(0, 0), new Point(5, 5));
		Point p = line2.getIntersectPointVertical(line1);
		
		System.out.println(line2.getIntersectPoint(line1));
		*/
		
	}
}

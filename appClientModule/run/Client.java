package run;

import java.awt.Dimension;
import java.awt.Point;

import UI.ApplicationWindow;
import gizmo.Line;

public class Client {
	public static void main(String[] args) {
		ApplicationWindow win = new ApplicationWindow(new Dimension(800, 600), new Point(100, 100));
		
		/*
		Line line1 = new Line(new Point(0, 0), new Point(5, 5));
		Line line2 = new Line(new Point(0, 1), new Point(-1, 1));
		Point p = line2.getIntersectPoint(line1);
		System.out.println(p.x + " " + p.y);
		System.out.println(line1.getIntersectPoint(line2));
		System.out.println(line1.isIntersect(line2));
		*/
		
		
	}
}

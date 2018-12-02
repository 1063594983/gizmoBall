package run;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

import UI.AnimationWindow;
import UI.ApplicationWindow;
import gizmo.Line;

public class Client {
	public static void main(String[] args) {
		ApplicationWindow win = new ApplicationWindow(new Dimension(900, 900), new Point(100, 100));
		win.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("°´×¡");
				AnimationWindow.getInstance().baffle.startRotate();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("ÊÍ·Å");
				AnimationWindow.getInstance().baffle.returnStand();
			}
		});
		
		/*
		Line line1 = new Line(new Point(0, 1), new Point(10, 1));
		Line line2 = new Line(new Point(2, 0), new Point(2, 5));
		Point p = line1.getIntersectPoint(line2);
		System.out.println(p.x + " " + p.y);
		System.out.println(line1.getIntersectPoint(line2));
		System.out.println(line1.isIntersect(line2));
		*/
		
		

//		Line line1 = new Line(new Point(0, 1), new Point(10, 1));
//		Line line2 = new Line(new Point(2, 0), new Point(2, 5));
//		Point p = line1.getIntersectPoint(line2);
//		System.out.println(p.x + " " + p.y);
//		System.out.println(line1.getIntersectPoint(line2));
//		System.out.println(line1.isIntersect(line2));

		
	}
}

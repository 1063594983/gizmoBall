package run;

import java.awt.Dimension;
import java.awt.Point;

import UI.ApplicationWindow;

public class Client {
	public static void main(String[] args) {
		ApplicationWindow win = new ApplicationWindow(new Dimension(800, 600), new Point(100, 100));
	}
}

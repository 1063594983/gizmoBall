package gizmo;

import java.awt.Point;

public class Line {
	public Point p1;
	public Point p2;
	public double k;
	public double b;
	public boolean verticalFlag;
	
	public Line (Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		if(p1.x != p2.x) {
		     k = (p1.y * 1.0 - p2.y * 1.0) / (p1.x - p2.x);
		     b = p1.y - k * p1.x;
		}
	}
	
	public Point getIntersectPoint(Line line) {
		//if(this.k == line.k) return new Point(-1, -1);
		double x = (line.b - this.b) / (this.k - line.k);
		double y = this.k * x + this.b;
		return new Point((int)(x), (int)(y));
	}
	
	public Point getIntersectPointVertical(Line line) {
		double x = p1.x;
		double y = line.k * x + line.b;
		return new Point((int)(x), (int)(y));
	}
	
	public boolean isIntersect(Line line) {
		int x = getIntersectPoint(line).x;
		//if(x == -1 && getIntersectPoint(line).y == -1) return false;
		if(x - 1 <= Math.max(this.p1.x, this.p2.x) && x + 1 >= Math.min(this.p1.x, this.p2.x) 
				&& x - 1 <= Math.max(line.p1.x, line.p2.x) && x + 1 >= Math.min(line.p1.x, line.p2.x))
			return true;
		return false;
	}
	
	public boolean isIntersectVertical(Line line) {
		int x = getIntersectPointVertical(line).x;
		int y = getIntersectPointVertical(line).y;
		//if(x == -1 && y == -1) return false;
		if(y  <= Math.max(this.p1.y, this.p2.y) && y >= Math.min(this.p1.y, this.p2.y) 
				&& y <= Math.max(line.p1.y, line.p2.y) && y >= Math.min(line.p1.y, line.p2.y))
				return true;
		
		/*
		System.out.println(x + " " + y);
		System.out.println(this.p1.y + " " + this.p2.y);
		System.out.println(line.p1.y + " " + line.p2.y);
		System.out.println(y - 1 <= Math.max(this.p1.y, this.p2.y));
		System.out.println(y + 1 >= Math.min(this.p1.y, this.p2.y));
		System.out.println(y - 1 <= Math.max(line.p1.y, line.p2.y));
		System.out.println(y + 1 >= Math.min(line.p1.y, line.p2.y));
		*/
		return false;
	}
}

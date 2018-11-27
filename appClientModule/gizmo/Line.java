package gizmo;

import java.awt.Point;

public class Line {
	public Point p1;
	public Point p2;
	public double k;
	public double b;
	public boolean isVertical;

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		if (p1.x != p2.x) {
			k = (p1.y * 1.0 - p2.y * 1.0) / (p1.x - p2.x);
			b = p1.y - k * p1.x;
			isVertical = false;
		} else {
			k = Integer.MAX_VALUE;
			isVertical = true;

		}
	}

	public Point getIntersectPoint(Line line) {
		double x, y;

		if (this.isVertical) {
			x = p1.x;
			y = line.k * x + line.b;

		} else if (line.isVertical) {
			x = line.p1.x;
			y = this.k * x + this.b;
		} else {
			x = (line.b * 1.0 - this.b * 1.0) / (this.k - line.k);
			y = this.k * x + this.b;
		}

		return new Point((int) x, (int) y);
	}

	public boolean isIntersect(Line line) {
		
		if (this.isVertical && line.isVertical) {
			return false;
		}
		if (this.k == line.k) {
			return false;
		}

		Point p = this.getIntersectPoint(line);
		if (this.isVertical) {
			if (p.y >= Math.min(this.p1.y, this.p2.y) && p.y<= Math.max(this.p1.y, this.p2.y)
					&& p.x>= Math.min(line.p1.x, line.p2.x) && p.x <= Math.max(line.p1.x, line.p2.x)) {
				return true;
			}
		} else if (line.isVertical) {
			if (p.y >= Math.min(line.p1.y, line.p2.y) && p.y<= Math.max(line.p1.y, line.p2.y)
					&& p.x >= Math.min(this.p1.x, this.p2.x) && p.x<= Math.max(this.p1.x, this.p2.x)) {
				return true;
			} 
		} else {
			if (p.x >= Math.min(line.p1.x, line.p2.x) && p.x <= Math.max(line.p1.x, line.p2.x)
					&& p.x >= Math.min(this.p1.x, this.p2.x) && p.x <= Math.max(this.p1.x, this.p2.x)) {
				return true;
			} 
		}
		return false;
	}
}

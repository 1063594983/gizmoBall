package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class TriangleCollisionBody extends AbstractShape implements ICollisionBody {
	
	int count = 5;
	
	public TriangleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "triangle";
		this.location = new Point(100, 100);
		this.color = new Color(204, 204, 0);
	}
	
	public TriangleCollisionBody(Point location, Color color) {
		this.size = new Dimension(50, 50);
		this.name = "triangle";
		this.location = location;
		this.color = color;
	}

	@Override
	public boolean isCollision(Ball ball) {
		count++;
		if (count < 5) return false;
		int[] x = {location.x, location.x + size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height};
		for (int i = 0; i <= 2; i++) {
			int j = (i + 1) % 3;
			if (x[i] == x[j]) {
				if (ball.location.x  < x[i] && ball.location.x + ball.radius >= x[i] && ((ball.location.y + ball.radius >= y[i] && ball.location.y - ball.radius <= y[j]) || (ball.location.y + ball.radius >= y[j] && ball.location.y - ball.radius <= y[i]))) {
					count = 0;
					ball.location.x = x[i] - ball.radius;
					return true;
	    		}
			}
			else if (y[i] == y[j]) {
				if (ball.location.y > y[i] && ball.location.y - ball.radius <= y[j] && ((ball.location.x + ball.radius >= x[i] && ball.location.x - ball.radius <= x[j]) || (ball.location.x + ball.radius >= x[j] && ball.location.x - ball.radius <= x[i]))) {
					count = 0;
					ball.location.y = y[j] + ball.radius;
					return true;
	    		}
			}
			else {
    			double angle1 = Math.atan((double)(y[j]-y[i])/(double)(x[i]-x[j]));
    			double precision = 5;
    			double a = Math.sqrt((double)(x[i]-x[j])*(x[i]-x[j]) + (double)(y[i]-y[j])*(y[i]-y[j]));
				double b = Math.sqrt((double)(ball.location.x-x[i])*(ball.location.x-x[i]) + (double)(ball.location.y-y[i])*(ball.location.y-y[i]));
				double c = Math.sqrt((double)(ball.location.x-x[j])*(ball.location.x-x[j]) + (double)(ball.location.y-y[j])*(ball.location.y-y[j]));
				double p = (a + b + c) / 2;
				double dis = Math.sqrt(p * (p-a) * (p-b) * (p-c)) * 2 / a;
				if (Math.abs(dis - ball.radius) < precision && dis < ball.radius) {
					count = 0;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void changeDirect(Ball ball) {
		int[] x = {location.x, location.x + size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height};
		for (int i = 0; i <= 2; i++) {
			int j = (i + 1) % 3;
			if (x[i] == x[j]) {
				if (ball.location.x  < x[i] && ball.location.x + ball.radius >= x[i] && ((ball.location.y + ball.radius >= y[i] && ball.location.y - ball.radius <= y[j]) || (ball.location.y + ball.radius >= y[j] && ball.location.y - ball.radius <= y[i]))) {
					ball.velocity.x *= -1;
	    		}
			}
			else if (y[i] == y[j]) {
				if (ball.location.y > y[i] && ball.location.y - ball.radius <= y[j] && ((ball.location.x + ball.radius >= x[i] && ball.location.x - ball.radius <= x[j]) || (ball.location.x + ball.radius >= x[j] && ball.location.x - ball.radius <= x[i]))) {
					ball.velocity.y *= -1;
	    		}
			}
			else {
    			double angle1 = Math.atan((double)(y[j]-y[i])/(double)(x[i]-x[j]));
    			double a = Math.sqrt((double)(x[i]-x[j])*(x[i]-x[j]) + (double)(y[i]-y[j])*(y[i]-y[j]));
				double b = Math.sqrt((double)(ball.location.x-x[i])*(ball.location.x-x[i]) + (double)(ball.location.y-y[i])*(ball.location.y-y[i]));
				double c = Math.sqrt((double)(ball.location.x-x[j])*(ball.location.x-x[j]) + (double)(ball.location.y-y[j])*(ball.location.y-y[j]));
				double p = (a + b + c) / 2;
				double dis = Math.sqrt(p * (p-a) * (p-b) * (p-c)) * 2 / a;
				if (dis < ball.radius) {
					double x1 = (ball.location.x - x[i]) * Math.cos(angle1) - (ball.location.y - y[i]) * Math.sin(angle1);
					double y1 = (ball.location.x - x[i]) * Math.sin(angle1) + (ball.location.y - y[i]) * Math.cos(angle1);
					double x2 = (ball.location.x - x[j]) * Math.cos(angle1) - (ball.location.y - y[j]) * Math.sin(angle1);
					double y2 = (ball.location.x - x[j]) * Math.sin(angle1) + (ball.location.y - y[j]) * Math.cos(angle1);
					if (((y1 > 0 && y1 - ball.radius <= 0) || (y1 < 0 && y1 + ball.radius >= 0)) && (x1 >= 0 && x2 <= 0) || (x1 <= 0 && x2 >= 0)) {
						double vx = (double) ball.velocity.x, vy = (double) ball.velocity.y;
						//double转为int，会损失精度，即为考虑摩擦
						ball.velocity.x = (int) (vx * (Math.cos(angle1) * Math.cos(angle1) - Math.sin(angle1) * Math.sin(angle1)) - 2 * vy * Math.sin(angle1) * Math.cos(angle1));
						ball.velocity.y = (int) (vy * (Math.sin(angle1) * Math.sin(angle1) - Math.cos(angle1) * Math.cos(angle1)) - 2 * vx * Math.sin(angle1) * Math.cos(angle1));
					}
				}
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		int[] arr1 = new int[3];
		int[] arr2 = new int[3];	
		arr1[0] = this.location.x;
		arr1[1] = arr1[0];
		arr1[2] = arr1[0] + this.size.width;
		arr2[0] = this.location.y;
		arr2[1] = arr2[0] + this.size.height;
		arr2[2] = arr2[0];
		g.setColor(this.color);
		g.fillPolygon(arr1, arr2, 3);
	}

	@Override
	public boolean contains(Point p) {
		int[] arr1 = new int[3];
		int[] arr2 = new int[3];
		
		arr1[0] = this.location.x;
		arr1[1] = arr1[0];
		arr1[2] = arr1[0] + this.size.width;
		arr2[0] = this.location.y;
		arr2[1] = arr2[0] + this.size.height;
		arr2[2] = arr2[0];
		if(new Polygon(arr1, arr2, 3).contains(p)) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public TriangleCollisionBody getNewInstance() {
		return new TriangleCollisionBody();
	}

}

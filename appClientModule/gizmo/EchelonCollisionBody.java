package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class EchelonCollisionBody extends AbstractShape implements ICollisionBody {
	
	int count = 5;
	
	public EchelonCollisionBody() {
		this.size = new Dimension(40, 40);
		this.name = "echelon";
		this.color = new Color(102, 178, 255);
	}
	
	public EchelonCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(40, 40);
		this.color = color;
		this.name = "echelon";
	}

	@Override
	public void paint(Graphics g) {
		int[] arr1 = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] arr2 = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
 		g.setColor(this.color);
		g.fillPolygon(arr1, arr2, 4);
	}

	@Override
	public boolean isCollision(Ball ball) {
		count++;
		if (count < 5) return false;
		int[] x = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] y = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
		if (ball.location.y <= y[0] && ball.location.y + ball.radius >= y[0] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
			count = 0;
			ball.location.y = y[0] - ball.radius;
			return true;
        }
        else if (ball.location.y >= y[2] && ball.location.y - ball.radius <= y[2] && ball.location.x + ball.radius >= x[3] && ball.location.x - ball.radius <= x[2]) {
        	count = 0;
        	ball.location.y = y[2] + ball.radius;
        	return true;
        }
		
        else {
        	for (int i = 1; i <= 3; i+=2) {
        		int j = (i + 1) % 4;
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
		int[] x = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] y = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
		if (ball.location.y <= y[0] && ball.location.y + ball.radius >= y[0] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
			ball.velocity.y *= -1;
        }
        else if (ball.location.y >= y[2] && ball.location.y - ball.radius <= y[2] && ball.location.x + ball.radius >= x[3] && ball.location.x - ball.radius <= x[2]) {
        	ball.velocity.y *= -1;
        }
        else {
        	for (int i = 1; i <= 3; i+=2) {
        		int j = (i + 1) % 4;
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
	public boolean contains(Point p) {
		int[] arr1 = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] arr2 = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
		if(new Polygon(arr1, arr2, 4).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EchelonCollisionBody getNewInstance() {
		// TODO Auto-generated method stub
		return new EchelonCollisionBody();
	}
}

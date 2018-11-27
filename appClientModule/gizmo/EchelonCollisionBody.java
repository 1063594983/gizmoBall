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
		int[] x = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] y = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;
		
		Line top = new Line(new Point(x[0], y[0]), new Point(x[1], y[1]));
		Line buttom = new Line(new Point(x[2], y[2]), new Point(x[3], y[3]));
		Line rightHypotenuse = new Line(new Point(x[1], y[1]), new Point(x[2], y[2]));
		Line leftHypotenuse = new Line(new Point(x[3], y[3]), new Point(x[0], y[0]));
		Line ballLine = new Line(new Point(X, Y), new Point(X + vx, Y + vy));
		
		if(top.isIntersect(ballLine)) {
			ball.location.x = top.getIntersectPoint(ballLine).x;
			ball.location.y = top.getIntersectPoint(ballLine).y - ball.radius;

			ball.velocity.y *= -1;
			return true;
		} else if(buttom.isIntersect(ballLine)) {
			ball.location.x = buttom.getIntersectPoint(ballLine).x;
			ball.location.y = buttom.getIntersectPoint(ballLine).y + ball.radius;

			ball.velocity.y *= -1;
			return true;
		} else if(leftHypotenuse.isIntersect(ballLine)) {
			ball.location.y = leftHypotenuse.getIntersectPoint(ballLine).y - ball.radius;
			ball.location.x = leftHypotenuse.getIntersectPoint(ballLine).x - ball.radius;
			ball.velocity.x = -vy;
			ball.velocity.y = -vx;

			return true;
		} else if(rightHypotenuse.isIntersect(ballLine)) {
			ball.location.y = rightHypotenuse.getIntersectPoint(ballLine).y - ball.radius;
			ball.location.x = rightHypotenuse.getIntersectPoint(ballLine).x + ball.radius;
			ball.velocity.x = vy;
			ball.velocity.y = vx;

			return true;
		}
		
		return false;
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

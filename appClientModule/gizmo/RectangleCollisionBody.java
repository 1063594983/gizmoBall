package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class RectangleCollisionBody extends AbstractShape implements ICollisionBody {
	
	public RectangleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "rectangle";
		this.color = new Color(248, 206, 204);
	}
	
	public RectangleCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "rectangle";
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(location.x, location.y, size.width, size.height);
	}

	@Override
	public boolean isCollision(Ball ball) {
		int[] x = {location.x, location.x + size.width, location.x + size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;
		Line top = new Line(new Point(x[0], y[0]), new Point(x[1], y[1]));
		Line right = new Line(new Point(x[1], y[1]), new Point(x[2], y[2]));
		Line buttom = new Line(new Point(x[2], y[2]), new Point(x[3], y[3]));
		Line left = new Line(new Point(x[3], y[3]), new Point(x[0], y[0]));
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
		} else if(left.isIntersect(ballLine)) {
			ball.location.y = left.getIntersectPoint(ballLine).y;
			ball.location.x = left.getIntersectPoint(ballLine).x - ball.radius;

			ball.velocity.x *= -1;
			return true;
		} else if(right.isIntersect(ballLine)) {
			ball.location.y = right.getIntersectPoint(ballLine).y;
			ball.location.x = right.getIntersectPoint(ballLine).x + ball.radius;

			ball.velocity.x *= -1;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean contains(Point p) {
		if(new Rectangle(location.x, location.y, size.width, size.height).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public RectangleCollisionBody getNewInstance() {
		return new RectangleCollisionBody();
	}
}

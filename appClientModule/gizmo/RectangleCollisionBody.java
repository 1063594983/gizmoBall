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
		/*if (Y <= y[0] && Y + vy > y[0] && X + ball.radius + vx >= x[0] && X - ball.radius + vx <= x[1]) {
			ball.location.y = y[0] - ball.radius;
			if(ball.velocity.y > 0) ball.velocity.y --;
			else ball.velocity.y ++;
			ball.velocity.y *= -1;
			return true;
        }
        else if (Y >= y[2] && Y + vy < y[2] && X + ball.radius + vx >= x[0] && X - ball.radius + vx <= x[1]) {
			ball.location.y = y[2] + ball.radius;
			if(ball.velocity.y > 0) ball.velocity.y --;
			else ball.velocity.y ++;
			ball.velocity.y *= -1;
			return true;
        }
        else if (X <= x[0] && X + vx > x[0] && Y + ball.radius + vy >= y[0] && Y - ball.radius + vy <= y[3]) {
			ball.location.x = x[0] - ball.radius;
			return true;
        }
        else if (X >= x[2] && X + vx < x[2] && Y + ball.radius + vy >= y[0] && Y - ball.radius + vy <= y[3]) {
        	ball.location.x = x[2] + ball.radius;
			return true;
        }
        else {
        	return false;
        }*/
		
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
			System.out.println("ball.v: " + ball.velocity.x + "   " + ball.velocity.y);
			System.out.println("left");
			ball.location.y = left.getIntersectPoint(ballLine).y;
			ball.location.x = left.getIntersectPoint(ballLine).x - ball.radius;
			ball.velocity.x *= -1;
			return true;
		} else if(right.isIntersect(ballLine)) {
			System.out.println("ball.v: " + ball.velocity.x + "   " + ball.velocity.y);
			System.out.println("right");
			ball.location.y = right.getIntersectPoint(ballLine).y;
			ball.location.x = right.getIntersectPoint(ballLine).x + ball.radius;
			ball.velocity.x *= -1;
			return true;
		}
		
		return false;
	}

	@Override
	public void changeDirect(Ball ball) {
		int[] x = {location.x, location.x + size.width, location.x +size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		if (ball.location.y <= y[0] && ball.location.x + ball.radius >= x[0]
				&& ball.location.x - ball.radius <= x[1]) {
			if(ball.location.y + ball.velocity.y > y[0]) {
				if(ball.velocity.y > 0) ball.velocity.y --;
				else ball.velocity.y ++;
				ball.velocity.y *= -1;
			}
        }
        else if (ball.location.y >= y[2] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
        	if(ball.location.y + ball.velocity.y < y[2]) {
        		ball.velocity.y *= -1;
			}
        }
        else if (ball.location.x <= x[0] && ball.location.y + ball.radius >= y[0] && ball.location.y - ball.radius <= y[3]) {
        	if(ball.location.x + ball.velocity.x > x[0]) {
        		ball.velocity.x *= -1;
			}
        }
        else if (ball.location.x >= x[2] && ball.location.y + ball.radius >= y[0] && ball.location.y - ball.radius <= y[3]) {
        	if(ball.location.x + ball.velocity.x < x[2]) {
        		ball.velocity.x *= -1;
			}
        }
        else {
        	
        }
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

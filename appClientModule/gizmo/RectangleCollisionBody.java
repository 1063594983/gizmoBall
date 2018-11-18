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
		int[] x = {location.x, location.x + size.width, location.x +size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		if (ball.location.y <= y[0] && ball.location.y + ball.radius >= y[0] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
			ball.location.y = y[0] - ball.radius;
			return true;
        }
        else if (ball.location.y >= y[2] && ball.location.y - ball.radius <= y[2] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
        	ball.location.y = y[2] + ball.radius;
			return true;
        }
        else if (ball.location.x <= x[0] && ball.location.x + ball.radius >= x[0] && ball.location.y + ball.radius >= y[0] && ball.location.y - ball.radius <= y[3]) {
        	ball.location.x = x[0] - ball.radius;
        	return true;
        }
        else if (ball.location.x >= x[2] && ball.location.x - ball.radius <= x[2] && ball.location.y + ball.radius >= y[0] && ball.location.y - ball.radius <= y[3]) {
        	ball.location.x = x[2] + ball.radius;
        	return true;
        }
        else {
        	return false;
        }
	}

	@Override
	public void changeDirect(Ball ball) {
		int[] x = {location.x, location.x + size.width, location.x +size.width, location.x};
		int[] y = {location.y, location.y, location.y + size.height, location.y + size.height};
		if (ball.location.y <= y[0] && ball.location.y + ball.radius >= y[0] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
			ball.velocity.y *= -1;
        }
        else if (ball.location.y >= y[2] && ball.location.y - ball.radius <= y[2] && ball.location.x + ball.radius >= x[0] && ball.location.x - ball.radius <= x[1]) {
			ball.velocity.y *= -1;
        }
        else if (ball.location.x <= x[0] && ball.location.x + ball.radius >= x[0] && ball.location.y + ball.radius >= y[0] && ball.location.y - ball.radius <= y[3]) {
        	ball.velocity.x *= -1;
        }
        else if (ball.location.x >= x[2] && ball.location.x - ball.radius <= x[2] && ball.location.y + ball.radius >= y[0] && ball.location.y - ball.radius <= y[3]) {
        	ball.velocity.x *= -1;
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

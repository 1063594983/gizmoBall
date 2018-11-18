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
		this.color = Color.RED;
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
		if(new Rectangle(location.x - ball.radius, location.y - ball.radius, size.width + 2 * ball.radius, size.height + 2 * ball.radius).contains(ball.location)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void changeDirect(Ball ball) {
		if(Math.abs(ball.location.x - location.x) <= ball.radius || Math.abs(ball.location.x - location.x - size.width) <= ball.radius) {
			ball.velocity.y *= -1;
		}
		if(Math.abs(ball.location.y - location.y) <= ball.radius || Math.abs(ball.location.y - location.y - size.height) <= ball.radius) {
			ball.velocity.x *= -1;
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

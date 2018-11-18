package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class EchelonCollisionBody extends AbstractShape implements ICollisionBody {
	// 位置
	Point location;

	// 大小
	Dimension size;

	// 颜色
	Color color;
	
	public EchelonCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "rectangle";
	}
	
	public EchelonCollisionBody(Point location, Color color) {
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
	public void setPosition(Point p) {
		this.location = p;
	}

	@Override
	public Point getPosition() {
		return this.location;
	}

	@Override
	public void changeSize(int step) {
		this.size.width += step;
		this.size.height += step;
	}
}

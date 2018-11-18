package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class CircleCollisionBody extends AbstractShape implements ICollisionBody{
	
	int count = 5;
	
	public CircleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "circle";
		this.color = new Color(128, 255, 0);
	}
	
	public CircleCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "circle";
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x - this.size.width / 2, location.y - this.size.height / 2, this.size.width, this.size.height);
	}

	@Override
	public boolean isCollision(Ball ball) {
		count++;
		if (count < 5) return false;
		double dis = Math.sqrt((location.x - ball.location.x) * (location.x - ball.location.x) + (location.y - ball.location.y) * (location.y - ball.location.y));
		double precision = 10;
		if (Math.abs(dis - ball.radius - this.size.width / 2) < precision && dis < ball.radius + this.size.width / 2) {
			count = 0;
			return true;
		}
		return false;
	}

	@Override
	public void changeDirect(Ball ball) {
		double angle1 = Math.atan((double)(ball.location.x - location.x)/(double)(ball.location.y - location.y));
		double vx = (double) ball.velocity.x, vy = (double) ball.velocity.y;
		//double转为int，会损失精度，即为考虑摩擦
		ball.velocity.x = (int) (vx * (Math.cos(angle1) * Math.cos(angle1) - Math.sin(angle1) * Math.sin(angle1)) - 2 * vy * Math.sin(angle1) * Math.cos(angle1));
		ball.velocity.y = (int) (vy * (Math.sin(angle1) * Math.sin(angle1) - Math.cos(angle1) * Math.cos(angle1)) - 2 * vx * Math.sin(angle1) * Math.cos(angle1));
	}

	@Override
	public boolean contains(Point p) {
		if(new Rectangle(location.x - this.size.width / 2, location.y - this.size.height / 2, 
				size.width, size.height).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CircleCollisionBody getNewInstance() {
		return new CircleCollisionBody();
	}	
}

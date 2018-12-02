package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import config.Config;

public class CircleCollisionBody extends AbstractShape implements ICollisionBody{
	
	int count = 5;
	
	public CircleCollisionBody() {
		this.size = Config.CIRSIZE;
		this.name = "circle";
		this.color = new Color(128, 255, 0);
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
			changeDirect(ball);
			return true;
		}
		return false;
		
		/*
		Point p = new Point(ball.location.x + ball.velocity.x, ball.location.y + ball.velocity.y);
		if(this.contains(p)) {
			changeDirect(ball);
			return true;
		}
		return false;
		*/
	}

	public void changeDirect(Ball ball) {
		double angle1 = Math.atan((double)(ball.location.x - location.x)/(double)(ball.location.y - location.y));
		double vx = (double) ball.velocity.x, vy = (double) ball.velocity.y;
		ball.location.x = (int) (location.x + this.size.height * Math.cos(angle1));
		ball.location.y = (int) (location.y + this.size.height * Math.sin(angle1));
		//double转为int，会损失精度，即为考虑摩擦
		ball.velocity.x = (int) (vx * (Math.cos(angle1) * Math.cos(angle1) - Math.sin(angle1) * Math.sin(angle1)) - 2 * vy * Math.sin(angle1) * Math.cos(angle1));
		ball.velocity.y = (int) (vy * (Math.sin(angle1) * Math.sin(angle1) - Math.cos(angle1) * Math.cos(angle1)) - 2 * vx * Math.sin(angle1) * Math.cos(angle1));
	}

	@Override
	public boolean contains(Point p) {
		/*
		if(new Rectangle(location.x - this.size.width / 2, location.y - this.size.height / 2, 
				size.width, size.height).contains(p)) {
			return true;
		} else {
			return false;
		}
		*/
		if(p.distance(location) <= this.size.width) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CircleCollisionBody getNewInstance() {
		return new CircleCollisionBody();
	}
	
	@Override
	public void rotate() {

	}

}

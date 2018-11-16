package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import UI.AnimationWindow;

public class Ball extends AbstractBall {
	
	//位置
	public Point location;
	
	//半径
	public int radius;
	
	//速度
	public Point velocity; 
	
	//颜色
	public Color color;
	
	
	AnimationWindow win;
	
	public Ball(AnimationWindow win) {
		this.location = new Point(400, 400);
		this.radius = 6;
		this.velocity = new Point(5, 5);
		this.color = Color.RED;
		this.win = win;
	}

	@Override
	public void move() {
		this.location.translate(velocity.x, velocity.y);
		if(this.location.x <= this.radius) {
			this.location.x = this.radius;
			this.velocity.x *= -1;
		}
		if(this.location.x >= this.win.getWidth() - this.radius) {
			this.location.x = this.win.getWidth() - this.radius;
			this.velocity.x *= -1;
		}
		if(this.location.y <= this.radius) {
			this.location.y = this.radius;
			this.velocity.y *= -1;
		}
		if(this.location.y >= this.win.getHeight() - this.radius) {
			this.location.y = this.win.getHeight() - this.radius;
			this.velocity.y *= -1;
		}
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x, location.y, 2 * radius, 2 * radius);
	}

}

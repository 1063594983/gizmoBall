package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import UI.AnimationWindow;

public class Ball {
	
	//λ��
	public Point location;
	
	//�뾶
	public int radius;
	
	//�ٶ�
	public Point velocity; 
	
	//��ɫ
	public Color color;
	
	
	AnimationWindow win;
	
	public Ball(AnimationWindow win) {
		this.location = new Point(400, 400);
		this.radius = 6;
		this.velocity = new Point(1, 1);
		this.color = Color.RED;
		this.win = win;
	}

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

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x, location.y, 2 * radius, 2 * radius);
	}

	public int getRadius() {
		// TODO Auto-generated method stub
		return this.radius;
	}

	public Point getPosition() {
		// TODO Auto-generated method stub
		return this.location;
	}

}

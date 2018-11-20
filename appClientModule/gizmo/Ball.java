package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import UI.AnimationWindow;

public class Ball {
	
	//位置
	public Point location;
	
	//半径
	public int radius;
	
	//速度
	public Point velocity; 
	
	//颜色
	public Color color;
	
	//计数器
	private int count;
	
	AnimationWindow win;
	
	public Ball(AnimationWindow win) {
		this.location = new Point(50, 50);
		this.radius = 6;
		this.velocity = new Point(5, 0);
		this.color = Color.RED;
		this.win = win;
		this.count = 0;
	}

	public void move() {
		//System.out.println("x : " + location.x + " y :" + location.y);
		//System.out.println("vx : " + velocity.x + " vy :" + velocity.y);
//		System.out.println("ball vx:" + this.velocity.x + ",   vy:" + this.velocity.y);
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
		this.count++;
		if(this.count == 3) {
			if(velocity.y >= 15) {
				
			} else {
				//velocity.y += 1;		
			}
			this.count = 0;
			
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

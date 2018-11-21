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
		this.location = new Point(10, 10);
		this.radius = 10;
		this.velocity = new Point(8, 8);
		this.color = Color.RED;
		this.win = win;
		this.count = 0;
	}

	public void move() {
		this.location.translate(velocity.x, velocity.y);
		if(this.location.x <= this.radius) {
			this.location.x = this.radius;
			if(this.velocity.x <= -3) {
				this.velocity.x += 3;
			} else {
				this.velocity.x = 0;
			}
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
			if(this.velocity.y >= 4) {
				this.velocity.y -= 4;
			} else {
				this.velocity.y = 0;
			}
			if(this.velocity.x >= 0) {
				this.velocity.x--;
			} else {
				this.velocity.x++;
			}
			this.velocity.y *= -1;
			this.velocity.y -= 10;
			if(this.velocity.x >= 0) {
				this.velocity.x += 5;
			} else {
				this.velocity.x -= 5;
			}
		}
		
		
		this.count++;
		if(this.count == 3) {
			if(velocity.y >= 30) {
				
			} else {
				velocity.y += 3;		
			}
			this.count = 0;
			
		}
		
		
		
		
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
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

package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import UI.AnimationWindow;
import config.Config;

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
	
	private int count2;
	
	//静止
	private boolean isStand;
	
	AnimationWindow win;
	
	public Ball(AnimationWindow win) {
		this.location = Config.BALLLOCATION;
		this.radius = Config.BALLRADIUS;
		this.velocity = Config.BALLVELOCITY;
		this.color = Color.RED;
		this.win = win;
		this.count = 0;
		this.isStand = false;
	}

	public void move() {
		this.location.translate(velocity.x, velocity.y);
		if(this.location.x <= this.radius) {
			this.velocity.x *= -1;
		}
		if(this.location.x >= this.win.getWidth() - this.radius) {
			this.location.x = this.win.getWidth() - this.radius;
			this.velocity.x *= -1;
		}
		if(this.location.y <= this.radius) {
			this.location.y = this.radius;
			this.velocity.y *= -1;
			if(Math.abs(this.velocity.y) <= 2) {
				this.isStand = true;
			}
		}
		if(this.location.y >= this.win.getHeight() - this.radius) {
			this.location.y = this.win.getHeight() - this.radius;	
			this.velocity.y *= -1;
			if(Math.abs(this.velocity.y) <= 2) {
				this.isStand = true;
			}
		}
		
		
		this.count++;
		if(this.count == 2) {
			if(velocity.y >= 15) {
				
			} else {
				if(isStand) {
					this.velocity.y = 0;
					this.count2++;
					if(count2 == 10) {
						if(this.velocity.x > 0) {
							this.velocity.x--;
						} else if(this.velocity.x < 0) {
							this.velocity.x++;
						}
						count2 = 0;
					}			
				} else {
					this.velocity.y++;
				}
			}
			this.count = 0;	
		}		
	}

	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
	}
}

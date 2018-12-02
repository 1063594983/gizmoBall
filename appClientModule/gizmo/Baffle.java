package gizmo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class Baffle extends AbstractShape implements ICollisionBody {
	
	//RectangleCollisionBody left = new RectangleCollisionBody();
	//RectangleCollisionBody right = new RectangleCollisionBody();
	int baffleWidth;
	double degree;
	int count = 0;
	double step = Math.PI / 50;
	public int keyCode = 87;	//w
	Line line1;
	Line line2;
	
	//0--¾²Ö¹ 1--ÉÏÉý 2--
	int mode;
	
	public Baffle() {
		this.setColor(Color.BLUE);
		this.size = new Dimension(100, 50);
		this.location = new Point(-100, -100);
		this.color = new Color(215, 155, 0);
		this.name = "baffle";
		baffleWidth = 10;
		degree = Math.PI / 4;
		mode = 0;
	}

	@Override
	public void paint(Graphics g) {
		/*
		left.setPosition(new Point(location.x - size.width / 2 - baffleWidth, location.y - size.height / 2));
		left.setSize(new Dimension(baffleWidth, size.height));
		right.setPosition(new Point(location.x + size.width / 2, location.y - size.height / 2));
		right.setSize(new Dimension(baffleWidth, size.height));
		*/
		if(mode == 1) {
			if(degree < Math.PI * 3 / 4) {
				degree += step;
			}
		} else {
			if(degree >= Math.PI / 4) {
				degree -= step;
			}
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.color);
		g2.setStroke(new BasicStroke(3.0f));
		/*
		g2.drawLine(location.x - size.width / 2, location.y - size.height / 2, 
				location.x - size.width / 2 + (int)(size.height * Math.sin(degree)), 
				location.y - size.height / 2 + (int)(size.height * Math.cos(degree)));
				
		g2.drawLine(location.x + size.width / 2, location.y - size.height / 2, 
				location.x + size.width / 2 - (int)(size.height * Math.sin(degree)), 
				location.y - size.height / 2 + (int)(size.height * Math.cos(degree)));
				*/
		line1 = new Line(new Point(location.x - size.width / 2, location.y - size.height / 2), 
				new Point(location.x - size.width / 2 + (int)(size.height * Math.sin(degree)), 
						location.y - size.height / 2 + (int)(size.height * Math.cos(degree))));
		
		line2 = new Line(new Point(location.x + size.width / 2, location.y - size.height / 2), 
				new Point(location.x + size.width / 2 - (int)(size.height * Math.sin(degree)), 
						location.y - size.height / 2 + (int)(size.height * Math.cos(degree))));
		g2.drawLine(line1.p1.x, line1.p1.y, line1.p2.x, line1.p2.y);
		g2.drawLine(line2.p1.x, line2.p1.y, line2.p2.x, line2.p2.y);
	}

	@Override
	public void rotate() {
		
	}

	@Override
	public boolean contains(Point p) {
		if(new Rectangle(location.x - size.width / 2, location.y - size.height / 2, size.width, size.height).contains(p)) {
			return true;
		}
		return false;
	}

	@Override
	public Baffle getNewInstance() {
		return new Baffle();
	}

	@Override
	public boolean isCollision(Ball ball) {
		Line ballLine = new Line(new Point(ball.location.x, ball.location.y), 
				new Point(ball.location.x + ball.velocity.x, ball.location.y + ball.velocity.y));
		if(ballLine.isIntersect(line1) || ballLine.isIntersect(line2)) {
			ball.velocity.y *= -1;
			if(this.mode == 1) {
				ball.velocity.y -= 2;
				if(ball.velocity.x >= 0) {
					ball.velocity.x ++;
				} else if(ball.velocity.x < 0) {
					ball.velocity.x--;
				}
			} else {
				ball.velocity.y += 1;
			}
			return true;
		}
		return false;
	}
	
	public void startRotate() {
		mode = 1;
	}
	
	public void returnStand() {
		mode = 0;
	}

}
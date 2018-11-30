package gizmo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Baffle extends AbstractShape implements ICollisionBody {
	
	RectangleCollisionBody left = new RectangleCollisionBody();
	RectangleCollisionBody right = new RectangleCollisionBody();
	int baffleWidth;
	double degree;
	int count = 0;
	double step = Math.PI / 50;
	
	public Baffle() {
		this.setColor(Color.BLUE);
		this.size = new Dimension(80, 35);
		this.color = new Color(215, 155, 0);
		baffleWidth = 10;
		degree = Math.PI / 4;
	}

	@Override
	public void paint(Graphics g) {
		left.setPosition(new Point(location.x - size.width / 2 - baffleWidth, location.y - size.height / 2));
		left.setSize(new Dimension(baffleWidth, size.height));
		right.setPosition(new Point(location.x + size.width / 2, location.y - size.height / 2));
		right.setSize(new Dimension(baffleWidth, size.height));
		
		/*
		left.paint(g);
		right.paint(g);
		*/	
		/*
		g.drawLine(location.x - size.width / 2, location.y - size.height / 2, 
				location.x - size.width / 2, location.y + size.height / 2);
		g.drawLine(location.x + size.width / 2, location.y - size.height / 2, 
				location.x + size.width / 2, location.y + size.height / 2);
		*/
		count++;
		if(count == 1) {
			if(degree < Math.PI * 3 / 4 || true) {
				degree += step;
			}
			count = 0;
		}
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.color);
		g2.setStroke(new BasicStroke(3.0f));
		g2.drawLine(location.x - size.width / 2, location.y - size.height / 2, 
				location.x - size.width / 2 + (int)(size.height * Math.sin(degree)), 
				location.y - size.height / 2 + (int)(size.height * Math.cos(degree)));
		g2.drawLine(location.x + size.width / 2, location.y - size.height / 2, 
				location.x + size.width / 2 - (int)(size.height * Math.sin(degree)), 
				location.y - size.height / 2 + (int)(size.height * Math.cos(degree)));
	}

	@Override
	public void rotate() {
		
	}

	@Override
	public boolean contains(Point p) {
		return false;
	}

	@Override
	public Baffle getNewInstance() {
		return new Baffle();
	}

	@Override
	public boolean isCollision(Ball ball) {
		if(left.isCollision(ball) || right.isCollision(ball)) {
			return true;
		}
		return false;
	}

}
package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import config.Config;

public class VerticalPipe extends AbstractShape implements ICollisionBody {

	private int pipeWidth;
	RectangleCollisionBody rect1;
	RectangleCollisionBody rect2;
	
	int count = 0;

	public VerticalPipe() {
		this.size = Config.VERSIZE;
		this.name = "VerticalPipe";
		this.color = Color.BLACK;
		this.pipeWidth = Config.PIPEWIDTH;
		rect1 = new RectangleCollisionBody();
		rect2 = new RectangleCollisionBody();
	}
	
	@Override
	public boolean isCollision(Ball ball) {
		if(rect1.isCollision(ball) || rect2.isCollision(ball)) {
			count++;
			if(count == Config.PIPEFRICTION) {
				ballSlow(ball);
				count = 0;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void paint(Graphics g) {
		if(mode == 0) {
			rect1.setPosition(new Point(location.x - size.width / 2 - pipeWidth, location.y - size.height / 2));
			rect1.setSize(new Dimension(pipeWidth, size.height));
			rect2.setPosition(new Point(location.x + size.width / 2, location.y - size.height / 2));
			rect2.setSize(new Dimension(pipeWidth, size.height));
		} else {
			rect1.setPosition(new Point(location.x - size.height / 2, location.y - size.width / 2 - pipeWidth));
			rect1.setSize(new Dimension(size.height, pipeWidth));
			rect2.setPosition(new Point(location.x - size.height / 2, location.y + size.width / 2));
			rect2.setSize(new Dimension(size.height, pipeWidth));
		}
		rect1.setColor(this.color);
		rect2.setColor(this.color);
		rect1.paint(g);
		rect2.paint(g);
		
	}

	@Override
	public boolean contains(Point p) {
		return rect1.contains(p)||rect2.contains(p);
	}

	@Override
	public VerticalPipe getNewInstance() {
		return new VerticalPipe();
	}
	
	@Override
	public void rotate() {
		this.mode = (this.mode + 1) % 2;
	}	
}
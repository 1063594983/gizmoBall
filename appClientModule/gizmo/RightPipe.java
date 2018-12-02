package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import config.Config;

public class RightPipe extends AbstractShape implements ICollisionBody {

	private int pipeWidth;

	RectangleCollisionBody rect1;
	RectangleCollisionBody rect2;
	
	int count = 0; //Ã¿×²5ÏÂ¼õËÙ

	public RightPipe() {
		this.size = Config.RIGHTSIZE;
		this.name = "RightPipe";
		this.color = Color.BLACK;
		this.pipeWidth = Config.PIPEWIDTH;
		this.mode = 0;
		rect1 = new RectangleCollisionBody();
		rect2 = new RectangleCollisionBody();
	}

	/*
	public RightPipe(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "RightPipe";
		this.pipeWidth = 10;
	}
	*/

	@Override
	public boolean isCollision(Ball ball) {
		if (rect1.isCollision(ball) || rect2.isCollision(ball)) {
			count++;
			if(count == 5) {
				ballSlow(ball);
				count = 0;
			}
			return true;
		}
		return false;

	}

	@Override
	public void paint(Graphics g) {
		switch (this.mode) {
		case 0: {
			rect1.setPosition(new Point(location.x, location.y - size.height));
			rect1.setSize(new Dimension(pipeWidth, size.height));
			rect2.setPosition(new Point(location.x, location.y - pipeWidth));
			rect2.setSize(new Dimension(size.width, pipeWidth));
			break;
		}
		case 1: {
			rect1.setPosition(new Point(location.x, location.y));
			rect1.setSize(new Dimension(size.height, pipeWidth));
			rect2.setPosition(new Point(location.x, location.y));
			rect2.setSize(new Dimension(pipeWidth, size.width));
			break;
		}
		case 2: {
			rect1.setPosition(new Point(location.x - pipeWidth, location.y));
			rect1.setSize(new Dimension(pipeWidth, size.height));
			rect2.setPosition(new Point(location.x - size.width, location.y));
			rect2.setSize(new Dimension(size.width, pipeWidth));
			break;
		}
		case 3: {
			rect1.setPosition(new Point(location.x - size.width, location.y - pipeWidth));
			rect1.setSize(new Dimension(size.width, pipeWidth));
			rect2.setPosition(new Point(location.x - pipeWidth, location.y - size.height));
			rect2.setSize(new Dimension(pipeWidth, size.height));
			break;
		}
		default: {

		}
		}
		rect1.setColor(this.color);
		rect2.setColor(this.color);
		rect1.paint(g);
		rect2.paint(g);
	}

	@Override
	public boolean contains(Point p) {
		return rect1.contains(p) || rect2.contains(p);

	}

	@Override
	public RightPipe getNewInstance() {
		return new RightPipe();
	}

	@Override
	public void rotate() {
		this.mode = (this.mode + 1) % 4;
	}

}
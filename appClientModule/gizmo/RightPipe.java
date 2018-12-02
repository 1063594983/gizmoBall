package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class RightPipe extends AbstractShape implements ICollisionBody {

	private int pipeWidth;

	RectangleCollisionBody rect1;
	RectangleCollisionBody rect2;
	
	int count = 0; //Ã¿×²5ÏÂ¼õËÙ

	public RightPipe() {
		this.size = new Dimension(50, 50);
		this.name = "RightPipe";
		//this.color = new Color(248, 206, 204);
		this.color = Color.BLACK;
		this.pipeWidth = 10;
		this.mode = 0;
		rect1 = new RectangleCollisionBody(new Point(1, 1), this.color, new Dimension(1, 1));
		rect2 = new RectangleCollisionBody(new Point(1, 1), this.color, new Dimension(1, 1));
	}

	public RightPipe(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "RightPipe";
		this.pipeWidth = 10;
	}

	@Override
	public boolean isCollision(Ball ball) {
		if (rect1.isCollision(ball) || rect2.isCollision(ball)) {
			count++;
			if(count == 5) {
				if(ball.velocity.x > 0) {
					ball.velocity.x--;
				} else if(ball.velocity.x < 0) {
					ball.velocity.x++;
				}
				if(ball.velocity.y > 0) {
					ball.velocity.y--;
				} else if(ball.velocity.y < 0) {
					ball.velocity.y++;
				}
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
		g.setColor(this.color);
		
		g.fillRect(rect1.getPosition().x, rect1.getPosition().y, rect1.getSize().width, rect1.getSize().height);
		g.fillRect(rect2.getPosition().x, rect2.getPosition().y, rect2.getSize().width, rect2.getSize().height);
		/*
		rect1.paint(g);
		rect2.paint(g);
		*/
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
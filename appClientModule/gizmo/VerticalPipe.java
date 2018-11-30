package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.plaf.DimensionUIResource;

public class VerticalPipe extends AbstractShape implements ICollisionBody {

	private int pipeWidth;
	RectangleCollisionBody rect1;
	RectangleCollisionBody rect2;
	
	
	public VerticalPipe() {
		this.size = new Dimension(50, 50);
		this.name = "VerticalPipe";
		this.color = new Color(248, 206, 204);
		this.pipeWidth = 10;
		rect1 = new RectangleCollisionBody();
		rect2 = new RectangleCollisionBody();
	}
	
	public VerticalPipe(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "VerticalPipe";
		this.pipeWidth = 10;
	}
	
	@Override
	public boolean isCollision(Ball ball) {
		if(rect1.isCollision(ball) || rect2.isCollision(ball)) {
			/*
			if (ball.velocity.y > 0) {
				ball.velocity.y++;
			} else if (ball.velocity.y < 0) {
				ball.velocity.y--;
			}

			if (ball.velocity.x > 0) {
				ball.velocity.x++;
			} else if (ball.velocity.x < 0) {
				ball.velocity.x--;
			}
			*/
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
		/*
		g.setColor(this.color);
		g.fillRect(location.x, location.y, pipeWidth, size.height);
		g.fillRect(location.x+size.width - pipeWidth, location.y, pipeWidth, size.height);
		*/
		rect1.paint(g);
		rect2.paint(g);
	}

	@Override
	public boolean contains(Point p) {
		//RectangleCollisionBody rect1 = new RectangleCollisionBody(new Point(location.x, location.y), this.color, new DimensionUIResource(pipeWidth, size.height));
		//RectangleCollisionBody rect2 = new RectangleCollisionBody(new Point(location.x+size.width - pipeWidth, location.y), this.color, new DimensionUIResource(pipeWidth, size.height));
		return rect1.contains(p)||rect2.contains(p);
	}

	@Override
	public VerticalPipe getNewInstance() {
		// TODO Auto-generated method stub
		return new VerticalPipe();
	}
	
	@Override
	public void rotate() {
		this.mode = (this.mode + 1) % 2;
	}	
}
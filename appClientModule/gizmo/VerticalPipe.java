package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.plaf.DimensionUIResource;

public class VerticalPipe extends AbstractShape implements ICollisionBody {

	private int pipeWidth;
	
	public VerticalPipe() {
		this.size = new Dimension(50, 50);
		this.name = "VerticalPipe";
		this.color = new Color(248, 206, 204);
		this.pipeWidth = 10;
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
		RectangleCollisionBody rect1 = new RectangleCollisionBody(new Point(location.x, location.y), this.color, new Dimension(pipeWidth, size.height));
		RectangleCollisionBody rect2 = new RectangleCollisionBody(new Point(location.x+size.width - pipeWidth, location.y), this.color, new Dimension(pipeWidth, size.height));
		if (rect1.isCollisionInVerticalPipe(ball) || rect2.isCollisionInVerticalPipe(ball)) 
			return true;
		return false;
	}
	
	@Override
	public void changeDirect(Ball ball) {
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(location.x, location.y, pipeWidth, size.height);
		g.fillRect(location.x+size.width - pipeWidth, location.y, pipeWidth, size.height);
	}

	@Override
	public boolean contains(Point p) {
		RectangleCollisionBody rect1 = new RectangleCollisionBody(new Point(location.x, location.y), this.color, new Dimension(pipeWidth, size.height));
		RectangleCollisionBody rect2 = new RectangleCollisionBody(new Point(location.x+size.width - pipeWidth, location.y), this.color, new Dimension(pipeWidth, size.height));
		return rect1.contains(p)||rect2.contains(p);
	}

	@Override
	public VerticalPipe getNewInstance() {
		// TODO Auto-generated method stub
		return new VerticalPipe();
	}
	
	
		
}
package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class CircleCollisionBody extends AbstractShape implements ICollisionBody{
	
	public CircleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "circle";
		this.color = new Color(128, 255, 0);
	}
	
	public CircleCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "circle";
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x - this.size.width / 2, location.y - this.size.height / 2, this.size.width, this.size.height);
	}

	@Override
	public boolean isCollision(Ball ball) {
		return false;

	}

	@Override
	public void changeDirect(Ball ball) {

	}

	@Override
	public boolean contains(Point p) {
		if(new Rectangle(location.x - this.size.width / 2, location.y - this.size.height / 2, 
				size.width, size.height).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CircleCollisionBody getNewInstance() {
		return new CircleCollisionBody();
	}	
}

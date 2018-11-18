package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class CircleCollisionBody extends AbstractShape implements ICollisionBody{
	// 圆心位置
	Point location;

	// 大小
	Dimension size;

	// 颜色
	Color color;
	
	public CircleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "circle";
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
		g.fillOval(location.x, location.y, 50, 50);
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
		return false;

	}

	@Override
	public void setPosition(Point p) {
		this.location = p;
	}

	@Override
	public Point getPosition() {
		return this.location;
	}

	@Override
	public void changeSize(int step) {
		this.size.width += step;
		this.size.height += step;
	}	
}

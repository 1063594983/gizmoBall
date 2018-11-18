package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class TriangleCollisionBody extends AbstractShape implements ICollisionBody {
	
	//位置（直角点坐标）
	private Point location;
	
	//两条直角边长
	private Dimension size; 
	
	//颜色
	private Color color;
	
	public TriangleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "triangle";
		this.location = new Point(100, 100);
		this.color = Color.RED;
	}
	
	public TriangleCollisionBody(Point location, Color color) {
		this.size = new Dimension(50, 50);
		this.name = "triangle";
		this.location = location;
		this.color = color;
	}

	@Override
	public boolean isCollision(Ball ball) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changeDirect(Ball ball) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		int[] arr1 = new int[3];
		int[] arr2 = new int[3];
		
		arr1[0] = this.location.x;
		arr1[1] = arr1[0];
		arr1[2] = arr1[0] + this.size.width;
		arr2[0] = this.location.y;
		arr2[1] = arr2[0] + this.size.height;
		arr2[2] = arr2[0];

		
		/*
		arr1[0] = 100;
		arr1[1] = arr1[0] + 50;
		arr1[2] = arr1[0] + 50;
		arr2[0] = 180;
		arr2[1] = arr2[0] + 50;
		arr2[2] = arr2[0] + 50;
		*/
		g.setColor(this.color);
		System.out.println(location.y);
		//g.drawPolygon(arr1, arr2, 3);
		g.fillPolygon(arr1, arr2, 3);
		//g.fillOval(location.x, location.y, 10, 10);
		//g.fillRect(100, 100, 50, 50);
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
	public boolean contains(Point p) {
		int[] arr1 = new int[3];
		int[] arr2 = new int[3];
		
		arr1[0] = this.location.x;
		arr1[1] = arr1[0];
		arr1[2] = arr1[0] + this.size.width;
		arr2[0] = this.location.y;
		arr2[1] = arr2[0] + this.size.height;
		arr2[2] = arr2[0];
		if(new Polygon(arr1, arr2, 3).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void changeSize(int step) {
		this.size.width += step;
		this.size.height += step;
	}

}

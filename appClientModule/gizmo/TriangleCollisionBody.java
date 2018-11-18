package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class TriangleCollisionBody extends AbstractShape implements ICollisionBody {
	
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
		g.setColor(this.color);
		g.fillPolygon(arr1, arr2, 3);
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
	public TriangleCollisionBody getNewInstance() {
		return new TriangleCollisionBody();
	}

}

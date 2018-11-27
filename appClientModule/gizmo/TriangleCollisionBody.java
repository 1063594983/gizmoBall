package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class TriangleCollisionBody extends AbstractShape implements ICollisionBody {
	
	int count = 5;
	
	int[][] arr = {{1, 0, 0, 1}, {0, -1, 1, 0}, {-1, 0, 0, -1}, {0, 1, -1, 0}};
	int[][] tmpArr = {{1, -1, -1, 1, -1, -1}, {-1, 1, 1, -1, 1, 1}, {1, -1, -1, 1, -1, -1}, {-1, 1, 1, -1, 1, 1}};
	
	public TriangleCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "triangle";
		this.location = new Point(100, 100);
		this.color = new Color(204, 204, 0);
		this.mode = 0;
		arr1 = new int[3];
		arr2 = new int[3];	
	}
	
	public TriangleCollisionBody(Point location, Color color) {
		this.size = new Dimension(50, 50);
		this.name = "triangle";
		this.location = location; 
		this.color = color;
	}

	public boolean isCollision(Ball ball) {
		
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;
		
		Line top = new Line(new Point(arr1[0], arr2[0]), new Point(arr1[1], arr2[1]));
		Line left = new Line(new Point(arr1[0], arr2[0]), new Point(arr1[2], arr2[2]));
		Line hypotenuse = new Line(new Point(arr1[1], arr2[1]), new Point(arr1[2], arr2[2]));
		Line ballLine = new Line(new Point(X, Y), new Point(X + vx, Y + vy));
		
		if(top.isIntersect(ballLine)) {
			ball.location.x = top.getIntersectPoint(ballLine).x;
			ball.location.y = top.getIntersectPoint(ballLine).y - ball.radius;
			ball.velocity.x *= tmpArr[mode][0];
			ball.velocity.y *= tmpArr[mode][1];
			return true;
		} else if(left.isIntersect(ballLine)) {
			ball.location.y = left.getIntersectPoint(ballLine).y;
			ball.location.x = left.getIntersectPoint(ballLine).x - ball.radius;

			ball.velocity.x *= tmpArr[mode][2];
			ball.velocity.y *= tmpArr[mode][3];
			return true;
		} else if(hypotenuse.isIntersect(ballLine)) {
			ball.location.y = hypotenuse.getIntersectPoint(ballLine).y;
			ball.location.x = hypotenuse.getIntersectPoint(ballLine).x;
			ball.velocity.x = tmpArr[mode][4] * vy;
			ball.velocity.y = tmpArr[mode][5] * vx;	
			return true;
		}
		
		return false;
	}

	@Override
	public void paint(Graphics g) {	
		arr1[0] = this.location.x;
		arr2[0] = this.location.y;
		arr1[1] = arr1[0] + this.size.width * arr[mode][0];
		arr1[2] = arr1[0] + this.size.width * arr[mode][1];
		arr2[1] = arr2[0] + this.size.height * arr[mode][2];
		arr2[2] = arr2[0] + this.size.height * arr[mode][3];
		g.setColor(this.color);
		g.fillPolygon(arr1, arr2, 3);
	}

	@Override
	public boolean contains(Point p) {	
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
	
	@Override
	public void rotate() {
		this.mode = (this.mode + 1) % 4;
	}
}

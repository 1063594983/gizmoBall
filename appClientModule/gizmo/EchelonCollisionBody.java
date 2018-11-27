package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class EchelonCollisionBody extends AbstractShape implements ICollisionBody {

	int[] arr1;

	int[] arr2;
	
	int[][] tmpArr = {{1, -1, 1, -1, -1, -1, 1, 1}, {-1, 1, -1, 1, 1, 1, -1, -1}, {1, -1, 1, -1, -1, -1, 1, 1}, 
			{-1, 1, -1, 1, 1, 1, -1, -1}};

	public EchelonCollisionBody() {
		this.size = new Dimension(40, 40);
		this.name = "echelon";
		this.color = new Color(102, 178, 255);
		this.mode = 0;
		this.location = new Point(100, 100);
		arr1 = new int[4];
		arr2 = new int[4];
	}

	public EchelonCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(40, 40);
		this.color = color;
		this.name = "echelon";
	}

	@Override
	public void paint(Graphics g) {
		if(mode == 0) {
			arr1[0] = location.x - size.width / 2; 
			arr1[1] = location.x + size.width / 2; 
			arr1[2] = location.x + size.width / 2 + size.height;
			arr1[3] = location.x - size.width / 2 - size.height; 
			arr2[0] = location.y - size.height / 2; 
			arr2[1] = location.y - size.height / 2; 
			arr2[2] = location.y + size.height / 2; 
			arr2[3] = location.y + size.height / 2;
		} else if(mode == 1) {
			arr1[0] = location.x + size.height / 2; 
			arr1[1] = location.x + size.height / 2; 
			arr1[2] = location.x - size.height / 2;
			arr1[3] = location.x - size.height / 2; 
			arr2[0] = location.y - size.width / 2; 
			arr2[1] = location.y + size.width / 2;
			arr2[2] = location.y + size.height + size.width / 2;
			arr2[3] = location.y - size.height - size.width / 2;
		} else if(mode == 2) {
			arr1[0] = location.x + size.width / 2; 
			arr1[1] = location.x - size.width / 2; 
			arr1[2] = location.x - size.height - size.width / 2;
			arr1[3] = location.x + size.height + size.width / 2;
			arr2[0] = location.y + size.height / 2; 
			arr2[1] = location.y + size.height / 2; 
			arr2[2] = location.y - size.height / 2; 
			arr2[3] = location.y - size.height / 2;
		} else if(mode == 3) {
			arr1[0] = location.x - size.height / 2; 
			arr1[1] = location.x - size.height / 2; 
			arr1[2] = location.x + size.height / 2;
			arr1[3] = location.x + size.height / 2; 
			arr2[0] = location.y + size.width / 2; 
			arr2[1] = location.y - size.width / 2; 
			arr2[2] = location.y - size.width / 2 - size.height; 
			arr2[3] = location.y + size.height + size.width / 2;
		}
		g.setColor(this.color);
		g.fillPolygon(arr1, arr2, 4);
	}

	@Override
	public boolean isCollision(Ball ball) {
		int X = ball.location.x;
		int Y = ball.location.y;
		int vx = ball.velocity.x;
		int vy = ball.velocity.y;

		Line top = new Line(new Point(arr1[0], arr2[0]), new Point(arr1[1], arr2[1]));
		Line buttom = new Line(new Point(arr1[2], arr2[2]), new Point(arr1[3], arr2[3]));
		Line rightHypotenuse = new Line(new Point(arr1[1], arr2[1]), new Point(arr1[2], arr2[2]));
		Line leftHypotenuse = new Line(new Point(arr1[3], arr2[3]), new Point(arr1[0], arr2[0]));
		Line ballLine = new Line(new Point(X, Y), new Point(X + vx, Y + vy));

		if (top.isIntersect(ballLine)) {
			ball.location.x = top.getIntersectPoint(ballLine).x;
			ball.location.y = top.getIntersectPoint(ballLine).y - ball.radius;
			
			ball.velocity.x *= tmpArr[mode][0];
			ball.velocity.y *= tmpArr[mode][1];
			return true;
		} else if (buttom.isIntersect(ballLine)) {
			ball.location.x = buttom.getIntersectPoint(ballLine).x;
			ball.location.y = buttom.getIntersectPoint(ballLine).y + ball.radius;

			ball.velocity.x *= tmpArr[mode][2];
			ball.velocity.y *= tmpArr[mode][3];
			return true;
		} else if (leftHypotenuse.isIntersect(ballLine)) {
			ball.location.y = leftHypotenuse.getIntersectPoint(ballLine).y - ball.radius;
			ball.location.x = leftHypotenuse.getIntersectPoint(ballLine).x - ball.radius;
			
			ball.velocity.x = vy * tmpArr[mode][4];
			ball.velocity.y = vx * tmpArr[mode][5];

			return true;
		} else if (rightHypotenuse.isIntersect(ballLine)) {
			ball.location.y = rightHypotenuse.getIntersectPoint(ballLine).y - ball.radius;
			ball.location.x = rightHypotenuse.getIntersectPoint(ballLine).x + ball.radius;
			ball.velocity.x = vy * tmpArr[mode][6];
			ball.velocity.y = vx * tmpArr[mode][7];

			return true;
		}

		return false;
	}

	@Override
	public boolean contains(Point p) {
		/*
		int[] arr1 = { location.x - size.width / 2, location.x + size.width / 2, location.x + size.width * 3 / 2,
				location.x - size.width * 3 / 2 };
		int[] arr2 = { location.y - size.height / 2, location.y - size.height / 2, location.y + size.height / 2,
				location.y + size.height / 2 };
		*/
		if (new Polygon(arr1, arr2, 4).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EchelonCollisionBody getNewInstance() {
		// TODO Auto-generated method stub
		return new EchelonCollisionBody();
	}

	@Override
	public void rotate() {
		/*
		for (int i = 0; i < 4; i++) {
			int tmpX = arr1[i];
			int tmpY = arr2[i];
			arr1[i] = location.x + (location.y - tmpY);
			arr2[i] = location.y + (tmpX - location.x);
		}
		*/
		this.mode = (this.mode + 1) % 4;
	}
}

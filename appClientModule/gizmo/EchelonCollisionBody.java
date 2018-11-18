package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class EchelonCollisionBody extends AbstractShape implements ICollisionBody {
	
	public EchelonCollisionBody() {
		this.size = new Dimension(40, 40);
		this.name = "echelon";
		this.color = new Color(102, 178, 255);
	}
	
	public EchelonCollisionBody(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(40, 40);
		this.color = color;
		this.name = "echelon";
	}

	@Override
	public void paint(Graphics g) {
		int[] arr1 = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] arr2 = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
 		g.setColor(this.color);
		g.fillPolygon(arr1, arr2, 4);
	}

	@Override
	public boolean isCollision(Ball ball) {
		if(new Rectangle(location.x - ball.radius, location.y - ball.radius, size.width + 2 * ball.radius, size.height + 2 * ball.radius).contains(ball.location)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void changeDirect(Ball ball) {
		if(Math.abs(ball.location.x - location.x) <= ball.radius || Math.abs(ball.location.x - location.x - size.width) <= ball.radius) {
			ball.velocity.y *= -1;
		}
		if(Math.abs(ball.location.y - location.y) <= ball.radius || Math.abs(ball.location.y - location.y - size.height) <= ball.radius) {
			ball.velocity.x *= -1;
		}
	}

	@Override
	public boolean contains(Point p) {
		int[] arr1 = {location.x - size.width / 2, location.x + size.width / 2, 
				location.x + size.width * 3 / 2, location.x - size.width * 3 / 2};
		int[] arr2 = {location.y - size.height / 2, location.y - size.height / 2,
				location.y + size.height / 2, location.y + size.height / 2};
		if(new Polygon(arr1, arr2, 4).contains(p)) {
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
}

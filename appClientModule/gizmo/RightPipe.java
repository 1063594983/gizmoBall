package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.plaf.DimensionUIResource;

public class RightPipe extends AbstractShape implements ICollisionBody {

	private int pipeWidth;
	
	public RightPipe() {
		this.size = new Dimension(50, 50);
		this.name = "VerticalPipe";
		this.color = new Color(248, 206, 204);
		this.pipeWidth = 10;
	}
	
	public RightPipe(Point location, Color color) {
		this.location = location;
		this.size = new Dimension(50, 50);
		this.color = color;
		this.name = "VerticalPipe";
		this.pipeWidth = 10;
	}
	
	@Override
	public boolean isCollision(Ball ball) {
		RectangleCollisionBody rect1 = new RectangleCollisionBody(new Point(location.x, location.y), this.color, new Dimension(pipeWidth, size.height));
		RectangleCollisionBody rect2 = new RectangleCollisionBody(new Point(location.x + pipeWidth, location.y+size.height-pipeWidth), this.color, new Dimension(size.width-pipeWidth, pipeWidth));
		if (rect1.isCollisionInRightPipe(ball) || rect2.isCollisionInRightPipe(ball)) {
//			if(ball.velocity.y > 0) {
//				ball.velocity.y++;
//			} else if(ball.velocity.y < 0) {
//				ball.velocity.y--;
//			}
//			
//			if(ball.velocity.x > 0) {
//				ball.velocity.x++;
//			} else if(ball.velocity.x < 0) {
//				ball.velocity.x--;
//			}
			return true;
		}
		return false;
	}

	@Override
	public void changeDirect(Ball ball) {
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(location.x, location.y, pipeWidth, size.height);
		g.fillRect(location.x + pipeWidth, location.y+size.height-pipeWidth, size.width-pipeWidth, pipeWidth);
	}

	@Override
	public boolean contains(Point p) {
		RectangleCollisionBody rect1 = new RectangleCollisionBody(new Point(location.x, location.y), this.color, new Dimension(pipeWidth, size.height));
		RectangleCollisionBody rect2 = new RectangleCollisionBody(new Point(location.x + pipeWidth, location.y+size.height-pipeWidth), this.color, new Dimension(size.width-pipeWidth, pipeWidth));
		return rect1.contains(p)||rect2.contains(p);
	}

	@Override
	public RightPipe getNewInstance() {
		// TODO Auto-generated method stub
		return new RightPipe();
	}
	
	
		
}
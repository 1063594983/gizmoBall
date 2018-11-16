package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ball extends AbstractBall {
	
	//位置
	public Point location;
	
	//半径
	public int radius;
	
	//速度
	public Point velocity; 
	
	//颜色
	public Color color;

	@Override
	public void move() {
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x, location.y, 2 * radius, 2 * radius);
	}

}

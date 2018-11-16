package gizmo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ball extends AbstractBall {
	
	//λ��
	public Point location;
	
	//�뾶
	public int radius;
	
	//�ٶ�
	public Point velocity; 
	
	//��ɫ
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

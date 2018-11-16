package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class RectangleCollisionBody extends AbstractShape implements ICollisionBody {
	// λ��
	Point location;

	// ��С
	Dimension size;

	// ��ɫ
	Color color;

	@Override
	protected void paint(Graphics g) {
		g.setColor(this.color);
		g.fillRect(location.x, location.y, size.width, size.height);
	}

	@Override
	public boolean isCollision(AbstractBall ball) {
		return false;
	}

	@Override
	public void changeDirect(AbstractBall ball) {

	}

	@Override
	protected boolean contains(Point p) {
		return false;
	}
}

package gizmo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	//绘制图形
	public abstract void paint(Graphics g);
	public abstract void setPosition(Point p);
	public abstract Point getPosition();
	//判断一个点是否在图形内
	public abstract boolean contains(Point p);
	
}

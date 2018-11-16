package gizmo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	//绘制图形
	protected abstract void paint(Graphics g);
	
	//判断一个点是否在图形内
	protected abstract boolean contains(Point p);
}

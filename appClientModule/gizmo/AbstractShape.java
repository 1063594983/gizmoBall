package gizmo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	public String name;
	//绘制图形
	public abstract void paint(Graphics g);
	//设置位置
	public abstract void setPosition(Point p);
	//获取位置
	public abstract Point getPosition();
	//判断一个点是否在图形内
	public abstract boolean contains(Point p);
	//改变大小
	public abstract void changeSize(int step);
	
}

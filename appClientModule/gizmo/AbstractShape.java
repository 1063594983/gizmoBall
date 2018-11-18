package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	public String name;
	
	//颜色
	protected Color color;
	
	//大小
	protected Dimension size;
	
	//位置
	protected Point location;
	
	//绘制图形
	public abstract void paint(Graphics g);
	
	//设置位置
	public void setPosition(Point p) {
		this.location = p;
	}
	
	//获取位置
	public Point getPosition() {
		return this.location;
	}
	
	//判断一个点是否在图形内
	public abstract boolean contains(Point p);
	
	//改变大小
	public void beBigger(int step) {
		this.size.width += step;
		this.size.height += step;
	}
	
	public void beSmaller(int step) {
		this.size.width -= step;
		this.size.height -= step;
	}
	
	//获取实例
	public abstract <T extends AbstractShape> T getNewInstance();
	
	//设置颜色
	public void setColor(Color color) {
		this.color = color;
	}
	
}

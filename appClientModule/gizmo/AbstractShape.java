package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	public String name;
	
	public int mode;
	
	public int[] arr1;
	
	public int[] arr2;
	
	//颜色
	protected Color color;
	
	//大小
	protected Dimension size;
	
	//位置
	protected Point location;
	
	public AbstractShape() {
		
	}
	
	public AbstractShape(Point location, Dimension size) {
		this.location = location;
		this.size = size;
	}
	
	//绘制图形
	public abstract void paint(Graphics g);
	
	//顺时针旋转90度
	public void rotate() {
		this.mode = (this.mode + 1) % 4;
	}
	
	//设置位置
	public void setPosition(Point p) {
		this.location = p;
	}
	//设置大小
	public void setSize(Dimension size) {
		this.size = size;
	}
	
	//获取位置
	public Point getPosition() {
		return this.location;
	}
	
	//判断一个点是否在图形内
	public abstract boolean contains(Point p);
	
	//获取实例
	public abstract <T extends AbstractShape> T getNewInstance();
	
	//设置颜色
	public void setColor(Color color) {
		this.color = color;
	}
	
	//获取字符串
	public String getString() {
		String str = this.name + " " + this.location.x + " " + this.location.y + " " + this.size.width + " " + this.size.height + "\n";
		return str;
	}
	
	public Dimension getSize() {
		return this.size;
	}
	
}

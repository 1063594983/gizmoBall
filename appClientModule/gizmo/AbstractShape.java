package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	public String name;
	
	protected int[] x = new int[10];
	protected int[] y = new int[10];
	
	//��ɫ
	protected Color color;
	
	//��С
	protected Dimension size;
	
	//λ��
	protected Point location;
	
	//��ת
	protected int rotateCount;
	
	public AbstractShape() {
		
	}
	
	public AbstractShape(Point location, Dimension size) {
		this.location = location;
		this.size = size;
		this.rotateCount = 0;
	}
	
	//����ͼ��
	public abstract void paint(Graphics g);
	
	//����λ��
	public void setPosition(Point p) {
		this.location = p;
	}
	//���ô�С
	public void setSize(Dimension size) {
		this.size = size;
	}
	
	//��ȡλ��
	public Point getPosition() {
		return this.location;
	}
	
	//�ж�һ�����Ƿ���ͼ����
	public abstract boolean contains(Point p);
	
	//�ı��С
	public void beBigger(int step) {
		this.size.width += step;
		this.size.height += step;
	}
	
	public void beSmaller(int step) {
		this.size.width -= step;
		this.size.height -= step;
	}
	
	//��ȡʵ��
	public abstract <T extends AbstractShape> T getNewInstance();
	
	//������ɫ
	public void setColor(Color color) {
		this.color = color;
	}
	
	//��ȡ�ַ���
	public String getString() {
		String str = this.name + " " + this.location.x + " " + this.location.y + " " + this.size.width + " " + this.size.height + "\n";
		return str;
	}
	
	public Dimension getSize() {
		return this.size;
	}
	
	//��ת
	public void rotate() {
		
	}
	
}

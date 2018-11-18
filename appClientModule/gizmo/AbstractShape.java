package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	public String name;
	
	//��ɫ
	protected Color color;
	
	//��С
	protected Dimension size;
	
	//λ��
	protected Point location;
	
	//����ͼ��
	public abstract void paint(Graphics g);
	
	//����λ��
	public void setPosition(Point p) {
		this.location = p;
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
	
}

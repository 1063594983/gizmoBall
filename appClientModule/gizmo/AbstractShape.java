package gizmo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	public String name;
	//����ͼ��
	public abstract void paint(Graphics g);
	//����λ��
	public abstract void setPosition(Point p);
	//��ȡλ��
	public abstract Point getPosition();
	//�ж�һ�����Ƿ���ͼ����
	public abstract boolean contains(Point p);
	//�ı��С
	public abstract void changeSize(int step);
	
}

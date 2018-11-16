package gizmo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	//����ͼ��
	public abstract void paint(Graphics g);
	public abstract void setPosition(Point p);
	public abstract Point getPosition();
	//�ж�һ�����Ƿ���ͼ����
	public abstract boolean contains(Point p);
	
}

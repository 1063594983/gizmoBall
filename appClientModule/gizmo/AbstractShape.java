package gizmo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {
	//����ͼ��
	protected abstract void paint(Graphics g);
	
	//�ж�һ�����Ƿ���ͼ����
	protected abstract boolean contains(Point p);
}

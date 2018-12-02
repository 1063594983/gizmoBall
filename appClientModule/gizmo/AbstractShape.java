package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractShape {

	// �������
	public String name;

	// �������ʽ
	public int mode = 0;

	// ����ͼ�εĵ�����
	public int[] arr1;
	public int[] arr2;

	// ��ɫ
	protected Color color;

	// ��С
	protected Dimension size;

	// λ��
	protected Point location;

	// ��ת
	protected int rotateCount;

	public AbstractShape() {

	}

	/*
	 * public AbstractShape(Point location, Dimension size) { this.location =
	 * location; this.size = size; this.rotateCount = 0; }
	 */

	// ����ͼ��
	public abstract void paint(Graphics g);

	// ˳ʱ����ת90��
	public abstract void rotate();

	// ����λ��
	public void setPosition(Point p) {
		this.location = p;
	}

	// ���ô�С
	public void setSize(Dimension size) {
		this.size = size;
	}

	// ������ɫ
	public void setColor(Color color) {
		this.color = color;
	}

	// ��ȡλ��
	public Point getPosition() {
		return this.location;
	}

	// �ж�һ�����Ƿ���ͼ����
	public abstract boolean contains(Point p);

	// ��ȡʵ��
	public abstract <T extends AbstractShape> T getNewInstance();

	// ��ȡ�ַ���
	public String getString() {
		String str = this.name + " " + this.location.x + " " + this.location.y + " " + this.size.width + " "
				+ this.size.height + " " + this.mode + "\n";
		return str;
	}

	public Dimension getSize() {
		return this.size;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

}

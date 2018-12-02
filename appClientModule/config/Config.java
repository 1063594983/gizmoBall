package config;

import java.awt.Dimension;
import java.awt.Point;

public class Config {
	//����
	public static final int FPS = 60;
	
	//����
	public static final Dimension WINSIZE = new Dimension(900, 900);
	public static final Point WINLOCATION = new Point(100, 100);
	
	//С��
	public static final Point BALLLOCATION = new Point(100, 100);
	public static final int BALLRADIUS = 8;
	public static final Point BALLVELOCITY = new Point(10, 10);
	public static final int GRAVITY = 3;	//��������(>=1)��ԽС����Խ����
	
	//����
	public static final Dimension RECTSIZE = new Dimension(50, 50);
	public static final int RECFRICTION = 5;	//����Ħ������(>=1)��ԽСĦ��Խ����
	
	//����
	public static final Dimension TRISIZE = new Dimension(50, 50);
	public static final int TRIFRICTION = 5;	//������Ħ������(>=1)��ԽСĦ��Խ����
	
	//����
	public static final Dimension ECHESIZE = new Dimension(50, 50);
	public static final int ECHEFRICTION = 5;	//����Ħ������(>=1)��ԽСĦ��Խ����
	
	//Բ��
	public static final Dimension CIRSIZE = new Dimension(50, 50);
	public static final int CIRFRICTION = 5;	//Բ��Ħ������(>=1)��ԽСĦ��Խ����
	
	//����
	public static final int BAFFLEWIDTH = 10;
	
	//ֱ�ǹܵ�
	public static final Dimension RIGHTSIZE = new Dimension(50, 50);
	
	//ֱ�߹ܵ�
	public static final Dimension VERSIZE = new Dimension(50, 50);
	
	//�ܵ�
	public static final int PIPEWIDTH = 10;
	public static final int PIPEFRICTION = 10;	//�ܵ�Ħ������(>=1)��ԽСĦ��Խ����
}

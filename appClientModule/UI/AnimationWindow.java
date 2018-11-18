package UI;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import javax.swing.Timer;


import gizmo.*;
import eventListener.*;

public class AnimationWindow extends JComponent {
	
	//����������״
	private ArrayList<AbstractShape> shapes;
	
	//С��
	private Ball ball;
	
	private int FPS = 100;
	
	//��ʱ��
	private Timer timer;
	
	//������
	AnimationEventListener eventListener;
	
	//����
	private static AnimationWindow animationWindow = new AnimationWindow();
	
	//��õ���
	public static AnimationWindow getInstance() {
		return AnimationWindow.animationWindow;
	}
	
	private AnimationWindow() {
		shapes = new ArrayList<>();
		ball = new Ball(this);
		eventListener = new AnimationEventListener(this);
		//��ӵ��
		this.addMouseListener(eventListener);
		//�����ק
		this.addMouseMotionListener(eventListener);
		timer = new Timer(1000 / FPS, eventListener);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		for(int i = 0; i < shapes.size(); i++) {
			this.shapes.get(i).paint(g);
		}
		ball.paint(g);
		ball.move();
	}
	
	//update����
	public void update() {
		for(int i = 0; i < shapes.size(); i++) {
			((ICollisionBody) this.shapes.get(i)).handleCollision(ball);
		}
		repaint();
	}


	
	//��������뻭��
	public void addShape(AbstractShape shape) {
		this.shapes.add(shape);
	}
	
	public ArrayList <AbstractShape> getShapes() {
		return this.shapes;
	}

}

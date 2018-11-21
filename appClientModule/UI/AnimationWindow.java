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
	
	private int FPS = 60;
	
	//��ʱ��
	private Timer timer;
	private Timer timer2;
	//ģʽ
	private boolean mode;
	//������
	AnimationEventListener eventListener;
	ItemEventListener itemEventListener;
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
		itemEventListener = new ItemEventListener(this);
		//��ӵ��
		this.addMouseListener(itemEventListener);
		//�����ק
		this.addMouseMotionListener(itemEventListener);
		timer = new Timer(1000 / FPS, eventListener);
		timer2 = new Timer(1000 / FPS, itemEventListener);
		timer2.start();
	}
	
	public void setMode(boolean mode) {
		if(this.mode == mode) {
			return ;
		}
		this.mode = mode;
		if(this.mode == true) {
			//��ӵ��
			this.addMouseListener(eventListener);
			//requestFocus();
			this.removeMouseListener(itemEventListener);
			this.removeMouseMotionListener(itemEventListener);
			timer.start();
			timer2.stop();
		} else {
			
			this.removeMouseListener(eventListener);
			//��ӵ��
			this.addMouseListener(itemEventListener);
			//�����ק
			this.addMouseMotionListener(itemEventListener);
			
			timer.stop();
			timer2.start();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		for(int i = 0; i < shapes.size(); i++) {
			this.shapes.get(i).paint(g);
		}
		ball.paint(g);
		//ball.move();
	}
	
	//update����
	public void update() {
		ball.move();
		for(int i = 0; i < shapes.size(); i++) {
			 ((ICollisionBody) this.shapes.get(i)).handleCollision(ball);
				//break;
		}
		repaint();
	}
	
	//����
	public void update2() {
		repaint();
	}


	
	//��������뻭��
	public void addShape(AbstractShape shape) {
		this.shapes.add(shape);
	}
	
	public ArrayList <AbstractShape> getShapes() {
		return this.shapes;
	}
	
	public void setShapes(ArrayList<AbstractShape> shapes) {
		this.shapes = shapes;
	}

}

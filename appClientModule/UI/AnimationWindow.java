package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JPanel;

import javax.swing.Timer;


import gizmo.*;
import javafx.scene.input.KeyCode;
import eventListener.*;

public class AnimationWindow extends JComponent {
	
	//����������״
	private ArrayList<AbstractShape> shapes;
	
	//С��
	public Ball ball;
	
	//����
	public Baffle baffle;
	
	private int FPS = 60;
	
	public int grade;
	
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
	
	//��õ���+
	public static AnimationWindow getInstance() {
		return AnimationWindow.animationWindow;
	}
	
	private AnimationWindow() {
		shapes = new ArrayList<>();
		ball = new Ball(this);
		baffle = new Baffle();
		
		grade = 0;
		
		eventListener = new AnimationEventListener(this);
		itemEventListener = new ItemEventListener(this);
		//��ӵ��
		this.addMouseListener(itemEventListener);
		//�����ק
		this.addMouseMotionListener(itemEventListener);
		//��Ӽ���
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == baffle.keyCode) {
					baffle.startRotate();
				}		
			}
			@Override
			public void keyReleased(KeyEvent e) {
				baffle.returnStand();
			}
		});
		
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
			//��Ӱ���
			//this.addKeyListener(eventListener);
			//requestFocus();
			this.removeMouseListener(itemEventListener);
			this.removeMouseMotionListener(itemEventListener);
			this.removeKeyListener(itemEventListener);
			timer.start();
			timer2.stop();
		} else {
			
			this.removeMouseListener(eventListener);
			//this.removeKeyListener(eventListener);
			//��ӵ��
			this.addMouseListener(itemEventListener);
			//�����ק
			this.addMouseMotionListener(itemEventListener);
			//��Ӽ���
			this.addKeyListener(itemEventListener);
			
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
		baffle.paint(g);
		g.setColor(Color.BLACK);
		g.drawString("��ǰ����Ϊ" + this.grade, this.getWidth() - 100, 20);
		//ball.move();
	}
	
	//update����
	public void update() {
		ball.move();
		for(int i = 0; i < shapes.size(); i++) {
			 ((ICollisionBody) this.shapes.get(i)).handleCollision(ball);
				//break;
		}
		baffle.isCollision(ball);
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
	
	//�������Ƴ�����
	public void removeShape(AbstractShape shape) {
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i) == shape) {
				shapes.remove(i);
				break;
			}
		}
	}
	
	//��תС��
	public void rotateShape(AbstractShape shape) {
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i) == shape) {
				System.out.println(shapes.get(i).mode);
				shapes.get(i).rotate();
				System.out.println(shapes.get(i).mode);
				break;
			}
		}
	}
	
	//����С��λ��
	public void setBallLocation(Point p) {
		this.ball.location = p;
	}
	
	public void setBallVelocity(Point v) {
		this.ball.velocity = v;
	}
	
	public ArrayList <AbstractShape> getShapes() {
		return this.shapes;
	}
	
	public void setShapes(ArrayList<AbstractShape> shapes) {
		this.shapes = shapes;
	}
	
<<<<<<< HEAD
	//���õ���λ��
	public void setBaffleLoaction(Point p) {
		this.baffle.setPosition(p);
=======
	public void reStart() {
		this.grade = 0;
		this.shapes.clear();
		this.ball.location = new Point(100, 100);
		this.ball.velocity = new Point(5, 10);
		this.setMode(false);
	}
	
	//��Ϸ����
	public void continueGame() {
		this.grade = 0;
		this.setMode(false);
>>>>>>> c6e2936f0ff54adc99e7f9cffbff3946ca97b8cc
	}

}

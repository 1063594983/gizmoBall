package UI;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import javax.swing.Timer;


import gizmo.*;
import eventListener.*;

public class AnimationWindow extends JComponent {
	
	//保存所有形状
	private ArrayList<AbstractShape> shapes;
	
	//小球
	private Ball ball;
	
	private int FPS = 60;
	
	//定时器
	private Timer timer;
	private Timer timer2;
	//模式
	private boolean mode;
	//监听器
	AnimationEventListener eventListener;
	ItemEventListener itemEventListener;
	//单例
	private static AnimationWindow animationWindow = new AnimationWindow();
	
	//获得单例
	public static AnimationWindow getInstance() {
		return AnimationWindow.animationWindow;
	}
	
	private AnimationWindow() {
		shapes = new ArrayList<>();
		ball = new Ball(this);
		eventListener = new AnimationEventListener(this);
		itemEventListener = new ItemEventListener(this);
		//添加点击
		this.addMouseListener(itemEventListener);
		//添加拖拽
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
			//添加点击
			this.addMouseListener(eventListener);
			//requestFocus();
			this.removeMouseListener(itemEventListener);
			this.removeMouseMotionListener(itemEventListener);
			timer.start();
			timer2.stop();
		} else {
			
			this.removeMouseListener(eventListener);
			//添加点击
			this.addMouseListener(itemEventListener);
			//添加拖拽
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
	
	//update函数
	public void update() {
		ball.move();
		for(int i = 0; i < shapes.size(); i++) {
			 ((ICollisionBody) this.shapes.get(i)).handleCollision(ball);
				//break;
		}
		repaint();
	}
	
	//绘制
	public void update2() {
		repaint();
	}


	
	//将物体加入画板
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

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
	
	private int FPS = 100;
	
	//定时器
	private Timer timer;
	
	//监听器
	AnimationEventListener eventListener;
	
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
		//添加点击
		this.addMouseListener(eventListener);
		//添加拖拽
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
	
	//update函数
	public void update() {
		for(int i = 0; i < shapes.size(); i++) {
			((ICollisionBody) this.shapes.get(i)).handleCollision(ball);
		}
		repaint();
	}


	
	//将物体加入画板
	public void addShape(AbstractShape shape) {
		this.shapes.add(shape);
	}
	
	public ArrayList <AbstractShape> getShapes() {
		return this.shapes;
	}

}

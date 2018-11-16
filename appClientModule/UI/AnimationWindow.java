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
	private AbstractBall ball;
	
	private int FPS = 60;
	
	//定时器
	private Timer timer;
	
	//监听器
	AnimationEventListener eventListener;
	
	public AnimationWindow() {
		shapes = new ArrayList<>();
		ball = new Ball(this);
		eventListener = new AnimationEventListener(this);
		this.addMouseListener(eventListener);
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
		repaint();
	}


	
	//将物体加入画板
	public void addShape(AbstractShape shape) {
		this.shapes.add(shape);
	}

}

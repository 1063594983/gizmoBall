package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.Timer;

import config.Config;
import gizmo.*;
import eventListener.*;

public class AnimationWindow extends JComponent {
	
	//保存所有形状
	private ArrayList<AbstractShape> shapes;
	
	//小球
	public Ball ball;
	
	//挡板
	public Baffle baffle;
	
	public int grade;
	
	//通知
	private String message = "";
	
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
		baffle = new Baffle();
		
		grade = 0;
		
		eventListener = new AnimationEventListener(this);
		itemEventListener = new ItemEventListener(this);
		//添加点击
		this.addMouseListener(itemEventListener);
		//添加拖拽
		this.addMouseMotionListener(itemEventListener);
		//添加键盘
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
		
		timer = new Timer(1000 / Config.FPS, eventListener);
		timer2 = new Timer(1000 / Config.FPS, itemEventListener);
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
		baffle.paint(g);
		
		g.setColor(Color.BLACK);
		g.drawString("当前分数为" + this.grade, this.getWidth() - 100, 20);
		if(this.message != "") {
			g.setColor(Color.RED);
			g.drawString(this.message, 50, 20);
		}
	}
	
	//update函数
	public void update() {
		ball.move();
		for(int i = 0; i < shapes.size(); i++) {
			 ((ICollisionBody) this.shapes.get(i)).handleCollision(ball);
		}
		baffle.isCollision(ball);
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
	
	//将物体移出画板
	public void removeShape(AbstractShape shape) {
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i) == shape) {
				shapes.remove(i);
				break;
			}
		}
	}
	
	//旋转物体
	/*
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
	*/
	
	//设置小球位置
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

	//设置挡板位置
	public void setBaffleLoaction(Point p) {
		this.baffle.setPosition(p);
	}
	
	public void reStart() {
		this.grade = 0;
		this.shapes.clear();
		this.ball.location = new Point(100, 100);
		this.ball.velocity = new Point(5, 10);
		this.setMode(false);
		this.baffle.setPosition(new Point(-100, -100));
	}
	
	//游戏结束
	public void continueGame() {
		this.grade = 0;
		this.setMode(false);
	}
	
	//根据点击位置返回组件
	public AbstractShape getShapeByLocation(Point p) {
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).contains(p)) {
				return shapes.get(i);
			}
		}
		return null;
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}

}

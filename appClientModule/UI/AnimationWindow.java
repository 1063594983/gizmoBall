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
	private AbstractBall ball;
	
	private int FPS = 60;
	
	//��ʱ��
	private Timer timer;
	
	//������
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
	
	//update����
	public void update() {
		repaint();
	}


	
	//��������뻭��
	public void addShape(AbstractShape shape) {
		this.shapes.add(shape);
	}

}

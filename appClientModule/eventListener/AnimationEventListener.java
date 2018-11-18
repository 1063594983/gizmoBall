package eventListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import UI.AnimationWindow;
import control.AddShape;
import control.MainControl;
import gizmo.AbstractShape;
import gizmo.RectangleCollisionBody;

public class AnimationEventListener extends MouseAdapter implements MouseMotionListener, ActionListener, KeyListener {
	
	AnimationWindow animationWindow;
	
	AbstractShape shape;
	
	Point oldPosition;
	
	public AnimationEventListener(AnimationWindow animationWindow) {
		this.animationWindow = animationWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.animationWindow.update();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("按下按钮");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("点击");
		//animationWindow
		/*
		AddShape.setAnimationWindow(animationWindow);
		if(AddShape.shape != null) {
			AddShape.shape.setPosition(new Point(e.getX(), e.getY()));
			AddShape.execute();
		}
		*/
		if(MainControl.getCommand() != null) {
			MainControl.getCommand().shape.setPosition(new Point(e.getX(), e.getY()));
			MainControl.action();
		}
		
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		ArrayList <AbstractShape> shapes = animationWindow.getShapes();
		//oldPosition = new Point(e.getX(), e.getY());
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).contains(new Point(e.getX(), e.getY()))) {
				this.shape = shapes.get(i);
				break;
			}
			if(i == shapes.size() - 1) {
				this.shape = null;
			}
		}
		oldPosition = new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//this.shape.setPosition(new Point(this.shape.getPosition().x + e.getX() - oldPosition.x, this.shape.getPosition().y + e.getY() - oldPosition.y));
		if(this.shape != null) {
			//this.shape.setPosition(new Point(e.getX(), e.getY()));
			Point p = this.shape.getPosition();
			this.shape.setPosition(new Point(p.x + (e.getX() - oldPosition.x), p.y + (e.getY() - oldPosition.y)));
		}
		oldPosition.x = e.getX();
		oldPosition.y = e.getY();
		
	}
	
	
}

package eventListener;

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
import control.MainControl;
import gizmo.AbstractShape;

public class ItemEventListener extends MouseAdapter implements MouseMotionListener, ActionListener, KeyListener {
	
	AnimationWindow animationWindow;
	
	AbstractShape shape;
	
	Point oldPosition;
	
	public ItemEventListener(AnimationWindow animationWindow) {
		this.animationWindow = animationWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		animationWindow.update2();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("°´ÏÂ°´Å¥");
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
		ArrayList <AbstractShape> shapes = animationWindow.getShapes();
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).contains(new Point(e.getX(), e.getY()))) {
				this.shape = shapes.get(i);
				break;
			}
			if(i == shapes.size() - 1) {
				this.shape = null;
			}
		}
		if(MainControl.getCommand() != null) {
			switch (MainControl.getCommand().name) {
			case "add" : {
				MainControl.getCommand().shape.setPosition(new Point(e.getX(), e.getY()));
				break;
			}
			case "delete" : {
				MainControl.getCommand().shape = this.shape;
				break;
			}
			case "addBall" : {
				AnimationWindow.getInstance().setBallLocation(new Point(e.getX(), e.getY()));
				break;
			}
//			case "drag" : {
//				this.shape.rotate();
//				break;
//			}
			default : {
				
			}
			}
			
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
		if(this.shape != null && MainControl.getCommand() != null) {
			//this.shape.setPosition(new Point(e.getX(), e.getY()));
			Point p = this.shape.getPosition();
			Dimension d = this.shape.getSize();
			switch (MainControl.getCommand().name) {
			case "size": {
				this.shape.setSize(new Dimension(d.width + (e.getX() - oldPosition.x), d.height + (e.getY() - oldPosition.y)));
				break;
			}
			case "drag" : {
				this.shape.setPosition(new Point(p.x + (e.getX() - oldPosition.x), p.y + (e.getY() - oldPosition.y)));
				break;
			}
			default : {
				
			}
			}
			
		}
		oldPosition.x = e.getX();
		oldPosition.y = e.getY();
		
	}
	
	
}

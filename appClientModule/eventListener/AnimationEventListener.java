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

import UI.AnimationWindow;
import control.AddShape;
import gizmo.RectangleCollisionBody;

public class AnimationEventListener extends MouseAdapter implements MouseMotionListener, ActionListener, KeyListener {
	
	AnimationWindow animationWindow;
	
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
		System.out.println("点击");
		//animationWindow
		AddShape.setAnimationWindow(animationWindow);
		if(AddShape.shape != null) {
			AddShape.shape.setPosition(new Point(e.getX(), e.getY()));
			AddShape.execute();
		}
	}
	
	
}

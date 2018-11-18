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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
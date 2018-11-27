package eventListener;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import UI.AnimationWindow;
import gizmo.AbstractShape;


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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
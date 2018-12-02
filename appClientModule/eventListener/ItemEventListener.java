package eventListener;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import UI.AnimationWindow;
import control.MainControl;
import gizmo.AbstractShape;

public class ItemEventListener extends MouseAdapter implements MouseMotionListener, ActionListener {
	
	//监听的窗口
	AnimationWindow animationWindow;
	
	//当前操作的组件
	AbstractShape shape;
	
	
	Point oldPosition;
	
	public ItemEventListener(AnimationWindow animationWindow) {
		this.animationWindow = animationWindow;
		oldPosition = new Point();
	}

	//绘制加入的组件
	@Override
	public void actionPerformed(ActionEvent e) {
		animationWindow.update2();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.oldPosition = new Point(e.getX(), e.getY());
		this.shape = animationWindow.getShapeByLocation(oldPosition);
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
			case "addBaffle": {
				AnimationWindow.getInstance().setBaffleLoaction(new Point(e.getX(), e.getY()));
				break;
			}
			case "rotate" : {
				MainControl.getCommand().shape = this.shape;
				break;
			}
			default : {
				
			}
			}
			
			MainControl.action();
		}	
	}
	
	public void mousePressed(MouseEvent e) {
		oldPosition = new Point(e.getX(), e.getY());
		if(this.animationWindow.baffle.contains(oldPosition)) {
			this.shape = this.animationWindow.baffle;
		} else {
			this.shape = this.animationWindow.getShapeByLocation(oldPosition);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.shape != null && MainControl.getCommand() != null) {
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

package eventListener;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import org.omg.Messaging.SyncScopeHelper;

import UI.ShapeBtn;
import control.AddShape;
import gizmo.AbstractShape;
import gizmo.RectangleCollisionBody;


public class BtnEventListener extends MouseAdapter {
	
	private ShapeBtn btn;
	
	public BtnEventListener(ShapeBtn btn) {
		this.btn = btn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//AbstractShape shape;
		String shapename = this.btn.getShapeName();
		AddShape.shapename = shapename;
		AbstractShape shape;
		switch(shapename) {
			case "sb": 
				shape = new RectangleCollisionBody(new Point(500, 500), Color.red);
			default: 
				shape = new RectangleCollisionBody(new Point(e.getX(), e.getY()), Color.red);
		}
		AddShape.setShape(shape);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

}

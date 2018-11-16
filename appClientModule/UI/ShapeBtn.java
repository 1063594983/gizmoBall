package UI;

import javax.swing.JButton;

import eventListener.BtnEventListener;
import gizmo.AbstractShape;

public class ShapeBtn extends JButton {
	protected BtnEventListener eventListener;

	protected AbstractShape shape;
	
	public ShapeBtn(String name) {
		setText(name);
		
		eventListener = new BtnEventListener(this);
		// µã»÷
		this.addMouseListener(eventListener);
		// ÍÏ×§
		//this.addMouseMotionListener(eventListener);
	}
	
	public AbstractShape getShape() {
		return this.shape;
	}
}

package UI;

import java.awt.Color;

import javax.swing.JButton;

import eventListener.BtnEventListener;
import gizmo.AbstractShape;

public class ShapeBtn extends JButton {
	protected BtnEventListener eventListener;
	private String name;
	protected AbstractShape shape;
	
	public ShapeBtn(String name, AbstractShape shape) {
		setText(name);
		this.name = name;
		eventListener = new BtnEventListener(this);
		// µã»÷
		this.addMouseListener(eventListener);
		this.setBackground(Color.WHITE);
		// ÍÏ×§
		//this.addMouseMotionListener(eventListener);
	}
	
	public AbstractShape getShape() {
		return this.shape;
	}
	
	public String getShapeName() {
		return this.name;
	}
}

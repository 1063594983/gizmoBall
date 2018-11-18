package UI;

import javax.swing.JButton;

import control.Command;
import eventListener.BtnEventListener;
import gizmo.AbstractShape;

public class ShapeBtn extends JButton {
	protected BtnEventListener eventListener;
	private String name;
	protected AbstractShape shape;
	public Command command;
	
	public ShapeBtn(String name,  AbstractShape shape, Command command) {
		setText(name);
		this.name = name;
		eventListener = new BtnEventListener(this);
		// µã»÷
		this.addMouseListener(eventListener);
		// ÍÏ×§
		//this.addMouseMotionListener(eventListener);
		this.command = command;
		this.shape = shape;
		this.command.shape = this.shape;
	}
	
	public AbstractShape getShape() {
		return this.shape;
	}
	
	public String getShapeName() {
		return this.name;
	}
}

package eventListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import UI.ShapeBtn;
import control.AddShape;


public class BtnEventListener extends MouseAdapter {
	
	private ShapeBtn btn;
	
	public BtnEventListener(ShapeBtn btn) {
		this.btn = btn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		AddShape.setShape(this.btn.getShape());
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

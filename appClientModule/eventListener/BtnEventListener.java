package eventListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import UI.ShapeBtn;
import control.MainControl;



public class BtnEventListener extends MouseAdapter {
	
	private ShapeBtn btn;
	
	public BtnEventListener(ShapeBtn btn) {
		this.btn = btn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MainControl.setCommand(this.btn.command);
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		MainControl.setCommand(this.btn.command);
	}

}

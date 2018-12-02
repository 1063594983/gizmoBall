package eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import UI.AnimationWindow;


//ִ�ж���
public class AnimationEventListener extends MouseAdapter implements ActionListener {
	
	//�ü����������Ĵ���
	AnimationWindow animationWindow;
	
	public AnimationEventListener(AnimationWindow animationWindow) {
		this.animationWindow = animationWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.animationWindow.update();
	}
}
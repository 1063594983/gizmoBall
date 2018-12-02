package eventListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import UI.AnimationWindow;


//执行动画
public class AnimationEventListener extends MouseAdapter implements ActionListener {
	
	//该监听器监听的窗口
	AnimationWindow animationWindow;
	
	public AnimationEventListener(AnimationWindow animationWindow) {
		this.animationWindow = animationWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.animationWindow.update();
	}
}
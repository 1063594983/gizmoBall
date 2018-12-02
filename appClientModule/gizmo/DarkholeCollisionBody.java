package gizmo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import UI.AnimationWindow;

public class DarkholeCollisionBody extends AbstractShape implements ICollisionBody{
	
	public DarkholeCollisionBody() {
		this.size = new Dimension(50, 50);
		this.name = "darkhole";
		this.color = new Color(0, 0, 0);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		g.fillOval(location.x - this.size.width / 2, location.y - this.size.height / 2, this.size.width, this.size.height);
	}

	@Override
	public boolean isCollision(Ball ball) {
		if (contains(ball.location)) {
			changeDirect(ball);
			return true;
		}
		return false;
	}

	public void changeDirect(Ball ball) {
		Object[] options = {"继续游戏", "重新开始", "退出游戏"};
		int res = JOptionPane.showOptionDialog(null, "GAME OVER, TRY AGAIN?", "GAME OVER",
				JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(res == 0){
			AnimationWindow.getInstance().continueGame();
		} else if(res == 1) {
			AnimationWindow.getInstance().reStart();
		} else {
			System.exit(0);
			return;
		}
	}

	@Override
	public boolean contains(Point p) {
		if(new Rectangle(location.x - this.size.width / 2, location.y - this.size.height / 2, 
				size.width, size.height).contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public DarkholeCollisionBody getNewInstance() {
		return new DarkholeCollisionBody();
	}
	
	public void rotate() {
		
	}

}

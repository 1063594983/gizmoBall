package gizmo;

import UI.AnimationWindow;

public interface ICollisionBody {
	//��ײ���
	public abstract boolean isCollision(Ball ball);
	
	//������ײ
	public default boolean handleCollision(Ball ball) {
		if(isCollision(ball)) {
			AnimationWindow.getInstance().grade++;
			return true;
		}
		return false;
	}
	
	//С��Ħ������
	public default void ballSlowX(Ball ball) {
		if(ball.velocity.x > 0) {
			ball.velocity.x--;
		} else if(ball.velocity.x < 0) {
			ball.velocity.x++;
		}
	}
	
	public default void ballSlowY(Ball ball) {
		if(ball.velocity.y > 0) {
			ball.velocity.y--;
		} else if(ball.velocity.y < 0) {
			ball.velocity.y++;
		}
	}
	
	public default void ballSlow(Ball ball) {
		ballSlowX(ball);
		ballSlowY(ball);
	}
}

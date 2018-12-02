package gizmo;

import UI.AnimationWindow;

public interface ICollisionBody {
	//Åö×²¼ì²â
	public abstract boolean isCollision(Ball ball);
	
	//´¦ÀíÅö×²
	public default boolean handleCollision(Ball ball) {
		if(isCollision(ball)) {
			AnimationWindow.getInstance().grade++;
			return true;
		}
		return false;
	}
	
	//Ð¡ÇòÄ¦²Á¼õËÙ
	public default void ballSlowX(Ball ball) {
		if(ball.velocity.x > 1) {
			ball.velocity.x--;
		} else if(ball.velocity.x < -1) {
			ball.velocity.x++;
		}
	}
	
	public default void ballSlowY(Ball ball) {
		if(ball.velocity.y > 1) {
			ball.velocity.y--;
		} else if(ball.velocity.y < -1) {
			ball.velocity.y++;
		}
	}
	
	public default void ballSlow(Ball ball) {
		ballSlowX(ball);
		ballSlowY(ball);
	}
}

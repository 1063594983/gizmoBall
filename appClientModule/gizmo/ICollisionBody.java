package gizmo;

import UI.AnimationWindow;

public interface ICollisionBody {
	//Åö×²¼ì²â
	public abstract boolean isCollision(Ball ball);
	
	//´¦ÀíÅö×²
	public default boolean handleCollision(Ball ball) {
		if(isCollision(ball)) {
			//changeDirect(ball);
			/*
			if(ball.velocity.y > 0) {
				ball.velocity.y--;
			} else if(ball.velocity.y < 0) {
				ball.velocity.y++;
			}
			
			if(ball.velocity.x > 0) {
				ball.velocity.x--;
			} else if(ball.velocity.x < 0) {
				ball.velocity.x++;
			}
			*/
			AnimationWindow.getInstance().grade++;
			return true;
		}
		return false;
	}
}

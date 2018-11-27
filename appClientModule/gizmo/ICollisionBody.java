package gizmo;

public interface ICollisionBody {
	//碰撞检测
	public abstract boolean isCollision(Ball ball);
	
	//碰撞后改变小球运动方向
	public abstract void changeDirect(Ball ball);
	
	//处理碰撞
	public default boolean handleCollision(Ball ball) {
		if(isCollision(ball)) {
			//changeDirect(ball);
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

			return true;
		}
		return false;
	}
}

package gizmo;

public interface ICollisionBody {
	//碰撞检测
	public abstract boolean isCollision(AbstractBall ball);
	
	//碰撞后改变小球运动方向
	public abstract void changeDirect(AbstractBall ball);
	
	//处理碰撞
	public default void handleCollision(AbstractBall ball) {
		if(isCollision(ball)) {
			changeDirect(ball);
		}
	}
}

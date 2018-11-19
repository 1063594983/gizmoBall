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
			return true;
		}
		return false;
	}
}

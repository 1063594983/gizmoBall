package gizmo;

public interface ICollisionBody {
	//��ײ���
	public abstract boolean isCollision(Ball ball);
	
	//��ײ��ı�С���˶�����
	public abstract void changeDirect(Ball ball);
	
	//������ײ
	public default boolean handleCollision(Ball ball) {
		if(isCollision(ball)) {
			//changeDirect(ball);
			if(ball.velocity.y > 0) ball.velocity.y --;
			else ball.velocity.y ++;
			if(ball.velocity.x > 0) ball.velocity.x --;
			else ball.velocity.x ++;
			return true;
		}
		return false;
	}
}

package gizmo;

public interface ICollisionBody {
	//��ײ���
	public abstract boolean isCollision(AbstractBall ball);
	
	//��ײ��ı�С���˶�����
	public abstract void changeDirect(AbstractBall ball);
	
	//������ײ
	public default void handleCollision(AbstractBall ball) {
		if(isCollision(ball)) {
			changeDirect(ball);
		}
	}
}

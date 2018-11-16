package gizmo;

public interface ICollisionBody {
	//��ײ���
	public abstract boolean isCollision(Ball ball);
	
	//��ײ��ı�С���˶�����
	public abstract void changeDirect(Ball ball);
	
	//������ײ
	public default void handleCollision(Ball ball) {
		if(isCollision(ball)) {
			changeDirect(ball);
		}
	}
}

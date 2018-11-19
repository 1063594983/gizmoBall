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
			return true;
		}
		return false;
	}
}

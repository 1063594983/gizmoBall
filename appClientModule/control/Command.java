package control;

import gizmo.AbstractShape;

public abstract class Command {
	
	//��ǰ�����������״
	public AbstractShape shape;
	
	public String name = "default";
	
	public abstract void execute();
}

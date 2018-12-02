package control;

import gizmo.AbstractShape;

public abstract class Command {
	
	//当前命令操作的形状
	public AbstractShape shape;
	
	public String name = "default";
	
	public abstract void execute();
}

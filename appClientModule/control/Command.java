package control;

import gizmo.AbstractShape;

public abstract class Command {
	public AbstractShape shape;
	
	public abstract void execute();
}

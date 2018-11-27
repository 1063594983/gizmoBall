package control;

import UI.AnimationWindow;

public class RotateCommand extends Command {
	public RotateCommand() {
		this.name = "rotate";
	}

	@Override
	public void execute() {
		AnimationWindow.getInstance().rotateShape(this.shape);
	}
}

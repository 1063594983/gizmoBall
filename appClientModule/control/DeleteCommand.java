package control;

import UI.AnimationWindow;

public class DeleteCommand extends Command {
	
	public DeleteCommand() {
		this.name = "delete";
	}

	@Override
	public void execute() {
		AnimationWindow.getInstance().removeShape(this.shape);
	}

}

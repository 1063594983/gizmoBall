package control;

import UI.AnimationWindow;

public class RunCommand extends Command {
	class RunMode {
		static final int PALY = 0;
		static final int PAUSE = 1;
	}
	private int mode;
	public RunCommand(int mode) {
		// TODO Auto-generated constructor stub
		this.mode = mode;
	}
	public void execute() {
		if(mode == RunMode.PALY) {
			AnimationWindow.getInstance().setMode(true);
		} else {
			AnimationWindow.getInstance().setMode(false);
		}
	}
}

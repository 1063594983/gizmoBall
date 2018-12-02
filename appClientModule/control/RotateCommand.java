package control;

public class RotateCommand extends Command {
	public RotateCommand() {
		this.name = "rotate";
	}

	@Override
	public void execute() {
		this.shape.rotate();
	}
}

package control;

public class AddBallCommand extends Command {
	
	public AddBallCommand() {
		this.name = "addBall";
	}

	@Override
	public void execute() {
		this.name = "addBall";
	}

}

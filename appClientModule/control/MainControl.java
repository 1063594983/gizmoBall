package control;

public class MainControl {
	
	//当前执行的命令
	private static Command command;
	
	public static void setCommand(Command command) {
		MainControl.command = command;
	}
	
	public static Command getCommand() {
		return MainControl.command;
	}
	
	public static void action() {
		if(MainControl.command != null) {
			MainControl.command.execute();
		}		
	}
}

package smpl.sys.commands;

public class PrintCommand implements ICommand {
    
    String _message;

    // TODO: Will need to change to accommodate array of strings and expressions
    public PrintCommand(String message) {
        _message = message;
    }

    @Override
    public void execute() {
        System.out.println(_message);
    }
}

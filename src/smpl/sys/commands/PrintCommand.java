package smpl.sys.commands;

import smpl.sys.util.ProgramState;

public class PrintCommand implements ICommand {
    
    String _message;

    // TODO: Will need to change to accommodate array of strings and expressions
    public PrintCommand(String message) {
        _message = message;
    }

    @Override
    public void execute(ProgramState state) {
        System.out.println(_message);
    }
}

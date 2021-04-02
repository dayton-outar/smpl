package smpl.sys.commands;

import smpl.sys.util.ProgramState;

public class ReadCommand implements ICommand {
    
    String _var;
    public ReadCommand(String var) {
        _var = var;
    }

    @Override
    public void execute(ProgramState state) {
        System.out.println("READ INTO " + _var);       
    }
}

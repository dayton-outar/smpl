package smpl.sys.commands;

import smpl.sys.util.ProgramState;

public interface ICommand {
    
    public void execute(ProgramState state);
}

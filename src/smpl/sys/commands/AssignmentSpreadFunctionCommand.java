package smpl.sys.commands;

import java.util.Vector;

import smpl.sys.util.ProgramState;

public class AssignmentSpreadFunctionCommand implements ICommand {
    
    String _var;
    String _spreadParameter;
    Vector<ICommand> _statements;

    public AssignmentSpreadFunctionCommand(String var, String spreadParameter, Vector<ICommand> statements) {
        _var = var;
        _spreadParameter = spreadParameter;
        _statements = statements;  
    }

    @Override
    public void execute(ProgramState state) {
        
    }
}

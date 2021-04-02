package smpl.sys.commands;

import java.util.Vector;

import smpl.sys.util.ProgramState;

public class AssignmentFunctionCommand implements ICommand {

    String _var;
    Vector<String> _parameters;
    Vector<ICommand> _statements;

    public AssignmentFunctionCommand(String var, Vector<String> parameters, Vector<ICommand> statements) {
        _var = var;
        _parameters = parameters;
        _statements = statements;
    }

    @Override
    public void execute(ProgramState state) {
        // Adapted from https://beginnersbook.com/2014/07/how-to-convert-vector-to-string-array-in-java/
        System.out.println("CMD " + _var + " = (" + String.join(", ", _parameters.toArray(new String[_parameters.size()])) + ") {\n" + _statements.toString() + "\n}");
    }
    
}

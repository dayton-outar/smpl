package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.values.FunctionValue;
import smpl.sys.values.IValue;

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
    public void execute(Hashtable<String, IValue> dictionary) {
        IValue _function = new FunctionValue(_var, _parameters, _statements);

        dictionary.put(_var, _function);
    }    
}

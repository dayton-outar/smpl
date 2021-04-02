package smpl.sys.commands;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.values.IValue;
import smpl.sys.values.FunctionValue;

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
    public void execute(Hashtable<String, IValue> dictionary) {
        // TODO: Parameter list must be dynamic
        Vector<String> _parameters = new Vector<String>();
        IValue _function = new FunctionValue(_var, _parameters, _statements);

        dictionary.put(_var, _function);
    }
}

package smpl.sys.values;

import java.util.Vector;

import smpl.sys.commands.ICommand;

public class FunctionValue implements IValue {
    
    String _var;
    Vector<String> _parameters;
    Vector<ICommand> _statements;

    public FunctionValue(String var, Vector<String> parameters, Vector<ICommand> statements) {
        _var = var;
        _parameters = parameters;
        _statements = statements;
    }

    public Vector<String> getParameters() {
        return _parameters;
    }

    public Vector<ICommand> getStatements() {
        return _statements;
    }

    public String toString() {
        return _var + " = (" + String.join(", ", _parameters.toArray(new String[_parameters.size()])) + ") { \n" + 
                String.join("\n", _statements.toArray(new String[_statements.size()]) ) + "\n}";
    }
}

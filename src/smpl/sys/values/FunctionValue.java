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

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public boolean isLong() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public boolean booleanValue() {
        return false;
    }

    @Override
    public IValue add(IValue val) {
        return null;
    }
}

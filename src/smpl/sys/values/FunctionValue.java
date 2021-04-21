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
    public Vector<IValue> arrayValues() {
        return null;
    }

    @Override
    public IValue add(IValue val) throws Exception {
        return null;
    }

    @Override
    public IValue sub(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue mul(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue div(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue mod(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue pow(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue ban(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue bor(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue bxr(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue biv() {
        return null;
    }

    @Override
    public IValue inc() {
        return null;
    }

    @Override
    public IValue dec() {
        return null;
    }

    @Override
    public IValue inv() {
        return null;
    }

    @Override
    public IValue sqr() {
        return null;
    }

    @Override
    public IValue eq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue gt(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue lt(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue noteq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue gtoreq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue ltoreq(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue and(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue or(IValue val) throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }

    @Override
    public IValue not() throws Exception {
        throw new Exception("Implementation does not exist for this type");
    }
}

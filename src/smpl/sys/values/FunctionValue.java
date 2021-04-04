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
    public IValue add(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sub(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mul(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue div(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue mod(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue pow(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ban(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bor(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue bxr(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue biv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue inc() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue dec() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue inv() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue sqr() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue eq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gt(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue lt(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue noteq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue gtoreq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IValue ltoreq(IValue val) {
        // TODO Auto-generated method stub
        return null;
    }
}

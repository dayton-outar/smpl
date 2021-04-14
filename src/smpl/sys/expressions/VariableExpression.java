package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public class VariableExpression implements IExpression {

    String _var;

    public VariableExpression(String var) {
        _var = var;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return dictionary.get(_var);
    }    
}

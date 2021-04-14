package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public class QueryExpression implements IExpression {
    
    IExpression _condition;
    IExpression _exp1;
    IExpression _exp2;

    public QueryExpression(IExpression condition, IExpression exp1, IExpression exp2) {
        _condition = condition;
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return _condition.evaluate(dictionary).booleanValue() ? _exp1.evaluate(dictionary) : _exp2.evaluate(dictionary);
    }
}

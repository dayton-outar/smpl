package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public class LogicalOrExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public LogicalOrExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return _exp1.evaluate(dictionary).or(  _exp2.evaluate(dictionary) );
    }
    
}

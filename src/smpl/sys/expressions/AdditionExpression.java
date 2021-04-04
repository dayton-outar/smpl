package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

/**
 * Embodies the sum of two expressions
 */
public class AdditionExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public AdditionExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) {
        return _exp1.evaluate(dictionary).add( _exp2.evaluate(dictionary) );
    }
}

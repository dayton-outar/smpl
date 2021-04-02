package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.INumValue;

public class LesserThanOrEqualsExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public LesserThanOrEqualsExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) {
        return ((INumValue)_exp1.evaluate(dictionary)).ltoreq((INumValue)_exp2.evaluate(dictionary));
    }
    
}
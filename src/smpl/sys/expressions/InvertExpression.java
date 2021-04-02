package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.INumValue;

public class InvertExpression implements IExpression {
    
    IExpression _exp;
    
    public InvertExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) {
        return ( (INumValue)_exp.evaluate(dictionary) ).inv();
    }    
}

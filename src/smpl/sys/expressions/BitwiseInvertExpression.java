package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public class BitwiseInvertExpression implements IExpression {
    
    IExpression _exp;

    public BitwiseInvertExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return _exp.evaluate(dictionary).biv();
    }
}

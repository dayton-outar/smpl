package smpl.sys.expressions;

import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class BitwiseInvertExpression implements IExpression {
    
    IExpression _exp;

    public BitwiseInvertExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public IValue evaluate() {
        return ( (INumValue)_exp.evaluate() ).biv();
    }
}

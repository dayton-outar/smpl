package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.INumValue;

public class BitwiseXorExpression implements IExpression {
    
    IExpression _exp1;
    IExpression _exp2;

    public BitwiseXorExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate() {
        return ((INumValue)_exp1.evaluate()).bxr((INumValue)_exp2.evaluate());
    }
}

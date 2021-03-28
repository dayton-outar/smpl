package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.INumValue;

public class NotEqualsExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public NotEqualsExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate() {
        return ((INumValue)_exp1.evaluate()).noteq((INumValue)_exp2.evaluate());
    }
    
}
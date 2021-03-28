package smpl.sys.expressions;

import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class SubtractionExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public SubtractionExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate() {
        return ((INumValue)_exp1.evaluate()).sub((INumValue)_exp2.evaluate());
    }
}

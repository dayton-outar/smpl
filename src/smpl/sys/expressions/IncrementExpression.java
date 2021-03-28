package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.INumValue;

public class IncrementExpression implements IExpression {
    
    IExpression _exp;

    public IncrementExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public IValue evaluate() {
        return ( (INumValue)_exp.evaluate() ).inc();
    }
}

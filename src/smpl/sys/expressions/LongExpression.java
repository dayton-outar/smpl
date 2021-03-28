package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class LongExpression implements IExpression {
    
    Long _num;

    public LongExpression(Long num) {
        _num = num;
    }

    @Override
    public IValue evaluate() {
        return new LongValue(_num);
    }
}

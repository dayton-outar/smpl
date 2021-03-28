package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.BooleanValue;

public class BooleanExpression implements IExpression {

    Boolean _val;

    public BooleanExpression(Boolean val) {
        _val = val;
    }

    @Override
    public IValue evaluate() {
        return new BooleanValue(_val);
    }
    
}

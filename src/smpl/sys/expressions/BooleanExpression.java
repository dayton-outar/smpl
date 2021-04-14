package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.BooleanValue;

public class BooleanExpression implements IExpression {

    Boolean _val;

    public BooleanExpression(Boolean val) {
        _val = val;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return new BooleanValue(_val);
    }
    
}

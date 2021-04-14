package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.DoubleValue;
import smpl.sys.values.IValue;

public class DoubleExpression implements IExpression {
    
    Double _num;

    public DoubleExpression(Double num) {
        _num = num;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return new DoubleValue(_num);
    }
}

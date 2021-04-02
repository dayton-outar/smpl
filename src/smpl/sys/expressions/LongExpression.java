package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class LongExpression implements IExpression {
    
    Long _num;

    public LongExpression(Long num) {
        _num = num;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) {
        return new LongValue(_num);
    }
}

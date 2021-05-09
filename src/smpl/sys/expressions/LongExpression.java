package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class LongExpression implements IExpression {
    
    Long _num;
    String _exp;
    int _radix;

    public LongExpression(Long num) {
        _radix = 10;
        _num = num;
    }

    public LongExpression(String exp, int radix) {
        _radix = radix;
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        if (_radix != 10) {
            _num = Long.parseLong(_exp, _radix);
        }
        return new LongValue(_num, _radix);
    }
}

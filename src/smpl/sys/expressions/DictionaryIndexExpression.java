package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class DictionaryIndexExpression implements IExpression {
    
    String _var;
    String _ix;

    public DictionaryIndexExpression(String var, String ix) {
        _var = var;
        _ix = ix;
    }

    @Override
    public IValue evaluate() {
        return new LongValue(Long.valueOf(7)); // TODO: Get value of dictionary index from heap
    }
}
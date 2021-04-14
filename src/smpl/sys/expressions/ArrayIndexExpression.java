package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class ArrayIndexExpression implements IExpression {
    
    String _var;
    IExpression _exp;

    public ArrayIndexExpression(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        // TODO: Evaluate the index. Get the array from the heap and then evaluate the index of that array ... or send back the value        
        return new LongValue(Long.valueOf(1)); // TODO: Get value of array index from heap
    }
}

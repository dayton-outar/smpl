package smpl.sys.expressions;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;
import smpl.sys.values.ArrayValue;

public class ArrayInitializationExpression implements IExpression {

    IExpression _num;
    String _var;
    IExpression _exp;
    
    public ArrayInitializationExpression(IExpression num, String var, IExpression exp) {
        _num = num;
        _var = var;
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        Vector<IValue> vals = new Vector<IValue>();
        Hashtable<String, IValue> aid = new Hashtable<String, IValue>();
        aid.putAll(dictionary); // Include global scope
        
        long size =_num.evaluate(dictionary).longValue();
        for (long x = 0; x < size; x++) {
            aid.put(_var, new LongValue(x));
            vals.add(_exp.evaluate(aid));
        }

        return new ArrayValue(vals);
    }
}

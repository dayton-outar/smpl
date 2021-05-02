package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class SigmaNotationExpression implements IExpression {
    
    IExpression _last;
    IExpression _first;
    String _var;
    IExpression _exp;
    
    public SigmaNotationExpression(IExpression last, IExpression first, String var, IExpression exp) {
        _last = last;
        _first = first;
        _var = var;
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        IValue sr = new LongValue(0l);
        Hashtable<String, IValue> aid = new Hashtable<String, IValue>();
        aid.putAll(dictionary); // Include global scope
        
        long last = _last.evaluate(dictionary).longValue();
        long first = _first.evaluate(dictionary).longValue();
        for (long x = first; x <= last; x++) {
            aid.put(_var, new LongValue(x));
            sr = sr.add(_exp.evaluate(aid));
        }

        return sr;
    }
}

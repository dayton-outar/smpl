package smpl.sys.expressions;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.values.ArrayValue;
import smpl.sys.values.IValue;

public class ArrayExpression implements IExpression {

    Vector<IExpression> _expressions;

    public ArrayExpression(Vector<IExpression> expressions) {
        _expressions = expressions;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        Vector<IValue> vals = new Vector<IValue>();
        for (IExpression _exp : _expressions) {
            IValue av = _exp.evaluate(dictionary);
            if (av.isArray()) {
                vals.addAll( av.arrayValues() );
            } else {
                vals.add( av );
            }
        }

        return new ArrayValue(vals);
    }
    
}

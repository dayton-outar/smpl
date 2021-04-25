package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class SizeOfExpression implements IExpression {
    
    String _var;

    public SizeOfExpression(String var) {
        _var = var;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        LongValue size = new LongValue(0l);
        IValue val = dictionary.get(_var);

        if ( val.isArray() ) {
            size = new LongValue( (long) val.arrayValues().size() );
        }

        return size;
    }
}

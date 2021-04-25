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
        IValue rval;
        IValue val = dictionary.get(_var);
        LongValue index = new LongValue( _exp.evaluate(dictionary).longValue() );

        if ( val.isArray() ) {
            int ix = (int) index.longValue();

            if ( ix >= 0 || ix <= (val.arrayValues().size() - 1) ) {
                rval = val.arrayValues().get( (int) index.longValue() );
            } else
                throw new Exception("Index is out of bounds");            
        } else
            throw new Exception("Data type not appropriate for finding index");

        return rval;
    }
}

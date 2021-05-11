package smpl.sys.expressions;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.values.IValue;

public class ComplexDataIndexExpression implements IExpression {
    
    String _var;
    Vector<IExpression> _indexes;

    public ComplexDataIndexExpression(String var, Vector<IExpression> indexes) {
        _var = var;
        _indexes = indexes;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        IValue rval = dictionary.get(_var);

        for (IExpression _exp : _indexes) {
            IValue index = _exp.evaluate(dictionary);

            if ( rval.isArray() ) {
                int ix = (int) index.longValue();
    
                if ( ix >= 0 && ix <= (rval.arrayValues().size() - 1) ) {
                    rval = rval.arrayValues().get( (int) index.longValue() );
                } else
                    throw new Exception("Index is out of bounds");
    
            } else if ( rval.isDictionary() ) {
    
                rval = rval.getDictionary().get( index.toString() ).evaluate(dictionary);
    
            } else
                throw new Exception("Data type not appropriate for finding index");   
        }

        return rval;
    }
}

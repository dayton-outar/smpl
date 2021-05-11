package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;

public class DictionaryIndexExpression implements IExpression {
    
    String _var;
    String _ix;

    public DictionaryIndexExpression(String var, String ix) {
        _var = var;
        _ix = ix;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        IValue rval = dictionary.get(_var);

        if ( rval.isDictionary() ) {
            rval = rval.getDictionary().get(_ix).evaluate(dictionary);   
        } else
            throw new Exception("Data type not appropriate for finding index");

        return rval;
    }
}

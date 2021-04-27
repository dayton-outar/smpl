package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.DictionaryValue;
import smpl.sys.values.IValue;

public class DictionaryExpression implements IExpression {

    Hashtable<String, IExpression> _expressions;

    public DictionaryExpression(Hashtable<String, IExpression> expressions) {
        _expressions = expressions;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {        
        return new DictionaryValue(_expressions, dictionary);
    }
    
}

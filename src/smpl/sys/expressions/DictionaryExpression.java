package smpl.sys.expressions;

import java.beans.Expression;
import java.util.Hashtable;

import smpl.sys.values.IValue;

public class DictionaryExpression implements IExpression {

    Hashtable<String, IExpression> _expressions;

    public DictionaryExpression(Hashtable<String, IExpression> expressions) {
        _expressions = expressions;
    }

    @Override
    public IValue evaluate() {
        return null;
    }
    
}

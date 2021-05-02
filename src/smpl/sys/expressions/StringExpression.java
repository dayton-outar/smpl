package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.StringValue;

public class StringExpression implements IExpression {

    String _characters;

    public StringExpression(String characters) {
        _characters = characters;
    }
    
    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        return new StringValue(_characters);
    }
}

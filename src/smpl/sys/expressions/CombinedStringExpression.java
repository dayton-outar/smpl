package smpl.sys.expressions;

import java.util.Hashtable;
import java.util.Vector;

import smpl.sys.values.IValue;
import smpl.sys.values.StringValue;

public class CombinedStringExpression implements IExpression {

    Vector<IExpression> _expressions;

    public CombinedStringExpression(Vector<IExpression> expressions) {
        _expressions = expressions;
    }

    public CombinedStringExpression add(IExpression expression) {
        _expressions.add( expression );

        return new CombinedStringExpression(_expressions);
    }
    
    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) throws Exception {
        StringBuffer sb = new StringBuffer();
        
        for (IExpression ie : _expressions) {
            sb.append(ie.evaluate(dictionary));
        }

        return new StringValue(sb.toString());
    }
    
}

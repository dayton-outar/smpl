package smpl.sys.expressions;

import java.util.Vector;

import smpl.sys.values.IValue;

public class ArrayExpression implements IExpression {

    Vector<IExpression> _expressions;

    public ArrayExpression(Vector<IExpression> expressions) {
        _expressions = expressions;
    }

    @Override
    public IValue evaluate() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

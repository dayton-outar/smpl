package smpl.sys.expressions;

public class BooleanExpression implements IExpression {

    Boolean _val;

    public BooleanExpression(Boolean val) {
        _val = val;
    }

    @Override
    public Object evaluate() {
        return _val;
    }
    
}

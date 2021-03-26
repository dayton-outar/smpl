package smpl.sys.expressions;

public class BitwiseInvertExpression implements IExpression {
    
    IExpression _exp;

    public BitwiseInvertExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public Object evaluate() {
        // TODO Auto-generated method stub
        // ~
        return null;
    }
}

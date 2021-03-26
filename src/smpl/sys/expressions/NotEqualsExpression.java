package smpl.sys.expressions;

public class NotEqualsExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public NotEqualsExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

package smpl.sys.expressions;

public class GreaterThanOrEqualsExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public GreaterThanOrEqualsExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

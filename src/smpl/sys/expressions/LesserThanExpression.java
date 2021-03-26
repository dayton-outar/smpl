package smpl.sys.expressions;

public class LesserThanExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public LesserThanExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        // TODO Auto-generated method stub
        // e1 < e2
        return null;
    }
    
}

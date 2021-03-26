package smpl.sys.expressions;

public class LogicalOrExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public LogicalOrExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        Object obj1 = _exp1.evaluate();
        Object obj2 = _exp2.evaluate();

        Boolean r = Boolean.logicalOr(Boolean.valueOf(obj1.toString()), Boolean.valueOf(obj2.toString()));
        
        return r;
    }
    
}

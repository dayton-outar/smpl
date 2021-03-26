package smpl.sys.expressions;

public class LogicalNotExpression implements IExpression {

    IExpression _exp;
    
    public LogicalNotExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public Object evaluate() {
        Object obj = _exp.evaluate();
        
        Boolean r = !Boolean.valueOf(obj.toString());

        return r;
    }
    
}

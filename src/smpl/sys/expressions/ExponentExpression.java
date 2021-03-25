package smpl.sys.expressions;

public class ExponentExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public ExponentExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        Object obj1 = _exp1.evaluate();
        Object obj2 = _exp2.evaluate();
        
        Double result = Math.pow( Double.valueOf(obj1.toString()), Double.valueOf(obj2.toString()) );
        double remainder = result % 1;

        Object r;

        if (remainder == 0.0) {
            r = result.longValue();
        } else {
            r = result;
        }

        return r;
    }
    
}

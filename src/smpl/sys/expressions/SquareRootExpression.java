package smpl.sys.expressions;

public class SquareRootExpression implements IExpression {
    
    IExpression _exp;

    public SquareRootExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public Object evaluate() {
        Object obj = _exp.evaluate();
        Object result = new Object();

        if (obj instanceof Double) {
            Double number = Double.valueOf(obj.toString());
            result = Math.sqrt(number.doubleValue());
        } else {
            Long number = Long.valueOf(obj.toString());
            result = Math.sqrt(number.doubleValue());
        }

        return result;
    }
}

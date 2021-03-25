package smpl.sys.expressions;

public class DecrementExpression implements IExpression {
    
    IExpression _exp;

    public DecrementExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public Object evaluate() {
        Object obj = _exp.evaluate();
        Object result = new Object();

        if (obj instanceof Double) {
            double number = Double.parseDouble(obj.toString());
            number--;
            result = number;
        } else {
            long number = Long.parseLong(obj.toString());
            number--;
            result = number;
        }

        return result;
    }
}

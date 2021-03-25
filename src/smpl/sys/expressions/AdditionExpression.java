package smpl.sys.expressions;

/**
 * Embodies the sum of two expressions
 */
public class AdditionExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public AdditionExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        Object obj1 = _exp1.evaluate();
        Object obj2 = _exp2.evaluate();

        return ( obj1 instanceof Long ? Long.valueOf(obj1.toString()) : Double.valueOf(obj1.toString()) ) + ( obj2 instanceof Long ? Long.valueOf(obj2.toString()) : Double.valueOf(obj2.toString()) );
    }    
}

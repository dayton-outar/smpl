package smpl.sys;

public class ModulusExpression implements IExpression {
    
    IExpression _exp1;
    IExpression _exp2;

    public ModulusExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public Object evaluate() {
        Object obj1 = _exp1.evaluate();
        Object obj2 = _exp2.evaluate();

        return ( obj1 instanceof Long ? Long.parseLong(obj1.toString()) : Double.parseDouble(obj1.toString()) ) % ( obj2 instanceof Long ? Long.parseLong(obj2.toString()) : Double.parseDouble(obj2.toString()) );
    }
}

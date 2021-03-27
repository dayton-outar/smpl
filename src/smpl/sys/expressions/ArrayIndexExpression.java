package smpl.sys.expressions;

public class ArrayIndexExpression implements IExpression {
    
    String _var;
    IExpression _exp;

    public ArrayIndexExpression(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public Object evaluate() {
        // TODO: Evaluate the index. Get the array from the heap and then evaluate the index of that array ... or send back the value
        Object ix = _exp.evaluate();
        
        return 1;
    }
}

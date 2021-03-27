package smpl.sys.expressions;

import java.util.Vector;

public class FunctionExpression implements IExpression {

    String _function;
    Vector<IExpression> _parameters;
    
    public FunctionExpression(String function, Vector<IExpression> parameters) {
        _function = function;
        _parameters = parameters;
    }

    @Override
    public Object evaluate() {
        // TODO: Evaluate parameters. Find function body from either stack or heap and execute and return the value of that.
        // The scope is decided here
        return 5;
    }
}

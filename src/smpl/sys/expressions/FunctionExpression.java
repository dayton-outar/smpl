package smpl.sys.expressions;

import java.util.Vector;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class FunctionExpression implements IExpression {

    String _function;
    Vector<IExpression> _parameters;
    
    public FunctionExpression(String function, Vector<IExpression> parameters) {
        _function = function;
        _parameters = parameters;
    }

    @Override
    public IValue evaluate() {
        // TODO: Evaluate parameters. Find function body from either stack or heap and execute and return the value of that.
        // The scope is decided here
        return new LongValue(Long.valueOf(7)); // TODO: Get value of function from heap
    }
}
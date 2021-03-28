package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.LongValue;

public class VariableExpression implements IExpression {

    String _var;

    public VariableExpression(String var) {
        _var = var;
    }

    @Override
    public IValue evaluate() {
        return new LongValue(Long.valueOf(5)); // TODO: Get value of variable from heap
    }    
}

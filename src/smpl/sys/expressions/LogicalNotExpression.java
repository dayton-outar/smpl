package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.ILogicValue;

public class LogicalNotExpression implements IExpression {

    IExpression _exp;
    
    public LogicalNotExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public IValue evaluate() {
        return ((ILogicValue)_exp.evaluate()).not();
    }
    
}

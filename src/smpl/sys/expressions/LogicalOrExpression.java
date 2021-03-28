package smpl.sys.expressions;

import smpl.sys.values.IValue;
import smpl.sys.values.ILogicValue;

public class LogicalOrExpression implements IExpression {

    IExpression _exp1;
    IExpression _exp2;

    public LogicalOrExpression(IExpression exp1, IExpression exp2) {
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public IValue evaluate() {        
        return ((ILogicValue)_exp1.evaluate()).or( (ILogicValue) _exp2.evaluate());
    }
    
}

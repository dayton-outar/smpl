package smpl.sys.expressions;

import java.util.Hashtable;

import smpl.sys.values.IValue;
import smpl.sys.values.ILogicValue;

public class LogicalNotExpression implements IExpression {

    IExpression _exp;
    
    public LogicalNotExpression(IExpression exp) {
        _exp = exp;
    }

    @Override
    public IValue evaluate(Hashtable<String, IValue> dictionary) {
        return ((ILogicValue)_exp.evaluate(dictionary)).not();
    }
    
}

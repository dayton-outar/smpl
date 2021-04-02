package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class DecrementCommand implements ICommand {
    
    IExpression _exp;

    public DecrementCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        IValue val = ( (INumValue)_exp.evaluate( dictionary )).dec();
        dictionary.put("__return", val); // Re-set as return value
    }
}

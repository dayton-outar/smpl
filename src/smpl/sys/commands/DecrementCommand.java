package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class DecrementCommand implements ICommand {
    
    IExpression _exp;

    public DecrementCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        IValue val = _exp.evaluate( dictionary ).dec();
        dictionary.put("__return", val); // Re-set as return value
    }
}

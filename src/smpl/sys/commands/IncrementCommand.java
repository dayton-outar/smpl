package smpl.sys.commands;


import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class IncrementCommand implements ICommand {
    
    IExpression _exp;

    public IncrementCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {        
        IValue val = ( (INumValue)_exp.evaluate( dictionary ) ).inc();
        // TODO: Missing assignment to put back into dictionary
        dictionary.put("__return", val); // Re-set as return value
    }
}

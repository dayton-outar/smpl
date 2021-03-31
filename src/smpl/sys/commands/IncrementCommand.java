package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class IncrementCommand implements ICommand {
    
    IExpression _exp;

    public IncrementCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute() {
        IValue val = ( (INumValue)_exp.evaluate() ).inc();

        System.out.println(val.toString());
    }
}

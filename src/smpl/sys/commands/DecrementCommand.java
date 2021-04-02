package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.ProgramState;
import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class DecrementCommand implements ICommand {
    
    IExpression _exp;

    public DecrementCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute(ProgramState state) {
        IValue val = ( (INumValue)_exp.evaluate( state.getDictionary() )).dec();

        System.out.println(val.toString());
    }
}

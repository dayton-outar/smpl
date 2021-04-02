package smpl.sys.commands;


import smpl.sys.expressions.IExpression;
import smpl.sys.util.ProgramState;
import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class IncrementCommand implements ICommand {
    
    IExpression _exp;

    public IncrementCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute(ProgramState state) {        
        IValue val = ( (INumValue)_exp.evaluate( state.getDictionary() ) ).inc();

        System.out.println(val.toString());
    }
}

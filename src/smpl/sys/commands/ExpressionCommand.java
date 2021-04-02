package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.ProgramState;
import smpl.sys.values.IValue;

public class ExpressionCommand implements ICommand {
    
    IExpression _exp;

    public ExpressionCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute(ProgramState state) {
        IValue val = _exp.evaluate(state.getDictionary());

        // TODO: Replace print screen with placing value in heap or stack for return to calling statement
        System.out.println(val.toString());
    }
}

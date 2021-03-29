package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class ExpressionCommand implements ICommand {
    
    IExpression _exp;

    public ExpressionCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute() {
        IValue obj = _exp.evaluate();

        // TODO: Replace print screen with placing value in heap or stack for return to calling statement
        System.out.println(obj.toString());
    }
}

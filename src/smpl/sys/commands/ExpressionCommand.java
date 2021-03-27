package smpl.sys.commands;

import smpl.sys.expressions.IExpression;

public class ExpressionCommand implements ICommand {
    
    IExpression _exp;

    public ExpressionCommand(IExpression exp) {
        _exp = exp;
    }

    @Override
    public void execute() {
        Object obj = _exp.evaluate();

        // TODO: Replace print screen with placing value in heap or stack for return to calling statement
        System.out.println(obj.toString());
    }
}

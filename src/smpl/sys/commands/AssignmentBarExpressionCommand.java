package smpl.sys.commands;

import smpl.sys.expressions.IExpression;

public class AssignmentBarExpressionCommand implements ICommand {
    
    String _var;
    IExpression _exp;

    public AssignmentBarExpressionCommand(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
}

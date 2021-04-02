package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.ProgramState;

public class AssignmentMulExpressionCommand implements ICommand {
    
    String _var;
    IExpression _exp;

    public AssignmentMulExpressionCommand(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public void execute(ProgramState state) {
        // TODO Auto-generated method stub
        
    }
}

package smpl.sys.commands;

import java.util.Vector;

import smpl.sys.expressions.IExpression;
import smpl.sys.util.Cases;
import smpl.sys.util.ProgramState;

public class CasesCommand implements ICommand {
    
    IExpression _exp;
    Vector<Cases> _cases;

    public CasesCommand(IExpression exp, Vector<Cases> cases) {
        _exp = exp;
        _cases = cases;
    }

    @Override
    public void execute(ProgramState state) {
        // TODO Auto-generated method stub
        
    }
}

package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.ILogicValue;
import smpl.sys.values.IValue;

public class IfCommand implements ICommand {
    
    IExpression _condition;
    IExpression _exp;

    public IfCommand(IExpression condition, IExpression exp) {
        _condition = condition;
        _exp = exp;
    }

    @Override
    public void execute() {
        
        if ( ((ILogicValue)_condition.evaluate()).booleanValue() ) {
            IValue val = _exp.evaluate();

            System.out.println("CMD " + _condition.evaluate().toString() +" ? " + _exp.evaluate().toString() );
        }
        
        // TODO: I think the value should go onto the stack or something
    }
}

package smpl.sys.commands;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.ILogicValue;
import smpl.sys.values.IValue;

public class IfElseCommand implements ICommand {
    
    IExpression _condition;
    IExpression _exp1;
    IExpression _exp2;

    public IfElseCommand(IExpression condition, IExpression exp1, IExpression exp2) {
        _condition = condition;
        _exp1 = exp1;
        _exp2 = exp2;
    }

    @Override
    public void execute() {
        
        IValue val = ((ILogicValue)_condition.evaluate()).booleanValue() ? _exp1.evaluate() : _exp2.evaluate();

        System.out.println("CMD " + _condition.evaluate().toString() +" ? " + _exp1.evaluate().toString() + " : " + _exp2.evaluate().toString());
        
        // TODO: I think the value should go onto the stack or something
    }
    
}

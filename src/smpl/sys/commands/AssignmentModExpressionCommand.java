package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;
import smpl.sys.values.INumValue;

public class AssignmentModExpressionCommand implements ICommand {
    
    String _var;
    IExpression _exp;

    public AssignmentModExpressionCommand(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        dictionary.put(_var, ((INumValue)_exp.evaluate(dictionary)).mod((INumValue)dictionary.get(_var)) );
    }
}

package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.INumValue;
import smpl.sys.values.IValue;

public class AssignmentAddExpressionCommand implements ICommand {
    
    String _var;
    IExpression _exp;

    public AssignmentAddExpressionCommand(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) {
        dictionary.put(_var, ((INumValue)_exp.evaluate(dictionary)).add((INumValue)dictionary.get(_var)) );
    }
}

package smpl.sys.commands;

import java.util.Hashtable;

import smpl.sys.expressions.IExpression;
import smpl.sys.values.IValue;

public class AssignmentBarExpressionCommand implements ICommand {
    
    String _var;
    IExpression _exp;

    public AssignmentBarExpressionCommand(String var, IExpression exp) {
        _var = var;
        _exp = exp;
    }

    @Override
    public void execute(Hashtable<String, IValue> dictionary) throws Exception {
        dictionary.put(_var, _exp.evaluate(dictionary).bor( dictionary.get(_var) ) );
    }
}
